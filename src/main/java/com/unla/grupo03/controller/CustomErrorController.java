package com.unla.grupo03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{
	
	final Logger LOGGER = LoggerFactory.getLogger(CustomErrorController.class);
	
	public String getErrorPath() {		
		return "/error";
	}
	
	@GetMapping("/error")
	public String handlerError(HttpServletRequest request, Model model) {
		
		String errorPage = "error";
		String pageTitulo = "Error";
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				pageTitulo = "Pagina no encontrada";
				errorPage = "error/404";
				LOGGER.error("Error 404");				
			}
			else 
				if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
					pageTitulo = "Error Interno del servidor";
					errorPage = "error/500";
					LOGGER.error("Error 500");					
				}
				else
					if(statusCode == HttpStatus.FORBIDDEN.value()) {
						pageTitulo = "Error de Permisos";
						errorPage = "error/403";
						LOGGER.error("Error 403");
					}		
		}
		
		model.addAttribute("pageTitulo", pageTitulo);
		
		return errorPage;
	}

}
