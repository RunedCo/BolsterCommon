package co.runed.dayroom.redis;

public class RedisChannels {
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

    /* TODO: Concept */
    // GRANT_REWARD
    // REQUEST_REWARDS
    // REQUEST_REWARDS_RESPONSE

    // REQUEST_NETWORK_STATS
    // REQUEST_NETWORK_STATS_RESPONSE

    // UPDATE_MATCH_HISTORY

    // UPDATE_SETTING
    // UNLOCK_SHOP_ITEM
    // UPDATE_CURRENCY
    // UPDATE_GAMEMODE_DATA
    // UPDATE_COOLDOWN
    // UPDATE_STATISTIC
}
