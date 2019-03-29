package com.thecardcottage.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecardcottage.EcomBackend.dao.SellerDao;
import com.thecardcottage.EcomBackend.model.Seller;

@Controller
public class SellerController {
	@Autowired
	SellerDao sellerdao;

	@RequestMapping("/seller")
	String sellerPage(Model model) {
		model.addAttribute("sellobject", new Seller());
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("sellerPage", true);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("success", false);
		model.addAttribute("editmode", false);
		return "index";
	}

	@RequestMapping("/addseller")
	String addSeller(@Valid @ModelAttribute("sellobject") Seller s, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("sellobject", s);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (sellerdao.insertSeller(s)) {
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("sellobject", s);
				}
			}

		} catch (Exception e) {
			model.addAttribute("sellobject", s);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";
	}
	@RequestMapping("/deleteseller")
	String deleteSeller(@RequestParam("sellname") String sellname, Model model) {
		if (sellerdao.deleteSeller(sellname)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "please try after some time");
		}
		model.addAttribute("sellobject", new Seller());
		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";
	}
	@RequestMapping("/editseller")
	String editSeller(@RequestParam("sellname") String sellname, Model model) {
		
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("sellobject", sellerdao.selectOneSeller(sellname));
		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		return "index";

	}

	@RequestMapping("/updateseller")
	String updateSeller(@Valid @ModelAttribute("sellobject") Seller s, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("sellobject", s);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (sellerdao.updateSeller(s)) {
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("sellobject", s);
				}
			}

		} catch (Exception e) {
			model.addAttribute("sellobject", s);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";
	}


}
