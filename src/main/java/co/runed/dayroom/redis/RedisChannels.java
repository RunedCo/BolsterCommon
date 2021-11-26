package co.runed.dayroom.redis;

public class RedisChannels {
    /* Servers */
    public static final String REGISTER_SERVER = "RegisterServer";
    public static final String REGISTER_SERVER_RESPONSE = response(REGISTER_SERVER);

    public static final String UNREGISTER_SERVER = "UnregisterServer";
    public static final String UPDATE_SERVER = "UpdateServer";

    public static final String LIST_SERVERS = "ListServers";
    public static final String LIST_SERVERS_RESPONSE = response(LIST_SERVERS);

    /* Player Data */
    public static final String REQUEST_PLAYER_DATA = "RequestPlayerData";
    public static final String REQUEST_PLAYER_DATA_RESPONSE = response(REQUEST_PLAYER_DATA);

    public static final String UPDATE_PLAYER_DATA = "UpdatePlayerData";

    /* Match History */
    public static final String REQUEST_MATCH_HISTORY_ID = "RequestMatchHistoryId";
    public static final String REQUEST_MATCH_HISTORY_ID_RESPONSE = response(REQUEST_MATCH_HISTORY_ID);

    public static final String UPDATE_MATCH_HISTORY = "UpdateMatchHistory";
    public static final String END_MATCH = "EndMatchHistory";

    private static String response(String input) {
        return input + "Response";
    }

    /* TODO: Concept */
    // GRANT_REWARD
    // REQUEST_REWARDS
    // REQUEST_REWARDS_RESPONSE

    // REQUEST_NETWORK_STATS
    // REQUEST_NETWORK_STATS_RESPONSE

    // UPDATE_SETTING
    // UNLOCK_SHOP_ITEM
    // UPDATE_CURRENCY
    // UPDATE_GAMEMODE_DATA
    // UPDATE_COOLDOWN
    // UPDATE_STATISTIC
}
