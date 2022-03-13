package br.com.extraplays.saocore.data;

import br.com.extraplays.saocore.skills.SkillType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class PlayerData {

    private UUID id;
    private Map<SkillType, PlayerSkill> skills;

    public PlayerSkill getSkill(SkillType type){
        return  skills.get(type);
    }

}
