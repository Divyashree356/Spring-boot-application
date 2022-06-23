package com.divyashree.af.service;

import com.divyashree.af.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AnimalFact {

    Animal dog= new Animal(
            "dog" ,
            "Their sense of smell is at least 40x better than ours" +
                    "Some have such good noses they can sniff out medical problems" +
                    "Dogs can sniff at the same time as breathing" +
                    "Some dogs are incredible swimmers" +
                    "Some are fast and could even beat a cheetah! " +
                    "Dogs don't sweat like we do."
    );
    Animal cat= new Animal(
            "cat" ,
            "As kittens they have 26 deciduous, or “baby”, teeth." +
                    "House cats share 95.6% of their genetic makeup with tigers." +
                    "Cats can jump 5 times their own height." +
                    "A housecat can run to the speed of about 30 mph over short distances."
    );

    List<Animal> animalList= Arrays.asList(dog, cat);

    public List<Animal> getAllAnimal()
    {
        return animalList;
    }

    public  Animal getAnimal(String name)
    {
        Animal animal= animalList.stream()
                .filter(t -> name.equals(t.getAnimalName()))
                .findFirst()
                .orElse(null);

        return  animal;
    }



}
