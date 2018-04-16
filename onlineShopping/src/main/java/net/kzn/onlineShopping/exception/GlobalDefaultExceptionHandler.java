package net.kzn.onlineShopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException(){
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","The Page not contructed");
		mv.addObject("errorDescription","The Page  you are looking is not valiable now!");
		mv.addObject("title","404 Error Page.");	
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleFoundProuctNotFoundException(){
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Product not Avaliable");
		mv.addObject("errorDescription","The Product you are looking is not valiable now!");
		mv.addObject("title","404 Error Page.");	
		
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Contact your Administrator!");
		
		//Only for debugging your Application
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","Error");	
		
		return mv;
	}

}
