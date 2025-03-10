package com.codegen.app.backend.codegen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/User")
	@PreAuthorize("hasAuthority('ROLE_Admin'or hasAuthority ' ROLE_Guet_user')")
	public String Admin() {
		return "Cal";
	}
	

	@GetMapping("/User/Add")
    @PreAuthorize("hasAuthority('ROLE_Admin') or hasAuthority('ROLE_Guest_user')")
    public String add(@RequestParam int num1, @RequestParam int num2, Model model) {
        int result = num1 + num2;
        model.addAttribute("result", result);
        return "Cal";
    }

    @GetMapping("/User/Sub")
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public String subtract(@RequestParam int num1, @RequestParam int num2, Model model) {
        int result = num1 - num2;
        model.addAttribute("result", result);
        return "Cal";
    }
}
