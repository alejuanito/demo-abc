package pe.com.intercorp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.intercorp.demo.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

}
