package eu.michalszyba.usermanagement.repository;

import eu.michalszyba.usermanagement.entity.ErrorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorDetailRepository extends JpaRepository<ErrorDetail, Long> {
}
