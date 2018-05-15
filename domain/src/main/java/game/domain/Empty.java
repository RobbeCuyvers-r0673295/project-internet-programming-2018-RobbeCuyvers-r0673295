package game.domain;

public class Empty implements Building {
    public static String IMAGEACTIVE = "\\game\\resources\\images\\EmptyActive.png";
    public static String IMAGEOUT = "\\game\\resources\\images\\Empty.png";
    public static int COST = 0;

    private String image;

    public Empty() {
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
        return type.toLowerCase().equals("empty");
    }
}