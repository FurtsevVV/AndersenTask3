package com.zakat.andersentask31.model;

public class TotalInfoModel {

    int modelId;
    String planetname;
    int population;
    String legion;
    int leg_contingent;

    public TotalInfoModel() {
    }

    public TotalInfoModel(String planetname, int population, String legion, int leg_contingent) {
        this.planetname = planetname;
        this.population = population;
        this.legion = legion;
        this.leg_contingent = leg_contingent;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getPlanetname() {
        return planetname;
    }

    public void setPlanetname(String planetname) {
        this.planetname = planetname;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLegion() {
        return legion;
    }

    public void setLegion(String legion) {
        this.legion = legion;
    }

    public int getLeg_contingent() {
        return leg_contingent;
    }

    public void setLeg_contingent(int leg_contingent) {
        this.leg_contingent = leg_contingent;
    }

    @Override
    public String toString() {
        return "TotalInfoModel{" +
                "modelId=" + modelId +
                ", planetname='" + planetname + '\'' +
                ", population=" + population +
                ", legion='" + legion + '\'' +
                ", leg_contingent=" + leg_contingent +
                '}';
    }
}
