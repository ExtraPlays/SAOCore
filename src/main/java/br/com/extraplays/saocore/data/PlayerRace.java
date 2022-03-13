package br.com.extraplays.saocore.data;

import br.com.extraplays.saocore.races.RacesType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class PlayerRace {

    private final RacesType type;
    private int level, xp;

}
