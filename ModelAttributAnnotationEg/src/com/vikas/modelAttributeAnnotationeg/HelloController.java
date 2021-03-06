package com.vikas.modelAttributeAnnotationeg;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value = "/admissionform.html", method = RequestMethod.GET)
	public ModelAndView fillform() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}
	/*
	 * @RequestMapping(value="/admissionsuccess.html",method=RequestMethod.POST)
	 * public ModelAndView success(@RequestParam Map<String,String> params){
	 * String name=params.get("fname"); String hobby=params.get("hobbyname");
	 * Student st=new Student(); st.setName(name); st.setHobby(hobby);
	 * ModelAndView model=new ModelAndView("Successmsg");
	 * //model.addObject("msg","Name:-"+name+"\nHobby:-"+hobby);
	 * model.addObject("student",st); return model; }
	 */
	// Now if use model attribute annotation then we need not to do all this
	// work which we have done
	// in above method.
	// we need not to create object of student class and no need to call setter
	// methods.
	// we need not to call addObject method.
	/*
	 * @ModelAttribute public void addingCommonObjects(Model model) {
	 * 
	 * model.addAttribute("headerMessage", "GBU"); }
	 */

	@RequestMapping(value = "/admissionsuccess.html", method = RequestMethod.POST)
	public ModelAndView success(@ModelAttribute("student") Student student) {
		/*
		 * String name=params.get("fname"); String
		 * hobby=params.get("hobbyname"); Student st=new Student();
		 * st.setName(name); st.setHobby(hobby);
		 */
		System.out.println("name is:->" + student.getName());

		ModelAndView model = new ModelAndView("Successmsg");
		// model.addObject("msg","Name:-"+name+"\nHobby:-"+hobby);
		// model.addObject("student",st);
		return model;
	}

	@ModelAttribute
	public void commonObject(Model model) {
		model.addAttribute("commonmsg", "Welcome To Gautam Buddha University Admission Portal");

	}
	

}
