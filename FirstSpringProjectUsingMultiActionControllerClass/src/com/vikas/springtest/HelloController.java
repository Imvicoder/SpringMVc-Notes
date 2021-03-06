package com.vikas.springtest;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*@RequestMapping("/greet")*/
public class HelloController {
@RequestMapping("/welcome")
public ModelAndView helloworld(){
	ModelAndView model=new ModelAndView("HelloPage");
	model.addObject("msg","Hello World");
	return model;
}
@RequestMapping("/hi")
public ModelAndView hiworld(){
	ModelAndView model=new ModelAndView("HelloPage");
	model.addObject("msg","hi world");
	return model;
}

//Using Path Variable Annotation to pass variables in url and using the value of these values in our
//code as following
// we can use more than one variables in url as following
@RequestMapping("/{countryname}/username/{name}")
public ModelAndView variabletest(@PathVariable("name") String uname,@PathVariable("countryname") String cname){
	ModelAndView model=new ModelAndView("HelloPage");
	model.addObject("msg","Hello "+uname+" You are from "+cname);
	return model;
}
// we can use MAP colection to store path variables as following
//if you want to use map to collect all path variables then u must include
//following line ins dispatcher-servlet.xml
//<mvc:annotation-driven/>
@RequestMapping("/address/{countryname}/{statename}/{cityname}")

public ModelAndView test(@PathVariable Map<String,String> pathvars){
	String cname=pathvars.get("countryname");
	String stname=pathvars.get("statename");
	String cityname=pathvars.get("cityname");
	ModelAndView model=new ModelAndView("HelloPage");
	model.addObject("msg","Your address is:->"
			+ "Country:->"+cname+""
					+ "State:->"+stname+""
							+ "City:->"+cityname);
	return model;
}
}
