package game.domain;

import javax.swing.*;

public class Tile {
    private Building building;
    private String image;

    public String getImage() {
        return building.getImage();
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Tile(Building building) {
        setBuilding(building);
        setImage(building.getImage());
    }
    //empty constructor
    public Tile(){
        setBuilding(null);
        setImage(null);
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

}
