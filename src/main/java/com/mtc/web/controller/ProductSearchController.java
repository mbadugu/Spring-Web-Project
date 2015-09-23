package com.mtc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.entity.Product;

@Controller
public class ProductSearchController {
 private Logger logger = Logger.getLogger(ProductSearchController.class);
	
 @Autowired
	private IProductDAO productDAO;
	
	@RequestMapping("/allProducts")
	public ModelAndView fetchAllProducts(){
		logger.info("**********fetchAllProducts()********");
		List<Product> products=productDAO.getproducts();
		ModelAndView modelAndView = new ModelAndView("productPdfView");
		modelAndView.addObject("products", products);
		return modelAndView;
		}
	
	@RequestMapping("/productSearch")
	public ModelAndView fetchProductRequest(HttpServletRequest request){
		logger.info("**********fetchProductRequest()********");
	int id =Integer.parseInt(request.getParameter("productId"));
	Product product=productDAO.getproductById(id);
	ModelAndView modelAndView =new ModelAndView("sampleView");
	//ModelAndView modelAndView = new ModelAndView("productPdfView");
	modelAndView.addObject("product", product);
	return modelAndView;
	}
}
