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
    public ResponseEntity<Object> addNewSpell (@RequestBody SpellsModel spellsModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(spellService.addNewSpell(spellsModel));
    }

    @PutMapping("/spells/{id}")
    public ResponseEntity<Object> updateSpell(@PathVariable Integer id, @RequestBody SpellsModel spellsModel){
        if(spellService.existById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(spellService.updateSpell(id,spellsModel));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O Id passado nao existe no DataBase");
        }

    }

    @DeleteMapping("/spells/{id}")
    public ResponseEntity<Object> updateSpell(@PathVariable Integer id){
        if(spellService.existById(id)){
            spellService.deleteSpell(id);
            return ResponseEntity.status(HttpStatus.OK).body("Spell deletada");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O Id passado nao existe no DataBase");
        }

    }


}
