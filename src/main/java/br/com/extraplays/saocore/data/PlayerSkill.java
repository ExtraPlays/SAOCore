package br.com.extraplays.saocore.data;

import br.com.extraplays.saocore.skills.SkillType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class PlayerSkill {

    private final SkillType type;
    private int xp, level;

}
