package com.zakat.andersentask31.service;

import com.zakat.andersentask31.entity.PlanetDetails;

import java.util.List;

public interface PlanetDetailsServiceInterface {
    List<PlanetDetails> findAllPlanetDetails();

    void addPlanetDetails(PlanetDetails planetDetails);

    PlanetDetails findPlanetDetailsById(int id);

    void deletePlanetDetails(int id);

    void updatePlanetDetails(PlanetDetails planetDetails);

    int findPlanetDetailsByPlanetName(String planetName);
}
