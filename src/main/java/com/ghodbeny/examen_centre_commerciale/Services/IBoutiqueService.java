package com.ghodbeny.examen_centre_commerciale.Services;

import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Entities.CentreCommerciale;
import com.ghodbeny.examen_centre_commerciale.Repository.IBoutiqueRepository;
import com.ghodbeny.examen_centre_commerciale.Repository.ICentreCommercialeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IBoutiqueService implements IBoutiqueServices {
    private final IBoutiqueRepository iBoutiqueRepository;
    private final ICentreCommercialeRepository centreCommercialeRepository;

 @Transactional
    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommerciale centre=centreCommercialeRepository.findById(idCentre).orElseThrow(null);
       List<Boutique>boutiques= iBoutiqueRepository.saveAll(lb);
      for(Boutique boutique:boutiques){
          boutique.setCentreCommerciale(centre);
      }

    }
}
