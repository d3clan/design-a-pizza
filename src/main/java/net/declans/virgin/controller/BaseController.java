package net.declans.virgin.controller;

import java.util.List;
import net.declans.virgin.model.PizzaSizeEntity;
import net.declans.virgin.model.ToppingEntity;
import net.declans.virgin.service.PizzaService;
import net.declans.virgin.service.PizzaSizeService;
import net.declans.virgin.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Project: design-a-pizza Date: 04/10/2013
 *
 * @author Declan Newman (declan)
 */
public class BaseController {

    @Autowired
    protected PizzaService pizzaService;

    @Autowired
    protected PizzaSizeService pizzaSizeService;

    @Autowired
    protected ToppingService toppingService;

    @ModelAttribute("toppings")
    public List<ToppingEntity> getAllToppings() {
        return toppingService.findAllToppings();
    }

    @ModelAttribute("sizes")
    public List<PizzaSizeEntity> getAllSizes() {
        return pizzaSizeService.findAllPizzaSizes();
    }
}
