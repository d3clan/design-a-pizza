package net.declans.virgin.controller;

import java.util.Collection;
import java.util.List;
import net.declans.virgin.model.PizzaEntity;
import net.declans.virgin.model.PizzaSizeEntity;
import net.declans.virgin.model.ToppingEntity;
import net.declans.virgin.service.PizzaService;
import net.declans.virgin.service.PizzaSizeService;
import net.declans.virgin.service.ToppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project: design-a-pizza Date: 01/10/2013
 *
 * @author Declan Newman (declan)
 */
@Controller
@RequestMapping("/pizza")
public class PizzaContoller {

    private static final Logger logger = LoggerFactory.getLogger(PizzaContoller.class);

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaSizeService pizzaSizeService;

    @Autowired
    private ToppingService toppingService;

    @ModelAttribute("toppings")
    public Collection<ToppingEntity> getAllToppings() {
        return toppingService.findAllToppings();
    }

    @ModelAttribute("sizes")
    public Collection<PizzaSizeEntity> getAllSizes() {
        return pizzaSizeService.findAllPizzaSizes();
    }

    @RequestMapping
    public ModelAndView pizzaPage(ModelAndView mav) {
        logger.debug("Hit the PizzaContoller");
        mav.setViewName("pizza");
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView savePizza(@ModelAttribute("pizza") PizzaEntity pizza, BindingResult result, ModelAndView mav) {
        logger.debug("Hit the savePizza method with {}", pizza);
        mav.setViewName("pizza-form");
        return mav;
    }

}
