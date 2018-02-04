package pl.bbl.osbir.player;

public class Player {
    private String username;
    private String userKey;
    private boolean isVerified;

    public Player(){
        this.isVerified = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setVerificationResult(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public boolean isVerified() {
        return isVerified;
    }
}
