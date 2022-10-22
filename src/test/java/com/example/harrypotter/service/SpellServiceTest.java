package com.example.harrypotter.service;


import com.example.harrypotter.model.SpellsModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class SpellServiceTest {

    @Autowired
    SpellService spellService;


    @Test
    public void getAllSpellsTest(){
        List<SpellsModel> spellsModelList = spellService.getAllSpells();
        assertEquals(false,spellsModelList.isEmpty());
    }

    @Test
    public void addNewSpell(){
        SpellsModel spellsModel = new SpellsModel();
        spellsModel.setName("Harry Potter");
        spellsModel.setDescription("Avada");
        SpellsModel spellsModel1 = spellService.addNewSpell(spellsModel);
        assertEquals("Harry Potter",spellsModel1.getName());
        assertEquals("Avada",spellsModel1.getDescription());
    }
}
