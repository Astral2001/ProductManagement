package product.management.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String code;
	private String description;
	private Double price;
	
	
	public void setId(Long id) { this.id = id; }
	public void setCode(String code) { this.code = code; }
	public void setDescription(String description) { this.description = description; }
	public void setPrice(Double price) { this.price = price; }
	
	public Long getId() { return id; }
	public String getCode() { return code; }
	public String getDescription() { return description; }
	public Double getPrice() { return price; }

}
