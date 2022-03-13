package br.com.extraplays.saocore.teleport;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

public class Teleport {

    @Getter @Setter
    Location location;

    @Getter @Setter
    int requiredLevel;

}
