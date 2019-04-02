package com.thecardcottage.EcomFrontend.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	void addimage(MultipartFile f, int id) {
		try {
			String path = "D:\\Mercy\\EcomFrontend\\src\\main\\webapp\\resources\\productimages\\";
			path = path + String.valueOf(id) + ".jpg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}	}	
	
	void deleteimage(int id){
		try {
			String path = "D:\\Mercy\\EcomFrontend\\src\\main\\webapp\\resources\\productimages\\";
			path = path + String.valueOf(id) + ".jpg";
			File x = new File(path);
			if (x.exists()) {
				x.delete();}
			Thread.sleep(5000);
}catch (Exception e) {
		
	}}

	@RequestMapping("/admin/product")
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
	
	@RequestMapping("/viewproduct")
	String viewproductPage(Model model) {
		model.addAttribute("productlist", productdao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("viewproductPage", true);
		return "index";
	}
	
	@RequestMapping("/viewoneproduct")
	String viewoneproductPage(@RequestParam("proid")int proid, Model model) {
        model.addAttribute("myproduct", productdao.selectOneProduct(proid));
		model.addAttribute("viewoneproductPage", true);
		return "index";
	}
	

	@RequestMapping("/selectbycat")
	String viewcatproductPage(@RequestParam("catid")int id, Model model) {
        model.addAttribute("productlist", productdao.selectCatProducts(id));
        model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("viewproductPage", true);
		return "index";
	}
	
	@RequestMapping("/admin/addproduct")
	String addProduct(@Valid @ModelAttribute("productobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("productobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (productdao.insertProduct(p)) {
					addimage(p.getPimage(),p.getPdtid());
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
	@RequestMapping("/admin/deleteproduct")
	String deleteProduct(@RequestParam("pdtid") int pdtid, Model model) {
		if (productdao.deleteProduct(pdtid)) {
			deleteimage(pdtid);
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
	@RequestMapping("/admin/editproduct")
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

	@RequestMapping("/admin/updateproduct")
	String updateProduct(@Valid @ModelAttribute("productobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("productobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				if (productdao.updateProduct(p)) {
					addimage(p.getPimage(),p.getPdtid());
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
