package org.product.service.service;

import java.util.List;

import org.product.service.model.Product;
import org.product.service.repository.ProductRepository;
import org.product.service.request.ProductRequest;
import org.product.service.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();

		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts(){
		List<Product> products = productRepository.findAll(); // Read all the products inside the database
		return products.stream().map(this::mapToProductResponse).toList(); 
		// this::mapToProductResponse ==> map.(product -> mapToProductResponse(mapToProductResponse))
		// Method Reference in same class   --> Lambda method							
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
	}
}
