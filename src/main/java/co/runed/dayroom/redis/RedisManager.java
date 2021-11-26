package co.runed.dayroom.redis;

import co.runed.dayroom.redis.payload.Payload;
import co.runed.dayroom.util.StringUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;

public class RedisManager extends JedisPubSub {
    private static RedisManager _instance;

    JedisPool jedisPool;

    Jedis subRedis;
    Jedis pubRedis;
    BiConsumer<String, String> onMessageHandler = (ch, msg) -> {
    };

    String senderId = UUID.randomUUID().toString();
    String defaultTarget = null;

    List<String> channels = new ArrayList<>();

    public RedisManager(String redisHost, int redisPort, String redisUser, String redisPass, List<String> channels) {
        super();

        _instance = this;

        /* Connect to Redis */
        this.jedisPool = new JedisPool(redisHost, redisPort);
        this.channels = channels;
    }

    public void setup() {
        try {
            /* Creating Jedis object for connecting with redis server */
            subRedis = this.jedisPool.getResource();
            pubRedis = this.jedisPool.getResource();

            subRedis.subscribe(this, channels.toArray(new String[0]));
        }
        catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        finally {
            if (subRedis != null) {
                subRedis.close();
            }

            if (pubRedis != null) {
                pubRedis.close();
            }

            this.jedisPool.close();
        }
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setDefaultTarget(String defaultTarget) {
        this.defaultTarget = defaultTarget;
    }

    public String getDefaultTarget() {
        return defaultTarget;
    }

    public void setMessageHandler(BiConsumer<String, String> onMessageHandler) {
        this.onMessageHandler = onMessageHandler;
    }

    @Override
    public void onMessage(String channel, String message) {
        Payload payload = Payload.fromJson(message, PayloadImpl.class);

        if (payload.target == null || !StringUtil.wildcardMatch(getSenderId(), payload.target)) return;

        System.out.println("Channel " + channel + " has sent a message from " + payload.sender);

        this.onMessageHandler.accept(channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("Subscribed to channel: " + channel);
        System.out.println("Subscribed to " + subscribedChannels + " no. of channels");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("Unsubscribed from channel : " + channel);
        System.out.println("Subscribed to " + subscribedChannels + " no. of channels");
    }

    public void publish(String channel, Payload payload) {
        this.publish(this.getDefaultTarget(), channel, payload);
    }

    public void publish(String target, String channel, Payload payload) {
        payload.sender = this.getSenderId();
        if (target != null) payload.target = target;

        pubRedis.publish(channel, payload.toJson());
    }

    public String get(String key) {
        return pubRedis.get(key);
    }

    public void set(String key, String value) {
        pubRedis.set(key, value);
    }

    public void close() {
        this.subRedis.close();
        this.pubRedis.close();
        this.jedisPool.close();
    }

    public static RedisManager getInstance() {
        return _instance;
    }

    private static class PayloadImpl extends Payload {

    }
}
