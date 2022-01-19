package com.zakat.andersentask31.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class PlanetLegionPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "planet_id", nullable = false)
    int planet_id;
    @Column(name = "legion_id", nullable = false)
    int legion_id;

    public PlanetLegionPK() {
    }

    public PlanetLegionPK(int planet_id, int legion_id) {
        this.planet_id = planet_id;
        this.legion_id = legion_id;
    }

    public int getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(int planet_id) {
        this.planet_id = planet_id;
    }

    public int getLegion_id() {
        return legion_id;
    }

    public void setLegion_id(int legion_id) {
        this.legion_id = legion_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetLegionPK that = (PlanetLegionPK) o;
        return planet_id == that.planet_id && legion_id == that.legion_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planet_id, legion_id);
    }
}
