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
import com.thecardcottage.EcomBackend.dao.ProductDao;
import com.thecardcottage.EcomBackend.dao.SellerDao;
import com.thecardcottage.EcomBackend.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productdao;
	@Autowired
	CategoryDao catdao;
	@Autowired
	SellerDao sellerdao;

	@RequestMapping("/product")
	String productPage(Model model) {
		model.addAttribute("productobject", new Product());
		model.addAttribute("productlist", productdao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("productPage", true);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("success", false);
		model.addAttribute("editmode", false);
		return "index";
	}
	
	@RequestMapping("/addproduct")
	String addProduct(@Valid @ModelAttribute("productobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("productobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (productdao.insertProduct(p)) {
					model.addAttribute("productobject", new Product());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("productobject", new Product());
					model.addAttribute("message", "please try after some time");
					model.addAttribute("productobject", p);
				}
			}

		} catch (Exception e) {
			model.addAttribute("productobject", p);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("productPage", true);
		model.addAttribute("productlist", productdao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";
	}
	@RequestMapping("/deleteproduct")
	String deleteProduct(@RequestParam("pdtid") int pdtid, Model model) {
		if (productdao.deleteProduct(pdtid)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "please try after some time");
		}
		model.addAttribute("productobject", new Product());
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", productdao.selectAllProducts());
		model.addAttribute("editmode", false);
		return "index";
	}
	@RequestMapping("/editproduct")
	String editProduct(@RequestParam("pdtid") int pdtid, Model model) {
		
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("productobject", productdao.selectOneProduct(pdtid));
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", productdao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());

		return "index";

	}

	@RequestMapping("/updateproduct")
	String updateProduct(@Valid @ModelAttribute("productobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("productobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (productdao.updateProduct(p)) {
					model.addAttribute("productobject", new Product());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("productobject", p);
				}
			}

		} catch (Exception e) {
			model.addAttribute("productobject", p);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("productPage", true);
		model.addAttribute("productlist", productdao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", sellerdao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";
	}




}
