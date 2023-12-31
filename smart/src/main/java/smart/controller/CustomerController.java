package smart.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import groovyjarjarantlr4.v4.Tool.Option;
import smart.entity.hanul.Customer;
import smart.repository.hanul.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/info/{id}")
	public String info(@PathVariable int id, Model model) {
		Optional<Customer> optional = repository.findById(id);
		Customer vo = optional.isPresent() ? optional.get() : null;
		model.addAttribute("vo", vo);
		return "customer/info";
	}

	@RequestMapping("/info")
	public String info(Model model, int id) {
		Customer vo = repository.findById(id).orElse(null);
		model.addAttribute("vo", vo);
		return "customer/info";
	}

	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		session.setAttribute("category", "cu");
		model.addAttribute("list", repository.findAll());
		return "customer/list";
	}

}
