package com.itstep.my_spring.controllers.api;

import com.itstep.my_spring.models.Animal;
import com.itstep.my_spring.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ApiAnimalController {
    private final AnimalRepository animalRepository;

    public ApiAnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    /**
     * Create
     * @param animal
     * @return
     */
    @PostMapping("/api/animal")
    public ResponseEntity<Animal> create(@RequestBody Animal animal) {
        Animal savedAnimal = animalRepository.save(animal);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAnimal.getId()).toUri();
        return ResponseEntity.created(location).body(savedAnimal);
    }

    /**
     * Read
     * @return
     */
    @GetMapping("/api/animal")
    public ResponseEntity<List<Animal>> findAll() {
        List<Animal> animals = new ArrayList<>();
        animalRepository.findAll().forEach(animals::add);
        if (animals.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(animals);
        }
    }

    /**
     * Read
     * @param id
     * @return
     */
    @GetMapping("/api/animal/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        return optionalAnimal.map(
                animal -> ResponseEntity.ok(animal))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Update
     * @param id
     * @param updatedAnimal
     * @return
     */
    @PutMapping("/api/animal/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.setName(updatedAnimal.getName());
            animal.setAge(updatedAnimal.getAge());
            animalRepository.save(animal);
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete
     * @param id
     * @return
     */
    @DeleteMapping("/api/animal/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            animalRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


//    @GetMapping("/api/animal/{id}")
//    public Animal findById(@PathVariable Long id){
//        Optional<Animal> res = animalRepository.findById(id);
//        if(res.isPresent()){
//            return res.get();
//        }
//        //return animalRepository.findById(id).get();
//    }
}
