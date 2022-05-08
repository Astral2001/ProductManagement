package product.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.management.models.Product;
import product.management.repository.ProductRepository;
import product.management.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	@Override
	public Product updateProduct(Long id, Product product) {
		Product productInDB = productRepository.findById(id).get();
		
		productInDB.setCode(product.getCode());
		productInDB.setDescription(product.getDescription());
		productInDB.setPrice(product.getPrice());
		
		return productRepository.save(productInDB);
	}
	
	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}
