package net.declans.virgin.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ValidationController {

	private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);

	/**
	 * Simply selects the validation view to render by returning its name.
	 */
	@RequestMapping(value="/validation/", method=RequestMethod.POST)
	public ModelAndView validation(HttpServletRequest request, @RequestParam(value="xmlfile", required=false) CommonsMultipartFile xmlFile) {
		logger.info("Hitting the validation controller");
		ModelAndView mav = new ModelAndView("validation");
		mav.addObject("filename", xmlFile.getOriginalFilename());
		return mav;
	}
	
}

