package game.db;

public class DbFactory {
    public static WorldDb createDb(String db){
        switch (db){
            case "local":
                return new WorldDbLocal();
            case "jpa":
                return new WorldDbJpa();
            default:
                return new WorldDbLocal();
        }
    }
}
