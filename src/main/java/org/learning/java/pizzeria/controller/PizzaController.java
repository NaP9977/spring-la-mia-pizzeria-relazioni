package org.learning.java.pizzeria.controller;

import jakarta.validation.Valid;
import org.learning.java.pizzeria.model.Pizza;
import org.learning.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizza_list = pizzaRepository.findAll();
        model.addAttribute("pizza_list", pizza_list);

        return "pizza-list";
    }

    @GetMapping("/pizza/{id}")
    public String pizza(@PathVariable("id") Integer id, Model model) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if (pizzaOptional.isPresent()) {
            Pizza pizzaFromDB = pizzaOptional.get();
            model.addAttribute("single-pizza", pizzaFromDB);
            return "single-pizza";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("pizza", new Pizza());
        return "form";

    }

    @PostMapping("/create")
    public String createForm (@Valid@ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        formPizza.setName(formPizza.getName().toUpperCase());
        pizzaRepository.save(formPizza);
        return "redirect:/pizzeria";
    }



}
