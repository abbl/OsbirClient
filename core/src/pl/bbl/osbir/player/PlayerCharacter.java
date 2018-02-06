package pl.bbl.osbir.player;

public class PlayerCharacter {
    private String name;

    public PlayerCharacter(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
