package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.PlanetDetails;

import java.util.List;

public interface PlanetDAOInterface {
    List<PlanetDetails> findAllPlanetDetails();
    void addPlanetDetails();
    PlanetDetails findPlanetDetailsById(int id);
    void deletePlanetDetails(int id);
    void updatePlanetDetails(PlanetDetails planetDetails);
}
