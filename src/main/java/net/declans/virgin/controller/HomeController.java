package net.declans.virgin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value= {"", "/", "/home", "/index.html"})
	public ModelAndView home() {
		logger.debug("Hit the HomeController");
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
}

