package game.db;

import game.domain.*;

import java.util.*;

public class WorldDbLocal implements WorldDb {
    private static Map<Long, World> werelden = new HashMap<Long, World>();

    public WorldDbLocal() {
        World jef = new World(getNextId());
        werelden.put(jef.getId(), jef);

        Building[][] mapTom = {{new Empty(), new Consumer(), new Farm()}, {new Farm(), new Empty(), new Consumer()}, {new Consumer(), new Farm(), new Empty()}};
        World tom = new World(mapTom, getNextId(), "Japan");
        werelden.put(tom.getId(), tom);

        Building[][] mapKarel = {{new Consumer(), new Consumer(), new Consumer()}, {new Farm(), new Farm(), new Consumer()}, {new Consumer(), new Farm(), new Farm()}};
        World karel = new World(mapKarel, getNextId(), "Rusland");
        werelden.put(karel.getId(), karel);

    }


    // Exceptions

    @Override
    public void addWorld(World world) {
        if (werelden.containsKey(world.getId())) {
            throw new DbException("Wereld bestaat al");
        } else {
            werelden.put(world.getId(), world);
        }
    }

    @Override
    public void removeWorld(World world) {
        if (werelden.containsKey(world.getId())) {
            werelden.remove(world.getId());
        } else {
            throw new DbException("Wereld bestaat niet");
        }

    }


    //TODO
    @Override
    public void removeWorld(long id) {
        if (werelden.containsKey(id)) {
            werelden.remove(id);
        } else {
            throw new DbException("Wereld bestaat niet");
        }
    }

    @Override
    public void updateWorld(World world) {
        if (werelden.containsKey(world.getId())) {
            werelden.replace(world.getId(), world);
        } else {
            throw new DbException("Wereld bestaat niet");
        }
    }

    @Override
    public World getWorld(long id) {
        if (!werelden.containsKey(id)) {
            throw new DbException("No world found!");
        }
        return werelden.get(id);

    }

    @Override
    public Map<Long, World> getWorlds() {
        return werelden;
    }

    @Override
    public boolean contains(World world) {
        long id = world.getId();
        if (werelden.containsKey(id)) {
            return true;
        }
        return false;
    }

    @Override
    public List<World> getWorldsList() {
        List<World> result = new ArrayList<World>();
        for (long id : werelden.keySet()) {
            result.add(werelden.get(id));
        }
        return result;
    }

    @Override
    public long getNextId() {
        Set<Long> keys = werelden.keySet();
        boolean found = false;
        long newId = 0;

        while (!found) {
            newId = new Random().nextLong();
            if (keys.contains(newId)) {
                found = false;
            } else if (newId <= 0) {
                found = false;
            } else {
                found = true;
            }
        }
        return newId;
    }


}
