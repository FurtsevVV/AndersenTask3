package com.zakat.andersentask31.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "legions")
public class Legion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "legion_name")
    String legion_name;

    public Legion() {
    }

    public Legion(String legion_name) {

        this.legion_name = legion_name;
    }



    @ManyToMany(mappedBy = "legions", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<PlanetDetails> planetDetails;

    public List<PlanetDetails> getPlanetDetails() {
        return planetDetails;
    }

    public void setPlanetDetails(List<PlanetDetails> planetDetails) {
        this.planetDetails = planetDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegion_name() {
        return legion_name;
    }

    public void setLegion_name(String legion_name) {
        this.legion_name = legion_name;
    }

    @Override
    public String toString() {
        return "Legion{" +
                "id=" + id +
                ", legion_name='" + legion_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Legion legion = (Legion) o;
        return Objects.equals(id, legion.id) && Objects.equals(legion_name, legion.legion_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, legion_name);
    }
}
