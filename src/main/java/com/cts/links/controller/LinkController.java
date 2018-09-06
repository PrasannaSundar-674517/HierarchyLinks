package com.cts.links.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cts.links.pojo.Link;
import com.cts.links.pojo.Page;
import com.cts.links.service.LinkService;

@RestController
public class LinkController {
	private static final Logger log = Logger.getLogger(LinkController.class);

	@Autowired
	LinkService linkService;

	@RequestMapping("/hello")
	public String getMessage() {
		return "hello world";

	}

	@GetMapping("/DynamicLinks/{linkName:.+}")
	public List<Link> getLinks(@PathVariable("linkName") String linkName) {

		System.out.println("LinkName" + linkName);
		
		return linkService.getLinks(linkName);

	}
	
	@GetMapping("/StaticLinks/{linkName:.+}")
	public List<Page> getSubLinks(@PathVariable("linkName") String linkName){
		System.out.println("LinkName" + linkName);
		return linkService.getSubLinks(linkName);
		
		
	}

}
