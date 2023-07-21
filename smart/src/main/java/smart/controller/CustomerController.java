package smart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.repository.hanul.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("/info/{id}")
	public String info(@PathVariable int id, Model model) {
		
		return"customer/info";
	}
	
	@RequestMapping("/info")
	public String info(Model model, int id) {
		
		return"customer/info";
	}
	

	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		session.setAttribute("category", "cu");
		model.addAttribute("list", repository.findAll());
		return "customer/list";
	}

}
