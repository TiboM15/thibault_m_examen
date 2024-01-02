package fr.tmegemont.poec.service;

import fr.tmegemont.poec.entity.Digimon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DigimonApiService {


    private HttpClientService httpClientService = new HttpClientService();

    public Digimon getDigimon(String name) {
        String url = "https://digimon-api.vercel.app/api/digimon";
        String json = httpClientService.get(url);
        if (json.isEmpty()) {
            return null;
        }
        JSONTokener tokener = new JSONTokener(json);
        JSONObject object = new JSONObject(tokener);

        Digimon digimon = new Digimon();
        digimon.setName(object.getString("name"));
        digimon.setImg(object.getString("img"));
        digimon.setLevel(object.getString("level"));



        return digimon;
    }
}
