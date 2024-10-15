package com.ooplab2;

import java.util.List;

public class CandyItem {
  private String id;
  private String name;
  private int energy;
  private String type;
  private boolean filling;
  private List<String> ingredients;
  private float proteins;
  private float fats;
  private float carbohydrates;
  private String production;

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getEnergy() {
    return energy;
  }
  public void setEnergy(int energy) {
    this.energy = energy;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public boolean isFilling() {
    return filling;
  }
  public void setFilling(boolean filling) {
    this.filling = filling;
  }
  public List<String> getIngredients() {
    return ingredients;
  }
  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }
  public float getProteins() {
    return proteins;
  }
  public void setProteins(float proteins) {
    this.proteins = proteins;
  }
  public float getFats() {
    return fats;
  }
  public void setFats(float fats) {
    this.fats = fats;
  }
  public float getCarbohydrates() {
    return carbohydrates;
  }
  public void setCarbohydrates(float carbohydrates) {
    this.carbohydrates = carbohydrates;
  }
  public String getProduction() {
    return production;
  }
  public void setProduction(String production) {
    this.production = production;
  }

  public String toString() {
    return this.id + ' ' + this.name + ' ' + this.energy + ' ' + this.type + ' ' + this.proteins + ' ' + this.fats + ' ' + this.carbohydrates + ' ' + this.production;
  }
}
