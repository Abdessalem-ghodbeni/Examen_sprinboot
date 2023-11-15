package com.ghodbeny.examen_centre_commerciale.Controller;

import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Services.IBoutiqueServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/boutiques")
public class BoutiqueContoller {
    private final IBoutiqueServices boutiqueServices;


    @PostMapping(path = "/AjouterBoutique/affecter_centre/{id_centre}")
public void ajouterBoutiqueAndAffectForCentre(@PathVariable("id_centre")long id_centre, @RequestBody List<Boutique> boutiques){
        boutiqueServices.ajouterEtAffecterlisteBoutiques(boutiques, id_centre);
    }

}
