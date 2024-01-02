package fr.tmegemont.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostalCode implements EntityInterface {

    private Long id;

    private double code;

    private City city;

}
