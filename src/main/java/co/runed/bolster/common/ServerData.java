package co.runed.bolster.common;

import co.runed.bolster.common.player.BasicPlayerInfo;

import java.util.ArrayList;
import java.util.List;

public class ServerData {
    public String id;
    public String gameMode;
    public String name;
    public String iconMaterial = "LIME_WOOL";
    public String status;

    public String ipAddress;
    public int port;
    public boolean restricted = false;

    public int maxPlayers;
    public int maxPremiumPlayers;
    public List<BasicPlayerInfo> onlinePlayers = new ArrayList<>();

    public ServerData() {

    }

    public ServerData(String id, String gameMode, String name, String iconMaterial, String status, String ipAddress, int port, boolean restricted) {
        this.id = id;
        this.gameMode = gameMode;
        this.name = name;
        this.iconMaterial = iconMaterial;
        this.status = status;

        this.ipAddress = ipAddress;
        this.port = port;

        this.restricted = restricted;
    }
}
