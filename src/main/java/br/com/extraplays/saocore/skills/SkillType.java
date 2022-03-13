package br.com.extraplays.saocore.skills;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SkillType {

    MINING("Mineração"),
    WOODCUTTER("Lenhador"),
    FISHERMAN("Pescador"),
    FARMER("Fazendeiro");

    private final String name;


}
