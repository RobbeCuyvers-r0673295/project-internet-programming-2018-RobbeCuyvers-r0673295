package game.db;

import game.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

//D:/Program Files/Java/jdk/db/lib
public class WorldDbJpa implements WorldDb {
    EntityManagerFactory entityManagerFactory;
    //EntityManager entityManager;

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

        World jef = new World(getNextId());
        World tom = new World(getNextId(), "Japan");
        World karel = new World(getNextId(), "Rusland");

        addWorld(jef);
        addWorld(tom);
        addWorld(karel);
    }

    @Override
    public void addWorld(World world) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (entityManager.contains(world)) {
            throw new DbException("Wereld bestaat al");
        }
        entityManager.persist(world);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void removeWorld(World world) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //if(entityManager.contains(world)){
        World dbWordl = entityManager.merge(world);
        try{
            entityManager.remove(dbWordl);
        } catch (Exception e) {
            System.out.println(e.getMessage()); //TODO SOUT
        }
        //} else {
        //    throw new DbException("Bestaat niet");
        //}
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void removeWorld(long id) {
        removeWorld(getWorld(id));
    }

    @Override
    public void updateWorld(World world) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        World dbWorld = entityManager.find(World.class, world.getId());
        dbWorld.setName(world.getName());
        dbWorld.setId(world.getId());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public World getWorld(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        World w = entityManager.find(World.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return w;
    }

    @Override
    public Map<Long, World> getWorlds() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<World> werelden = entityManager.createQuery("select a from World a", World.class).getResultList();
        Map<Long, World> result = new HashMap<Long, World>();
        for (World world : werelden) {
            result.put(world.getId(), world);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public boolean contains(World world) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean b = entityManager.contains(world);
        entityManager.getTransaction().commit();
        entityManager.close();
        return b;
    }

    @Override
    public List<World> getWorldsList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<World> result = entityManager.createQuery("select a from World a", World.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public long getNextId() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<World> werelden = entityManager.createQuery("select a from World a", World.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        Set<Long> keys = new HashSet<Long>();
        for (World w : werelden) {
            keys.add(w.getId());
        }

        boolean found = false;
        long newId = 0;

        while (!found){
            newId = new Random().nextLong();
            if (keys.contains(newId) || newId < 1){
                found = false;
            } else {
                found = true;
            }
        }
        return newId;
    }
}
