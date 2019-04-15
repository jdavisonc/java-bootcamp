package globantProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
	Products findByName(String name);

	Iterable<Products> findByCategory(String category);

}
