package com.project.life.controllers.user;
import javax.servlet.http.HttpSession;   
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.life.models.user.User;
import com.project.life.services.user.UserService;
import com.project.life.validators.UserValidator;


@Controller
public class UserController {
	private final UserService userService;

	// NEW
	private final UserValidator userValidator;

	// NEW
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	
	@RequestMapping("/")
	public String logreg(@ModelAttribute("user") User user) {
		return "user/register.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "user/login.jsp";
	}
	
	// guest user demo
	@PostMapping("/guest")
	public String guestDemo(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuth = userService.authenticateUser(email, password);
		if (isAuth) {
			User userLog = userService.findByEmail(email);
			session.setAttribute("userId", userLog.getId());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", "Invalid email/password. Try again.");
			return "/user/login.jsp";
		}
	}

	
	// register
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "user/register.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/dashboard";
	}
	
	
	// login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {

		boolean isAuth = userService.authenticateUser(email, password);
		if (isAuth) {
			User userLog = userService.findByEmail(email);
			session.setAttribute("userId", userLog.getId());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", "Invalid email/password. Try again.");
			return "/user/login.jsp";
		}
	}
	
	// logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
