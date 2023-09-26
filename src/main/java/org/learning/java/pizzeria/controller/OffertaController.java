package org.learning.java.pizzeria.controller;

import org.learning.java.pizzeria.repository.OffertaRepository;
import org.learning.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/offerta")
public class OffertaController {
 @Autowired
    OffertaRepository offertaRepository;
@Autowired
    PizzaRepository pizzaRepository;







}
