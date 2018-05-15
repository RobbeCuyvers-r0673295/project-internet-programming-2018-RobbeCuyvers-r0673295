package game.domain;

import javafx.stage.Stage;

public class GameController /*implements Observer*/{
    private World world;
    private int currency = 0;
    private int score = 0;
    private Stage stage;
    private boolean farm = false;
    private boolean consumer = false;
    private boolean empty = false;

    public GameController(World world, Stage stage) {
        setWorld(world);
        setStage(stage);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void addCurrency(){
        currency++;
    }

    public void addScore(){
        score++;
    }

    public boolean setConsumer(int x, int y){
        if (currency>=25){
            setCurrency(currency-25);
            world.setAtTile(x,y,new Consumer());
            return true;
        }
        return false;
    }

    public boolean setFarm (int x, int y){
        if (start()){
            world.setAtTile(x,y, new Farm());
            return true;
        } else if (currency >= 10){
            setCurrency(currency - 10);
            world.setAtTile(x,y, new Farm());
            return true;
        }
        return false;
    }

    public boolean start(){

        for (int i = 0; i < world.getHeight(); i++) {
            for (int j = 0; j < world.getWidth(); j++) {
                if(world.getBuilding(i,j) instanceof Farm){
                    return false;
                }
            }
        }
        return true;
    }

    public void switchAlle(String type, boolean b){

        for (int i = 0; i < world.getHeight() ; i++) {
            for (int j = 0; j < world.getWidth() ; j++) {
                if(world.getBuilding(i,j).equals(type)){
                    world.getBuilding(i,j).switchImage(b);
                }
            }
        }
    }
    public void checkChange(){/////////////////////////////////
        farm = getCurrency() >= Farm.COST;
        empty = getCurrency() >= Farm.COST;
        consumer = getCurrency() >= Consumer.COST;

        switchAlle("empty", empty);
        switchAlle("farm", farm);
        switchAlle("consumer", consumer);
    }




    /*@Override
    public void update() {
        Window view = new GameView(this);
    }*/
}
