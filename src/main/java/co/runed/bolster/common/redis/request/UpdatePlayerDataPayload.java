package co.runed.bolster.common.redis.request;

import co.runed.bolster.common.redis.payload.RequestPayload;

import java.util.UUID;

public class UpdatePlayerDataPayload extends RequestPayload
{
    public UUID uuid;
    public String playerData;
}
