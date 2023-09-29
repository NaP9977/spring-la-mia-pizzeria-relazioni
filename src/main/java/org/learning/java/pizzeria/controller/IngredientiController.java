package org.learning.java.pizzeria.controller;

import org.learning.java.pizzeria.model.Ingredienti;
import org.learning.java.pizzeria.repository.IngredientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ingredients")
public class IngredientiController {

    @Autowired
    IngredientiRepository ingredientiRepository;

@GetMapping
    private String index(Model model){
    model.addAttribute("ingredientsList", ingredientiRepository.findAll());
    model.addAttribute("ingredientsObj", new Ingredienti());
    return "ingredients/index";
}
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("ingredientsObj") Ingredienti ingredientsForm,
                           RedirectAttributes redirectAttributes) {

        ingredientiRepository.save(ingredientsForm);

        redirectAttributes.addFlashAttribute("message", "Hai aggiunto un nuovo ingrediente!");

        return "redirect:/ingredients";
    }


    @PostMapping("/delete/{idIngredients}")
    public String delete(@PathVariable("idIngredients") Integer idIngredients) {

       ingredientiRepository.deleteById(idIngredients);

        return "redirect:/ingredients";
    }
}


