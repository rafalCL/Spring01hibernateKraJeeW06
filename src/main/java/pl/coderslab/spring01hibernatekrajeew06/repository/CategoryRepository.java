package pl.coderslab.spring01hibernatekrajeew06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
