package com.zakat.andersentask31.entity;

import java.util.Objects;

public class PlanetLegion {

    int fk_planet_id;
    int fk_legion_id;
    int contingent;

    public PlanetLegion() {
    }

    public int getFk_planet_id() {
        return fk_planet_id;
    }

    public void setFk_planet_id(int fk_planet_id) {
        this.fk_planet_id = fk_planet_id;
    }

    public int getFk_legion_id() {
        return fk_legion_id;
    }

    public void setFk_legion_id(int fk_legion_id) {
        this.fk_legion_id = fk_legion_id;
    }

    public int getContingent() {
        return contingent;
    }

    public void setContingent(int contingent) {
        this.contingent = contingent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetLegion that = (PlanetLegion) o;
        return fk_planet_id == that.fk_planet_id && fk_legion_id == that.fk_legion_id && contingent == that.contingent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fk_planet_id, fk_legion_id, contingent);
    }

    @Override
    public String toString() {
        return "PlanetLegion{" +
                "fk_planet_id=" + fk_planet_id +
                ", fk_legion_id=" + fk_legion_id +
                ", contingent=" + contingent +
                '}';
    }
}
