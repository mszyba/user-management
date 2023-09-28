package eu.michalszyba.usermanagement.repository;

import eu.michalszyba.usermanagement.entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailRepository extends JpaRepository<LoginDetail, Long> {
}
