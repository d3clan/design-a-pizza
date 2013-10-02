package net.declans.virgin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project: design-a-pizza Date: 01/10/2013
 *
 * @author Declan Newman (declan)
 */
@Controller
@RequestMapping("/error")
public class ErrorContoller {

    @RequestMapping("/not-found")
    public ModelAndView pizzaForm(ModelAndView mav) {
        mav.setViewName("not-found");
        return mav;
    }

}
