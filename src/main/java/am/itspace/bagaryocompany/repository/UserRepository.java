package am.itspace.bagaryocompany.repository;

import am.itspace.bagaryocompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
