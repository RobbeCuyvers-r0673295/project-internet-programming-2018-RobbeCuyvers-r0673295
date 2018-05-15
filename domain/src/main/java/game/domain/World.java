package game.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class World {

    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Transient
    private Building[][] map = new Building [WIDTH][HEIGHT];

    public World(){

    }

    public World(long id) {
        reset();
        setId(id);
        setName("New World");
    }

    public World(long id, String name){
        reset();
        setId(id);
        setName(name);
    }

    public World(Building[][] map, long id, String name){
        setMap(map);
        setId(id);
        setName(name);
    }

    public void setMap(Building[][] map) {
        if (map == null) {
            throw new DomainException("Invalid map");
        } else {
            this.map = map;
        }
    }

    public void reset(){
        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j <HEIGHT ; j++){
                this.map[i][j] = new Empty();

            }
        }
    }
    // TO-DO checks!
    public void setAtTile(int x, int y, Building building){
        this.map[x][y] = building;
    }

    public void deleteAtTile(int x, int y){
        if (x < 0 || x >= WIDTH){
            throw new DomainException("Invalid X");
        } else if (y < 0 || y >= HEIGHT) {
            throw new DomainException("Invalid Y");
        } else {
            this.map[x][y] = new Empty();
        }

    }

    public Building getBuilding(int x, int y){
        if (x < 0 || x >= WIDTH){
            throw new DomainException("Invalid X");
        } else if (y < 0 || y >= HEIGHT) {
            throw new DomainException("Invalid Y");
        } else {
            return this.map[x][y];
        }
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id < 0){
            throw new DomainException("Invalid id");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new DomainException("Invalid name");
        }
        this.name = name;
    }
}
