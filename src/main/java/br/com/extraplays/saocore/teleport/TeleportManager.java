package br.com.extraplays.saocore.teleport;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TeleportManager {

    public HashMap<String, Teleport> teleportsMap = new HashMap<>();


    public Teleport getTeleport(String name){

        return teleportsMap.get(name);

    }

    public Teleport newTeleport(String name, int level, Location location){

        Teleport teleport = new Teleport();
        teleport.setLocation(location);
        teleport.setRequiredLevel(level);

        teleportsMap.put(name, teleport);

        return teleport;

    }

    public boolean isTeleportArea(Player player){

        Location location = player.getLocation();

        Block block = location.subtract(0, 1, 0).getBlock();

        switch (block.getType()){
            case BLACKSTONE:
            case POLISHED_BLACKSTONE:
                return true;
            default:
                return false;
        }
    }


}
