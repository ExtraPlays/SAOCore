package br.com.extraplays.saocore.data;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

public class PlayerManager {


    private final Map<UUID, PlayerData> PLAYERS = Maps.newHashMap();

    public void addPlayer(PlayerData data){
        PLAYERS.put(data.getId(), data);
    }

    public PlayerData getPlayer(UUID id){
        return PLAYERS.get(id);
    }

    public boolean containsPlayer(UUID id){
        return PLAYERS.containsKey(id);
    }


}
