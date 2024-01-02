package fr.tmegemont.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Department implements EntityInterface{

    private Long id;

    private Region region;

    private String name;

    private double code;

}
