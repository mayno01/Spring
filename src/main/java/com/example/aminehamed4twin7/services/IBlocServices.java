package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Bloc;
import com.example.aminehamed4twin7.entities.Chambre;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc(Bloc bloc);
    Bloc addBloc(Bloc bloc);
    Bloc retrieveBloc(long idBloc);
    void removeBloc(long idBloc);
    public Bloc affecterChambresABloc(List<Long> numeroChambres, long idBloc) ;
    public Bloc affecterBlocAFoyer (long idBloc, long idFoyer);
}

