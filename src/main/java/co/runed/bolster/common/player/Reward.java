package co.runed.bolster.common.player;

import java.util.Map;

public abstract class Reward
{
    String key;
    double amount;

    public Reward(String key, double amount)
    {
        this.key = key;
        this.amount = amount;
    }

    public abstract void onActivate(Map<String, Object> data);
}
