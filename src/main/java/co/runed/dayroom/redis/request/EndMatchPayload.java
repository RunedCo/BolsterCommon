package co.runed.dayroom.redis.request;

import co.runed.dayroom.redis.payload.RequestPayload;

import java.util.UUID;

public class EndMatchPayload extends RequestPayload {
    public UUID matchId;

    public EndMatchPayload(UUID uuid) {
        matchId = uuid;
    }
}
