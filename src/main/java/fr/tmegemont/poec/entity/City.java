package fr.tmegemont.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City implements EntityInterface{

    private Long id;

    private Department department;

    private double siren;

    private double population;

    private String name;

    private double code;
}
