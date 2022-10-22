package com.example.harrypotter.controller;
import com.example.harrypotter.model.SpellsModel;
import com.example.harrypotter.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/harrypotter")
public class SpellController {


    @Autowired
    SpellService spellService;

    @GetMapping("/spells")
    public ResponseEntity<List<SpellsModel>> getAllSpells(){
        return ResponseEntity.status(HttpStatus.OK).body(spellService.getAllSpells());
    }


    @PostMapping("/spells")
    public ResponseEntity<SpellsModel> addNewSpell (@RequestBody SpellsModel spellsModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(spellService.addNewSpell(spellsModel));
    }

}