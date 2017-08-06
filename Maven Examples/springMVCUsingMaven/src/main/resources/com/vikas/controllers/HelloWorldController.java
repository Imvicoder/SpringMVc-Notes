
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
// this is a controller class
@Controller
public class HelloWorldController {

	@RequestMapping("/hello/{}")
	public ModelAndView welcomeMessage(
			@RequestParam(value = "name") String name) {
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("hello");
		view.addObject("name", name);
		return view;
	}
}