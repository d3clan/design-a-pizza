package net.declans.virgin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping
    public ModelAndView pizzaPage(ModelAndView mav) {
        logger.debug("Hit the PizzaContoller");
        mav.setViewName("pizza");
        return mav;
    }

    @RequestMapping("/form")
    public ModelAndView pizzaForm(ModelAndView mav) {
        logger.debug("Hit the PizzaContoller");
        mav.setViewName("pizza-form");
        return mav;
    }

}
