package com.thecardcottage.EcomFrontend.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecardcottage.EcomBackend.dao.CartDao;
import com.thecardcottage.EcomBackend.dao.CustomerDao;
import com.thecardcottage.EcomBackend.dao.ProductDao;
import com.thecardcottage.EcomBackend.model.Cart;
import com.thecardcottage.EcomBackend.model.Customer;
import com.thecardcottage.EcomBackend.model.Product;

@Controller
public class CartController {
	@Autowired
	CustomerDao custdao;

	@Autowired
	ProductDao productdao;

	@Autowired
	CartDao cartdao;

	@RequestMapping("/AddToCart")
	String addToCart(HttpSession httpSession, @RequestParam("pid") int productid, @RequestParam("quantity") int pqty) {
		if (httpSession.getAttribute("emailid") != null) {
			Cart cart = new Cart();
			Product product = productdao.selectOneProduct(productid);
			Customer customer = custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString());
			List<Cart> cartlist = cartdao.selectAllCarts(customer);
			if (cartlist.isEmpty()) {
				cart.setCustomer(customer);
				cart.setProduct(product);
				cart.setQuantity(pqty);
				cart.setSubtotal(pqty * product.getPdtprice());
				cartdao.insertCart(cart);

				return "redirect:/user/cart";

			} else {
				Iterator<Cart> iterator = cartlist.listIterator();
				while (iterator.hasNext()) {
					Cart cart2 = (Cart) iterator.next();
					Product p = cart2.getProduct();
					if (p.getPdtid() == productid) {
						int qty = cart2.getQuantity();
						qty += pqty;
						cart2.setQuantity(qty);
						cart2.setSubtotal(qty * product.getPdtprice());
						cartdao.updateCart(cart2);
						return "redirect:/user/cart";
					}
				}
				cart.setCustomer(customer);
				cart.setProduct(product);
				cart.setQuantity(pqty);
				cart.setSubtotal(pqty * product.getPdtprice());
				cartdao.insertCart(cart);
				return "redirect:/user/cart";
			}

		} else {
			httpSession.setAttribute("pid", productid);
			httpSession.setAttribute("qty", pqty);

			return "redirect:/login";
		}

	}

	@RequestMapping("/user/cart")
	String viewCart(Model model, HttpSession httpSession) {
		float tot = 0;
		model.addAttribute("cartPage", true);
		ArrayList<Cart> cartList = (ArrayList<Cart>) cartdao
				.selectAllCarts(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));
		Iterator<Cart> iterator = cartList.listIterator();
		while (iterator.hasNext()) {
			Cart cart = (Cart) iterator.next();
			tot = tot + cart.getSubtotal();
		}
		model.addAttribute("cartitems", cartList);
		model.addAttribute("total", tot);

		return "index";
	}

	@RequestMapping("/user/deleteitem")
	String deleteCartItem(@RequestParam("itemid") int id) {
		cartdao.deleteCart(id);
		return "redirect:/user/cart";

	}
}
