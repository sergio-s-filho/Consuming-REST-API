package com.example.harrypotter.service;
import com.example.harrypotter.model.SpellsModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class SpellService {
   List<SpellsModel> spellsModels = new ArrayList<>();
   Integer id = 0;

   public List<SpellsModel> getAllSpells(){
       if(spellsModels.isEmpty()){
           String url = "https://hp-api.onrender.com/api/spells";
           RestTemplate restTemplate = new RestTemplate();
           SpellsModel[] object = restTemplate.getForObject(url,SpellsModel[].class);
           spellsModels.addAll(Arrays.asList(object));
           for(SpellsModel spell : spellsModels){
               spell.setId(id);
               id++;
           }
       }
       return spellsModels;
   }

   public SpellsModel addNewSpell(SpellsModel spellsModel){
       spellsModel.setId(id);
       spellsModels.add(spellsModel);
       id++;
       return spellsModel;
   }
}
