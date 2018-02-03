package pl.bbl.osbir.gameserver;

public class GameServer {
    private String name;
    private String host;
    private int port;

    public GameServer(String name, String host, int port){
        this.name = name;
        this.host = host;
        this.port = port;
    }

    @Override
    public String toString() {
        return name;
    }
}
