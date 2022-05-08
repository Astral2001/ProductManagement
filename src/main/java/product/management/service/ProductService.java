package product.management.service;

import java.util.List;

import product.management.models.Product;

public interface ProductService {

	Product createProduct (Product product);
	
	Product getProductById (Long id);
	
	List<Product> getAllProduct ();
	
	Product updateProduct (Long id, Product product);
	
	void deleteProduct (Product product);
	
}
