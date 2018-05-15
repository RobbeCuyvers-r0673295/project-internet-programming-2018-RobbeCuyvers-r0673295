package game.domain;

public class Farm implements Building {
    public static String IMAGEACTIVE = "\\game\\resources\\images\\FarmActive.png";
    public static String IMAGEOUT = "\\game\\resources\\images\\FarmOut.png";
    public static int COST = 10;

    private String image;


    public Farm() {
        setImage(false);
    }

    @Override
    public void setImage(boolean b) {
        this.image = b ? IMAGEACTIVE : IMAGEOUT;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void switchImage(boolean b) {
        if (!b) {
            setImage(false);
        } else {
            setImage(true);
        }

    }

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public boolean equals(String type) {
        return type.toLowerCase().equals("farm");
    }
}
