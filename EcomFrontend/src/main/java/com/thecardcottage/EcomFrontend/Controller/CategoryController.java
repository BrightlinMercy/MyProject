package com.thecardcottage.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecardcottage.EcomBackend.dao.CategoryDao;
import com.thecardcottage.EcomBackend.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao catdao;

	@RequestMapping("/category")
	String categoryPage(Model model) {
		model.addAttribute("catobject", new Category());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("categoryPage", true);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("success", false);
		model.addAttribute("editmode", false);

		return "index";
	}

	@RequestMapping("/addcategory")
	String addCategory(@Valid @ModelAttribute("catobject") Category c, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("catobject", c);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (catdao.insertCategory(c)) {
					model.addAttribute("catobject", new Category());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("catobject", c);
				}
			}

		} catch (Exception e) {
			model.addAttribute("catobject", c);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("categoryPage", true);
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("editmode", false);
		return "index";
	}

	@RequestMapping("/deletecategory")
	String deleteCategory(@RequestParam("catname") String catname, Model model) {
		if (catdao.deleteCategory(catname)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "please try after some time");
		}
		model.addAttribute("catobject", new Category());
		model.addAttribute("categoryPage", true);
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("editmode", false);
		return "index";
	}

	@RequestMapping("/editcategory")
	String editCategory(@RequestParam("catname") String catname, Model model) {
		
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("catobject", catdao.selectOneCategory(catname));
		model.addAttribute("categoryPage", true);
		model.addAttribute("categorylist", catdao.selectAllCategories());
		return "index";

	}

	@RequestMapping("/updatecategory")
	String updateCategory(@Valid @ModelAttribute("catobject") Category c, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("catobject", c);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (catdao.updateCategory(c)) {
					model.addAttribute("catobject", new Category());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("catobject", c);
				}
			}

		} catch (Exception e) {
			model.addAttribute("catobject", c);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("categoryPage", true);
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("editmode", false);
		return "index";
	}

}