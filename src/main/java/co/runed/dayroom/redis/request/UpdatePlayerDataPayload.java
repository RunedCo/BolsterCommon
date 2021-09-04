package co.runed.dayroom.redis.request;

import co.runed.dayroom.redis.payload.RequestPayload;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UpdatePlayerDataPayload extends RequestPayload {
    public Map<UUID, String> playerData = new HashMap<>();
}
