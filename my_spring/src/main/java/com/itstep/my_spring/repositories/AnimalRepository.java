package com.itstep.my_spring.repositories;

import com.itstep.my_spring.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
