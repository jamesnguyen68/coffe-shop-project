package com.ngohoangbach.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngohoangbach.demo.entity.Order;
import com.ngohoangbach.demo.entity.Product;
import com.ngohoangbach.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> showAllProducts(){
		return productService.findAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product showProduct(@PathVariable int productId) {
		return productService.findProductById(productId);
	}
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product theProduct) {
		theProduct.setId(0);
		productService.saveProduct(theProduct);
		return theProduct;
	}
	
	@PutMapping("/products")
	public Product update(@RequestBody Product theProduct) {
		
		productService.saveProduct(theProduct);
		
		return theProduct;
	}
	
	@DeleteMapping("/products/{productId}")
	public String delete(@PathVariable int productId) {
		productService.deleteProductById(productId);
		return "Deleted product at id: "+ productId;
	}
	
	// ------------------- ORDERS ----------------------------------------------------//
	
	@GetMapping("/orders")
	public List<Order> findAllOrders(){
		return productService.findAllOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public Order findOrderAtId(@PathVariable int orderId) {
		 return productService.findOrderById(orderId);
	}

	@PostMapping("/orders")
	public Order createOrder() {
		Order theOrder = new Order();
		productService.saveOrder(theOrder);
		return theOrder;
	}
	
	@PutMapping("/orders/{orderId}/products/{productId}")
	public void orderNewProduct(@PathVariable int orderId, @PathVariable int productId) {
		Order theOrder = productService.findOrderById(orderId);
		Product theProduct = productService.findProductById(productId);
		theOrder.addProduct(theProduct);
		productService.saveProduct(theProduct);
	}
}
