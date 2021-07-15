package co.runed.bolster.common.redis;

public class RedisChannels
{
    /* Servers */
    public static final String REGISTER_SERVER = "RegisterServer";
    public static final String REGISTER_SERVER_RESPONSE = "RegisterServerResponse";

    public static final String UNREGISTER_SERVER = "UnregisterServer";
    public static final String UPDATE_SERVER = "UpdateServer";

    public static final String LIST_SERVERS = "ListServers";
    public static final String LIST_SERVERS_RESPONSE = "ListServersResponse";

    /* Player Data */
    public static final String REQUEST_PLAYER_DATA = "RequestPlayerData";
    public static final String REQUEST_PLAYER_DATA_RESPONSE = "RequestPlayerDataResponse";

    public static final String UPDATE_PLAYER_DATA = "UpdatePlayerData";
}
