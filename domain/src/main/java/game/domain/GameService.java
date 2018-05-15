package game.domain;

import game.db.WorldDb;

import java.util.List;
import java.util.Map;

public class GameService {

    private WorldDb db;


    public GameService(WorldDb db) {
        this.db = db;
    }

    public World getWorld(long id) {
        return db.getWorld(id);
    }

    public void deleteWorld(World world) {
        db.removeWorld(world);
    }

    public void deleteWorld(long id) {
        db.removeWorld(id);
    }

    public void updateWorld(World world) {
        db.updateWorld(world);
    }

    public void addWorld(World world) {
        db.addWorld(world);
    }

    public Map<Long, World> getWorlds() {
        return db.getWorlds();
    }

    public List<World> getWorldsList() {
        return db.getWorldsList();
    }

    public boolean contains(World world) {
        return db.contains(world);
    }

    public long getNextId() {
        return db.getNextId();
    }
}
