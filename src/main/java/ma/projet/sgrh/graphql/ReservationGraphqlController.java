package ma.projet.sgrh.graphql;

import lombok.RequiredArgsConstructor;

import ma.projet.sgrh.entities.Reservation;
import ma.projet.sgrh.services.ReservationService;
import ma.projet.sgrh.entities.Client;
import ma.projet.sgrh.entities.Chambre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ma.projet.sgrh.dto.ReservationDTO;
import ma.projet.sgrh.repositories.ClientRepository;
import ma.projet.sgrh.repositories.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ReservationGraphqlController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ChambreRepository chambreRepository;

    
    @QueryMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    
    @QueryMapping
    public Optional<Reservation> getReservationById(@Argument Long id) {
        return reservationService.getReservationById(id);
    }

   
    @MutationMapping
    public Reservation createReservation(@Argument ReservationDTO input) {
        Client client = clientRepository.findById(input.getClientId())
            .orElseThrow(() -> new RuntimeException("Client introuvable pour l'id : " + input.getClientId()));

        Chambre chambre = chambreRepository.findById(input.getChambreId())
            .orElseThrow(() -> new RuntimeException("Chambre introuvable pour l'id : " + input.getChambreId()));

        Reservation reservation = input.toEntity(client, chambre);
        return reservationService.createReservation(reservation);
    }

    
    @MutationMapping
    public Reservation updateReservation(@Argument Long id, @Argument ReservationDTO input) {
        
        Reservation existingReservation = reservationService.getReservationById(id)
            .orElseThrow(() -> new RuntimeException("Réservation introuvable pour l'id : " + id));

        
        Client client = clientRepository.findById(input.getClientId())
            .orElseThrow(() -> new RuntimeException("Client introuvable pour l'id : " + input.getClientId()));
        Chambre chambre = chambreRepository.findById(input.getChambreId())
            .orElseThrow(() -> new RuntimeException("Chambre introuvable pour l'id : " + input.getChambreId()));

        
        existingReservation.setDateDebut(input.getDateDebut());
        existingReservation.setDateFin(input.getDateFin());
        existingReservation.setPreferences(input.getPreferences());
        existingReservation.setClient(client);
        existingReservation.setChambre(chambre);

       
        return reservationService.updateReservation(id, existingReservation);
    }

    
    @MutationMapping
    public boolean deleteReservation(@Argument Long id) {
        reservationService.deleteReservation(id);
        return true;
    }
}
