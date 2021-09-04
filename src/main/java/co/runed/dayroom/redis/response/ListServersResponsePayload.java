package co.runed.dayroom.redis.response;

import co.runed.dayroom.ServerData;
import co.runed.dayroom.redis.payload.Payload;

import java.util.HashMap;
import java.util.Map;

public class ListServersResponsePayload extends Payload {
    public Map<String, ServerData> servers = new HashMap<>();
}
