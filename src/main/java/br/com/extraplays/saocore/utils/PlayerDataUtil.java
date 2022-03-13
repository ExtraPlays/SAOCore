package br.com.extraplays.saocore.utils;

import br.com.extraplays.saocore.data.PlayerSkill;
import br.com.extraplays.saocore.skills.SkillType;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataUtil {

    public static Map<SkillType, PlayerSkill> getDefaultSkills(){
        return new HashMap<SkillType, PlayerSkill>(){{
            for (SkillType value : SkillType.values()) {
                put(value, new PlayerSkill(value, 0, 1));
            }
        }};
    }




}
