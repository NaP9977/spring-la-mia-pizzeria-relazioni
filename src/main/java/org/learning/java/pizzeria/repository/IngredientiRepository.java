package org.learning.java.pizzeria.repository;

import org.learning.java.pizzeria.model.Ingredienti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientiRepository extends JpaRepository <Ingredienti,Integer> {
}
