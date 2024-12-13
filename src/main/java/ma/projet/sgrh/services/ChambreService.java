package ma.projet.sgrh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.sgrh.entities.Chambre;
import ma.projet.sgrh.repositories.ChambreRepository;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }
}

