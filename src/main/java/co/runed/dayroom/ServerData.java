package co.runed.dayroom;

import co.runed.dayroom.player.BasicPlayerInfo;

import java.util.ArrayList;
import java.util.List;

public class ServerData {
    public String id;
    public String name;

    public String gameMode;
    public String gameModeName;

    public String iconMaterial = "BLUE_WOOL";
    public String status;

    public String ipAddress;
    public int port;
    public boolean hidden = false;

    public int maxPlayers;
    public int maxPremiumPlayers;
    public List<BasicPlayerInfo> onlinePlayers = new ArrayList<>();

    public ServerData() {

    }

    public ServerData(String id, String gameMode, String name, String iconMaterial, String status, String ipAddress, int port, boolean hidden) {
        this.id = id;
        this.gameMode = gameMode;
        this.name = name;
        this.iconMaterial = iconMaterial;
        this.status = status;

        this.ipAddress = ipAddress;
        this.port = port;

        this.hidden = hidden;
    }
}
