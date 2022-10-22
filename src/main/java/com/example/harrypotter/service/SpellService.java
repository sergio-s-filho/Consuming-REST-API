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

   //GET METHOD
   public List<SpellsModel> getAllSpells(){
       if(spellsModels.isEmpty()){
           String url = "https://hp-api.onrender.com/api/spells";
           RestTemplate restTemplate = new RestTemplate();
           SpellsModel[] object = restTemplate.getForObject(url,SpellsModel[].class);
           spellsModels.addAll(Arrays.asList(object));
           updateId();
       }
       return spellsModels;
   }

   //POST METHOD
   public SpellsModel addNewSpell(SpellsModel spellsModel){
       spellsModels.add(spellsModel);
       updateId();
       return spellsModel;
   }

   //PUT METHOD
   public SpellsModel updateSpell(Integer id, SpellsModel spellModel){
       SpellsModel spellModelTemp = spellsModels.get(id);
       spellModelTemp.setName(spellModel.getName());
       spellModelTemp.setDescription(spellModel.getDescription());
       return spellModelTemp;
   }
   //DELETE METHOD
   public void deleteSpell(Integer id){
       spellsModels.remove(spellsModels.get(id));
       updateId();
   }

   public void updateId(){
       Integer id = 0;
       for(SpellsModel spell : spellsModels){
           spell.setId(id);
           id++;
       }
   }
}
