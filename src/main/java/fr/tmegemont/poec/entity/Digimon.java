package fr.tmegemont.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Digimon {

    private Long id;

    private String name;

    private String img;

    private String level;

}
