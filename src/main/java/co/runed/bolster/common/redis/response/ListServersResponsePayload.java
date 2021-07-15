package co.runed.bolster.common.redis.response;

import co.runed.bolster.common.ServerData;
import co.runed.bolster.common.redis.payload.Payload;

import java.util.HashMap;
import java.util.Map;

public class ListServersResponsePayload extends Payload
{
    public Map<String, ServerData> servers = new HashMap<>();
}
