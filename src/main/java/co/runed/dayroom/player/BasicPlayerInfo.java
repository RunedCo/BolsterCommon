package co.runed.dayroom.player;

import java.util.UUID;

public class BasicPlayerInfo {
    public UUID uuid;
    public String name;

    public BasicPlayerInfo(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
