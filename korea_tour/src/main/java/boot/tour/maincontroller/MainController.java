package boot.tour.maincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import boot.tour.data.MysqlTourMapper;

@Controller
public class MainController {

	@Autowired
	MysqlTourMapper mapper;
	
	@GetMapping("/")
	public ModelAndView getMain() {
		ModelAndView model=new ModelAndView();
		model.setViewName("home/home");
		model.addObject("name", "bitcamp");
		return model;
	}
}
