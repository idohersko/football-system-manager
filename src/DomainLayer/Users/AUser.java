package DomainLayer.Users;

public abstract class AUser {
    public static int counter = 0; //todo update from DB in each initialization

    private String name;
    private String password;
    private int ID;
    private boolean isActive;

    public void LogIN(){
        // todo implement
    }

    public void LogOut(){
        // todo implement
    }
}
