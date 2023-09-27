package org.learning.java.pizzeria.controller;

import org.learning.java.pizzeria.model.Offerta;
import org.learning.java.pizzeria.model.Pizza;
import org.learning.java.pizzeria.repository.OffertaRepository;
import org.learning.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Controller
@RequestMapping ("/offerta")
public class OffertaController {
    @Autowired
    OffertaRepository offertaRepository;
    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/create")
    public String create(@RequestParam("id") Integer id, Model model) {
        Optional<Pizza> pizzaResult = pizzaRepository.findById(id);
        if (pizzaResult.isPresent()) {
            Pizza pizza = pizzaResult.get();
            Offerta offerta = new Offerta();
            offerta.setPizza(pizza);

            model.addAttribute("offerta", offerta);
            return "offerta/form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la pizza selezionata non esiste");
        }

    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("offerta") Offerta offertaForm) {
        System.out.println("OffertaForm: " + offertaForm.getPizza());
        offertaRepository.save(offertaForm);
        return "redirect:/pizzeria/pizza/" + offertaForm.getPizza().getId();
    }

    @GetMapping("/edit/{offerta_Id}")
    public String edit(@PathVariable("offerta_Id") Integer offerta_Id, Model model) {
        Optional<Offerta> offertaResult = offertaRepository.findById(offerta_Id);
        if (offertaResult.isPresent()) {
            model.addAttribute("offerta", offertaResult.get());
            return "offerta/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/edit/{offerta_Id}")
    public String doEdit(@PathVariable("offerta_Id") Integer offerta_Id,
                         @ModelAttribute("offerta") Offerta offertaForm) {
        offertaForm.setOfferta_Id(offerta_Id);
        offertaRepository.save(offertaForm);
        return "redirect:/pizzeria/pizza/" + offertaForm.getPizza().getId();

    }



}

