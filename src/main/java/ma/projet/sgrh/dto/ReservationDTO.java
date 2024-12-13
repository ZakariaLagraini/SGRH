package ma.projet.sgrh.dto;
import lombok.Data;
import ma.projet.sgrh.entities.Chambre;
import ma.projet.sgrh.entities.Client;
import ma.projet.sgrh.entities.Reservation;

@Data
public class ReservationDTO {
	private Long clientId;
    private Long chambreId;
    private String dateDebut;
    private String dateFin;
    private String preferences;
    
    public Reservation toEntity(Client client, Chambre chambre) {
        Reservation reservation = new Reservation();
        reservation.setDateDebut(this.dateDebut);
        reservation.setDateFin(this.dateFin);
        reservation.setPreferences(this.preferences);
        reservation.setClient(client);
        reservation.setChambre(chambre);
        return reservation;
    }

    // Manually added getter methods
    public Long getClientId() {
        return clientId;
    }

    public Long getChambreId() {
        return chambreId;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String getPreferences() {
        return preferences;
    }
}
