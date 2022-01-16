package com.zakat.andersentask31.entity;

import java.util.Objects;

public class PlanetDetails {

    int planet_id;
    String planet;
    int population;

    public PlanetDetails() {
    }

    public PlanetDetails(String planet, int population) {
        this.planet = planet;
        this.population = population;
    }

    public int getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(int planet_id) {
        this.planet_id = planet_id;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "PlanetDetails{" +
                "planet_id=" + planet_id +
                ", planet='" + planet + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetDetails that = (PlanetDetails) o;
        return planet_id == that.planet_id && population == that.population && Objects.equals(planet, that.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planet_id, planet, population);
    }
}
