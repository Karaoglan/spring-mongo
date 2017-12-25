package com.springmvc.mongoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/try")
public class DefaultController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
    public String home1() {
        return "welcome home";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/home")
    public String home() {
        return "/home";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String admin() {
        return "/admin";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/user")
    public String user() {
        return "/user";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/about")
    public String about() {
        return "/about";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "/login";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/403")
    public String error403() {
        return "/error/403";
    }
    
}
