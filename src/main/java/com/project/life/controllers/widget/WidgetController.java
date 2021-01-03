package com.project.life.controllers.widget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.life.models.note.Note;
import com.project.life.models.user.User;
import com.project.life.services.note.NoteService;
import com.project.life.services.user.UserService;


@Controller
public class WidgetController {
	
	private final UserService userService;
	private final NoteService noteService;

	
	public WidgetController(UserService userService, NoteService noteService) {
		this.userService = userService;
		this.noteService = noteService;
	}
	
	
	
	// for Weather API
	private static HttpURLConnection connection;
	BufferedReader reader;
	String line;
	StringBuffer responseContent = new StringBuffer();
	
	
	// display main user/dashboard.jsp template (This method makes Weather API call)
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("note") Note note, Model model, HttpSession session) {
				
		// for Weather API call
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Minneapolis&units=imperial&appid=36d90c006e27a50453c14229ce3ab55e");
			connection = (HttpURLConnection) url.openConnection();
			
			// Request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			// Response from server
			int status = connection.getResponseCode();
			
			// Dealing with errors from server
			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			// if no errors, parse through JSON response and add to Model
			
			JSONObject jsonObject = new JSONObject(responseContent.toString());
//			System.out.println("Result after Reading JSON Response:");
//			System.out.println("City- " + jsonObject.getString("name"));
			String city = jsonObject.getString("name");
			model.addAttribute("city", city);
			
			JSONArray jsonArray = jsonObject.getJSONArray("weather");
			
			JSONObject jsonObject2 = jsonArray.getJSONObject(0);
//			System.out.println("Description: " + jsonObject2.getString("description"));
			String desc = jsonObject2.getString("description");
			model.addAttribute("desc", desc);
			
//			System.out.println("Description 2: " + jsonObject2.getString("main"));
//			System.out.println("Icon: " + jsonObject2.getString("icon"));
			String icon = jsonObject2.getString("icon");
			model.addAttribute("icon", icon);
			
			JSONObject jsonObject3 = jsonObject.getJSONObject("main");
//			System.out.println("Temperature: " + jsonObject3.getFloat("temp"));
			float floatTemp = jsonObject3.getFloat("temp");
			int currentTemp = (int) Math.floor(floatTemp);
			model.addAttribute("currentTemp", currentTemp);
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findUserById(userId);
			model.addAttribute("user", user);
			return "user/dashboard.jsp";
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "Oops, there was an issue...";
		} catch (IOException e) {
			e.printStackTrace();
			return "Oops, there was an issue...";
		} 
	}
	
	
	
	// Add a new note
	@PostMapping("/addNote")
	public String addNote(@Valid @ModelAttribute("note") Note note, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			Long thisUserId = (Long) session.getAttribute("userId");
			User thisUser = userService.findUserById(thisUserId);
			note.setUser(thisUser);
			noteService.addNote(note);
			return "redirect:/dashboard";
		}
	}
}