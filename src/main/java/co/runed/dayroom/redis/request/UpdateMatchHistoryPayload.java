package co.runed.dayroom.redis.request;

import co.runed.dayroom.redis.payload.RequestPayload;

import java.util.UUID;

public class UpdateMatchHistoryPayload extends RequestPayload {
    public UUID matchId;
    public String json;
}
