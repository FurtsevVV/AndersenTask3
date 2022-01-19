package com.zakat.andersentask31.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="planet_legions")
public class PlanetLegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PlanetLegionPK planetLegionPK;

@Column(name = "legion_contingent")
    int contingent;

    public PlanetLegion() {
    }

    public PlanetLegionPK getPlanetLegionPK() {
        return planetLegionPK;
    }

    public void setPlanetLegionPK(PlanetLegionPK planetLegionPK) {
        this.planetLegionPK = planetLegionPK;
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
        return contingent == that.contingent && Objects.equals(planetLegionPK, that.planetLegionPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetLegionPK, contingent);
    }
}
