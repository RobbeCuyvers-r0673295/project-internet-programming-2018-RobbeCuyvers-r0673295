package game.db;

import game.domain.World;

import java.util.List;
import java.util.Map;

public interface WorldDb {
    public void addWorld(World world);

    public void removeWorld(World world);

    public void removeWorld(long id);

    public void updateWorld(World world);

    public World getWorld(long id);

    public Map<Long, World> getWorlds();

    public boolean contains(World world);

    public List<World> getWorldsList();

    public long getNextId();
}
