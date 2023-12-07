package com.example.aminehamed4twin7.services;

// BlocServicesImpl.java

import com.example.aminehamed4twin7.entities.Chambre;
import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.repository.IBlocRepository;
import com.example.aminehamed4twin7.repository.IChambreRepository;
import com.example.aminehamed4twin7.repository.IFoyerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aminehamed4twin7.entities.Bloc;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlocServicesImpl implements IBlocServices {
    @Autowired
    private IFoyerRepository ifoyerRepository;
    @Autowired
    private IBlocRepository blocRepository;
    @Autowired
    private IChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Transactional
    public Bloc affecterChambresABloc(List<Long> numeroChambres, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null && numeroChambres != null && !numeroChambres.isEmpty()) {
            // Retrieve existing Chambres by numChambre
            List<Chambre> existingChambres = chambreRepository.findByNumeroChambreIn(numeroChambres);

            // Associate existing Chambres with the Bloc
            for (Chambre chambre : existingChambres) {
                chambre.setBloc(bloc);
            }

            // Set the list of existing Chambres to the Bloc
            bloc.setChambres(existingChambres);

            // Save the updated Bloc
            blocRepository.save(bloc);
        }

        return bloc;
    }
@Override
@Transactional
public Bloc affecterBlocAFoyer (long idBloc, long idFoyer) {
    Foyer foyer = ifoyerRepository.findById(idFoyer).orElse(null);
    Bloc bloc = blocRepository.findById(idBloc).orElse(null);
    assert bloc != null;
    bloc.setFoyer(foyer);
    return  bloc;
}

}

