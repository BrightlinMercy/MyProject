package com.thecardcottage.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thecardcottage.EcomBackend.dao.SellerDao;
import com.thecardcottage.EcomBackend.model.Seller;

@Controller
public class SellerController {
	@Autowired
	SellerDao sellerdao;

	@RequestMapping("/seller")
	String sellerPage(Model model) {
		model.addAttribute("sellerobject", new Seller());
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("sellerPage", true);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("sucess", false);
		return "index";
	}

	@RequestMapping("/addseller")
	String addSeller(@Valid @ModelAttribute("sellerobject") Seller s, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("sellerobject", s);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (sellerdao.insertSeller(s)) {
					model.addAttribute("sellerobject", new Seller());
					model.addAttribute("sucess", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("catobject", s);
				}
			}

		} catch (Exception e) {
			model.addAttribute("sellerobject", s);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		return "index";
	}

}
