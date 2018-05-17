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


        entityManagerFactory = Persistence.createEntityManagerFactory("WorldDb");
        entityManager = entityManagerFactory.createEntityManager();

        World jef = new World(getNextId());
        World tom = new World(getNextId(), "Japan");
        World karel = new World(getNextId(), "Rusland");

        addWorld(jef);
        addWorld(tom);
        addWorld(karel);
    }

    @Override
    public void addWorld(World world) {
        entityManager.getTransaction().begin();
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
        System.out.println("remove");
        entityManager.remove(world);
        //} else {
        //    throw new DbException("Bestaat niet");
        //}
        entityManager.getTransaction().commit();

    }

    @Override
    public void removeWorld(long id) {
        System.out.println("long");
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
        entityManager.getTransaction().begin();
        World w = entityManager.find(World.class, id);
        entityManager.getTransaction().commit();
        return w;
    }

    @Override
    public Map<Long, World> getWorlds() {
        entityManager.getTransaction().begin();
        List<World> werelden = entityManager.createQuery("select a from World a", World.class).getResultList();
        Map<Long, World> result = new HashMap<Long, World>();
        for (World world : werelden) {
            result.put(world.getId(), world);
        }

        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    public boolean contains(World world) {
        entityManager.getTransaction().begin();
        boolean b = entityManager.contains(world);
        entityManager.getTransaction().commit();
        return b;
    }

    @Override
    public List<World> getWorldsList() {
        entityManager.getTransaction().begin();
        List<World> result = entityManager.createQuery("select a from World a", World.class).getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    public long getNextId() {
        entityManager.getTransaction().begin();
        List<World> werelden = entityManager.createQuery("select a from World a", World.class).getResultList();
        entityManager.getTransaction().commit();
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
