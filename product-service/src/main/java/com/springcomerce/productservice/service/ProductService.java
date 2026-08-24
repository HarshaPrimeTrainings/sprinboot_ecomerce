package com.springcomerce.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springcomerce.productservice.dao.Product;
import com.springcomerce.productservice.dao.ProductRepository;
import com.springcomerce.productservice.exception.ProductNotAvilableException;

@Service
public class ProductService {

	@Autowired
	ProductRepository prdRepo;
	
	
	public List<Product> getAllProducts(Integer pageNumber,Integer pageSize){
		Pageable pagable = PageRequest.of(pageNumber, pageSize);
		Page<Product> prducts = prdRepo.findAll(pagable);
		return prducts.toList();
	}
	
	public Product getProductById(Integer pid) {
		return prdRepo.findById(pid).orElseThrow(()->new ProductNotAvilableException("pid " + pid));
	}
	
	public Product saveProduct(Product prd) {
		return prdRepo.save(prd);
	}
	
	public String deletePrdoduct(Integer pid) {
		prdRepo.deleteById(pid);
		return "Product Deleted pid "+ pid;
	}
	
	public Product update(Integer pid,Product prd) {
		Product dbProduct  = getProductById(pid);
		dbProduct.setName(prd.getName()!=null?prd.getName():dbProduct.getName());
		dbProduct.setImage(prd.getImage()!=null?prd.getImage():dbProduct.getImage());
		dbProduct.setPrice(prd.getPrice()!=null?prd.getPrice():dbProduct.getPrice());
		prdRepo.save(dbProduct);
		return dbProduct;
	}
	
}
