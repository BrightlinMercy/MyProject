package com.thecardcottage.EcomFrontend.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecardcottage.EcomBackend.dao.AddressDao;
import com.thecardcottage.EcomBackend.dao.CartDao;
import com.thecardcottage.EcomBackend.dao.CustomerDao;
import com.thecardcottage.EcomBackend.dao.MyOrderDao;
import com.thecardcottage.EcomBackend.dao.ProductDao;
import com.thecardcottage.EcomBackend.dao.SellerDao;
import com.thecardcottage.EcomBackend.model.Cart;
import com.thecardcottage.EcomBackend.model.MyOrder;
import com.thecardcottage.EcomBackend.model.Product;


@Controller
@RequestMapping("/user")
public class OrderController {

	@Autowired
	CartDao cartdao;
	
	@Autowired
	SellerDao sellerDao;

	@Autowired
	AddressDao addressdao;

	@Autowired
	CustomerDao custdao;

	@Autowired
	ProductDao productdao;
	
	@Autowired
	MyOrderDao myorderdao;
	
	@RequestMapping("/placeorder")
	String placeOrder(@RequestParam("addressid") int addid, Model model, HttpSession httpSession) {
		MyOrder myorder = new MyOrder();
		ArrayList<Cart> carts=(ArrayList<Cart>) cartdao.selectAllCarts(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));
		
		Iterator<Cart> iterator = carts.listIterator();
		while (iterator.hasNext()) {
			Date d = new Date();
			long id = UUID.randomUUID().getMostSignificantBits();
			String oid = "OD-".concat(String.valueOf(id).replace("-", "5"));
			Cart cart = (Cart) iterator.next();
			Product product=productdao.selectOneProduct(cart.getProduct().getPdtid());
			if (product.getPdtstock() >= cart.getQuantity())
			{
				myorder.setAddress(addressdao.selectOneAddress(addid));
				
				myorder.setOrderid(oid);
				myorder.setOrderdate(d);
				myorder.setQuantity(cart.getQuantity());
				myorder.setProduct(cart.getProduct());
				myorder.setSubtotal(cart.getSubtotal());
				myorder.setCustomer(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));
				int qty=product.getPdtstock() - cart.getQuantity();
				product.setPdtstock(qty);
				if(myorderdao.insertMyOrder(myorder))
								{
					productdao.updateProduct(product);
					cartdao.deleteCart(cart.getItemid());
				}
			}}
		
		ArrayList<Cart> cartitems = (ArrayList<Cart>) cartdao.selectAllCarts(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));
		httpSession.setAttribute("itemcount", cartitems.size());
		model.addAttribute("orderlist", myorderdao.selectAllMyOrders(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString())));
		model.addAttribute("orderPage", true);
		return "index";
	}
	
	@RequestMapping("/vieworders")
	String viewallorders(Model model,HttpSession httpSession)
	{
		model.addAttribute("orderlist", myorderdao.selectAllMyOrders(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString())));
		model.addAttribute("orderPage", true);
		return "index";
	}
	

	@RequestMapping("/receipt")
	String receipt(@RequestParam("rid")String oid,Model model,HttpSession httpSession)
	
	{
		model.addAttribute("order", myorderdao.selectOneMyOrder(oid));
		model.addAttribute("receiptPage", true);
		return "index";
		
	}

}


	

