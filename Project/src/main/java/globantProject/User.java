package globantProject;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name = "iduser")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@ElementCollection
	@Column(name = "category_searched")
	private List<String> recommended;
	@Column(name = "id_products_in_cart")
	@ElementCollection
	@CollectionTable(name = "id_products_in_cart")
	private List<Products> productsInCart;
}
