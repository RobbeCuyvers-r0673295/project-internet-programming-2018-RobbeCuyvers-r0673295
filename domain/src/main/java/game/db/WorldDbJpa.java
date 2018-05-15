package game.db;

import game.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

//D:/Program Files/Java/jdk/db/lib
public class WorldDbJpa implements WorldDb {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    //TODO fix this (databaseconnectie 2D array?)

    public WorldDbJpa() {
       /* World jef = new World(1);
        werelden.put(jef.getId(),jef);

        Building[][] mapTom = {{new Empty(), new Consumer(), new Farm()},{new Farm(), new Empty(), new Consumer()},{new Consumer(), new Farm(), new Empty()}};
        World tom = new World(mapTom, 2, "Japan");
        werelden.put(tom.getId(), tom);

        Building[][] mapKarel = {{new Consumer(), new Consumer(), new Consumer()},{new Farm(), new Farm(), new Consumer()},{new Consumer(), new Farm(), new Farm()}};
        World karel = new World(mapKarel, 3, "Rusland");
        werelden.put(karel.getId(), karel);*/

        World jef = new World(1);
        World tom = new World(2, "Japan");
        World karel = new World(3, "Rusland");

        entityManagerFactory = Persistence.createEntityManagerFactory("WorldDb");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        addWorld(jef);
        addWorld(tom);
        addWorld(karel);
    }

    @Override
    public void addWorld(World world) {
        //entityManager.getTransaction().begin();
        if (entityManager.contains(world)) {
            throw new DbException("Wereld bestaat al");
        }
        entityManager.persist(world);
        entityManager.getTransaction().commit();

    }

    @Override
    public void removeWorld(World world) {
        entityManager.getTransaction().begin();
        //if(entityManager.contains(world)){
        entityManager.remove(world);
        //} else {
        //    throw new DbException("Bestaat niet");
        //}
        entityManager.getTransaction().commit();

    }

    @Override
    public void removeWorld(long id) {
        removeWorld(getWorld(id));
    }

    @Override
    public void updateWorld(World world) {
        World dbWorld = entityManager.find(World.class, world.getId());
        entityManager.getTransaction().begin();
        dbWorld.setName(world.getName());
        dbWorld.setId(world.getId());
        entityManager.getTransaction().commit();

    }

    @Override
    public World getWorld(long id) {
        return entityManager.find(World.class, id);
    }

    @Override
    public Map<Long, World> getWorlds() {
        List<World> werelden = entityManager.createQuery("select a from World a", World.class).getResultList();
        Map<Long, World> result = new HashMap<Long, World>();
        for (World world : werelden) {
            result.put(world.getId(), world);
        }

        return result;
    }

    @Override
    public boolean contains(World world) {
        return entityManager.contains(world);
    }

    @Override
    public List<World> getWorldsList() {
        return entityManager.createQuery("select a from World a", World.class).getResultList();
    }

    @Override
    public long getNextId() {
        List<World> werelden = entityManager.createQuery("select a from World a", World.class).getResultList();
        Set<Long> keys = new HashSet<Long>();
        for (World w : werelden) {
            keys.add(w.getId());
        }

        boolean found = false;
        long newId = 0;

        while (!found){
            newId = new Random().nextLong();
            if (keys.contains(newId)){
                found = false;
            } else {
                found = true;
            }
        }
        return newId;
    }
}
