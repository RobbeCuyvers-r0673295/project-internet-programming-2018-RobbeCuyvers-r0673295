package game.domain;

public interface Building {
    // = "\\resources\\images\\Empty.png";

    public void setImage(boolean b);

    public String getImage();

    public void switchImage(boolean b);

    public int getCost();

    public boolean equals(String type);




    //https://coderanch.com/t/609994/java/time-simple-tile-based-java
    //https://stackoverflow.com/questions/16138837/my-first-time-trying-to-make-a-simple-tile-based-java-game
    //https://gamedevelopment.tutsplus.com/tutorials/an-introduction-to-creating-a-tile-map-engine--gamedev-10900
    //https://www.google.be/search?biw=867&bih=954&ei=UheEWpDxJIyP0gWb8pEY&q=java+tile+game+code&oq=java+tile&gs_l=psy-ab.1.1.0i203k1l10.33371.45724.0.48592.10.10.0.0.0.0.353.1185.3j3j1j1.9.0.crnk_dmh...0...1.1.64.psy-ab..1.9.1296.6..0j35i39k1j0i131k1j0i67k1.111.ipw1Bw8AQx0
}
