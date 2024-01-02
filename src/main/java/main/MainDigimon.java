package main;

import fr.tmegemont.poec.entity.Digimon;
import fr.tmegemont.poec.service.DigimonApiService;
import fr.tmegemont.poec.service.Dump;

public class MainDigimon {

    public static void main(String[] args) {

        DigimonApiService das = new DigimonApiService();
        Dump.dump(das.getDigimon("Koromon"));
    }
}
