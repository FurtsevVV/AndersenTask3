package com.zakat.andersentask31.service;

import com.zakat.andersentask31.DAO.PlanetDAOInterface;
import com.zakat.andersentask31.DAO.PlanetDetailsDAO;
import com.zakat.andersentask31.entity.PlanetDetails;

import java.util.List;

public class PlanetDetailsService implements PlanetDetailsServiceInterface {
    PlanetDAOInterface planetDAO = new PlanetDetailsDAO();

    @Override
    public List<PlanetDetails> findAllPlanetDetails() {
        return planetDAO.findAllPlanetDetails();
    }

    @Override
    public void addPlanetDetails(PlanetDetails planetDetails) {
        planetDAO.addPlanetDetails(planetDetails);
    }

    @Override
    public PlanetDetails findPlanetDetailsById(int id) {
        return planetDAO.findPlanetDetailsById(id);
    }

    @Override
    public void deletePlanetDetails(int id) {
        planetDAO.deletePlanetDetails(id);
    }

    @Override
    public void updatePlanetDetails(PlanetDetails planetDetails) {
        planetDAO.updatePlanetDetails(planetDetails);
    }

    @Override
    public int findPlanetDetailsByPlanetName(String planetName) {
        return planetDAO.findPlanetDetailsByPlanetName(planetName);
    }
}
