package ma.projet.sgrh.repositories;

import ma.projet.sgrh.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
