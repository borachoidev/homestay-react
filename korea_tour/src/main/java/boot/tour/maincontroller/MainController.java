package boot.tour.maincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import boot.tour.data.MysqlTourMapper;

@Controller
public class MainController {

	@Autowired
	MysqlTourMapper mapper;
	
	@GetMapping("/main")
	public String getMain() {
		
		return "main";
	}
}
