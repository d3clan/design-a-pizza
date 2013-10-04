package net.declans.virgin.controller;

import java.math.BigDecimal;
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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project: design-a-pizza Date: 01/10/2013
 *
 * @author Declan Newman (declan)
 */
@Controller
@RequestMapping("/pizza")
public class PizzaContoller extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PizzaContoller.class);

    // Just here for cases where someone visits directly to /pizza
    @RequestMapping
    public ModelAndView pizzaPage(ModelAndView mav) {
        logger.debug("Hit the PizzaContoller");
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PizzaEntity postPizzaDetails(@RequestParam("pizzaSizeId") Integer pizzaSizeId, @RequestParam("toppingIds") Integer[] toppingIds) {
        logger.debug("Hit the savePizza method with {}, {}", pizzaSizeId, toppingIds);
        return buildPizzaEntity(pizzaSizeId, toppingIds);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PizzaEntity savePizzaDetails(@RequestParam("pizzaSizeId") Integer pizzaSizeId, @RequestParam("toppingIds") Integer[] toppingIds) {
        logger.debug("Hit the savePizza method with {}, {}", pizzaSizeId, toppingIds);
        return pizzaService.saveOrUpdatePizza(buildPizzaEntity(pizzaSizeId, toppingIds));
    }

    @RequestMapping(value = "/toppings/{size}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ToppingEntity> findPizzaToppings(@PathVariable("size") Integer size) {
        PizzaSizeEntity pizzaSizeEntity = pizzaSizeService.findById(size);
        Double multiplier = pizzaSizeEntity != null ? pizzaSizeEntity.getMultiplier() : 1.0D;
        List<ToppingEntity> allToppings = toppingService.findAllToppings();

        for (ToppingEntity te : allToppings) {
            te.setMultiplier(multiplier);
        }
        return allToppings;
    }

    private PizzaEntity buildPizzaEntity(Integer pizzaSizeId, Integer[] toppingIds) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        PizzaSizeEntity pizzaSize = pizzaSizeService.findById(pizzaSizeId);
        pizzaEntity.setBaseSize(pizzaSize);
        List<ToppingEntity> toppings = toppingService.findByIds(toppingIds);
        pizzaEntity.setToppings(toppings);
        return pizzaEntity;
    }

}
