package model;

public class User {
    public String Name;
    public String Authkey;
    public User(String var1, String var2){
        this.Name = var1;
        this.Authkey = (var2);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthkey() {
        return Authkey;
    }

    public void setAuthkey(String authkey) {
        this.Authkey = authkey;
    }
}
