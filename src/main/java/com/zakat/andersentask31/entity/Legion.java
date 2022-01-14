package com.zakat.andersentask31.entity;

import java.util.Objects;

public class Legion {
    Integer id;
    String legion_name;

    public Legion() {
    }

    public Legion(String legion_name) {

        this.legion_name = legion_name;
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
