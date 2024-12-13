package ma.projet.sgrh.repositories;


import ma.projet.sgrh.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
