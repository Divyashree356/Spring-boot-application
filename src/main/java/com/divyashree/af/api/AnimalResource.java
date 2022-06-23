package com.divyashree.af.api;


import com.divyashree.af.model.Animal;
import com.divyashree.af.service.AnimalFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value="/animal fact")
public class AnimalResource {
    @Autowired
    private AnimalFact animalFact;

//    public Animal addAnimal(Animal animal)
//    {
//        return animalFact.addAnimal(animal);
//    }

    @RequestMapping(value = "/animalfact")
    public List<Animal> getAllAnimal()
    {
        return animalFact.getAllAnimal();
    }

    @RequestMapping(value = "/animalfact/{name}")
    public Animal getAnimal(@PathVariable String name)
    {
        return animalFact.getAnimal(name);
    }


}
