package co.runed.bolster.common.redis.payload;

import co.runed.bolster.common.gson.GsonUtil;
import com.google.gson.Gson;

public abstract class Payload {
    public String sender = null;
    public String target = null;

    public String toJson() {
        Gson gson = GsonUtil.create();

        return gson.toJson(this);
    }

    public static Payload fromJson(String json) {
        return fromJson(json, Payload.class);
    }

    public static <T extends Payload> T fromJson(String json, Class<T> type) {
        Gson gson = GsonUtil.create();

        return gson.fromJson(json, type);
    }
}
