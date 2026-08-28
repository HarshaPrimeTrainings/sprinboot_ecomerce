package com.springcomerce.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springcomerce.productservice.dao.Product;
import com.springcomerce.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins ="http://localhost:4200")
public class ProductController {
	
	ProductService prdService;
	
	@Value("${product.pagesize}")
	Integer pageSize;
	
	ProductController(ProductService prdService){
	this.prdService = prdService;
	}
	
	@GetMapping("/all")
	public List<Product> getAllPrducts(@RequestParam(defaultValue = "0") Integer pageNumber){
		int pagenum = pageNumber>=1?pageNumber-1:0;
		return prdService.getAllProducts(pagenum, pageSize);
	}
	
	@GetMapping("/{pid}")
	public Product getProductById(@PathVariable Integer pid) {
		return prdService.getProductById(pid);
	}
	
	@DeleteMapping("/{pid}")
	public String deleteProduct(@PathVariable Integer pid) {
		return prdService.deletePrdoduct(pid);
	}
	
	
}
