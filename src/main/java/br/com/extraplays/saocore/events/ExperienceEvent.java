package br.com.extraplays.saocore.events;

import br.com.extraplays.saocore.data.PlayerData;
import br.com.extraplays.saocore.data.PlayerSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@AllArgsConstructor
@Getter
public class ExperienceEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private PlayerData data;
    private PlayerSkill skill;
    private int exp;

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
