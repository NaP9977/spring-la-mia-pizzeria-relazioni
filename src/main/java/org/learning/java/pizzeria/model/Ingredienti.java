package org.learning.java.pizzeria.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredienti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngredients;
    private String ingredients;
    @ManyToMany(mappedBy = "ingredientsList")
    private List<Pizza> pizzas;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Integer getIdIngredients() {
        return idIngredients;
    }

    public void setIdIngredients(Integer idIngredients) {
        this.idIngredients = idIngredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
