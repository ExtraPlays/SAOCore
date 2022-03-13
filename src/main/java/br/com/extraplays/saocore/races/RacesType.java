package br.com.extraplays.saocore.races;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RacesType {

    HUMAN("Humano"),
    ELF("Elfo"),
    DARK_ELF("Elfo Negro"),
    DEMON("Demonio");

    private final String name;

}
