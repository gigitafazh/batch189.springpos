package com.bootcamp.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.model.Barang;

@Controller
public class POSController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("barang")
	public String barang() {
		return "barang";
	}

	@RequestMapping("order")
	public String order() {
		return "order";
	}
	
	@RequestMapping("form-reset.html")
	public String resetForm(HttpServletRequest req) {
		Collection<Barang> barangList = null;
		HttpSession session = req.getSession(true);
		if (session.getAttribute("list") != null) {
			barangList = (Collection<Barang>) session.getAttribute("list");
			barangList.clear();
		}
		return "barang";
	}
}