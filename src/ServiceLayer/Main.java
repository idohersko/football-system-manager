package ServiceLayer;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Users.AUser;
import DomainLayer.Users.Referee;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        UsersDB instance = UsersDB.getInstance();
        Referee ref = new Referee("naama","naama123", Enums.ActivationStatus.ACTIVE,Enums.UserType.Referee,Enums.RefereeLevel.Primary);
        instance.delete(ref);
        System.out.println(instance.getAll());
        //instance.save(ref);
        String[] params = new String[]{"naama","naama!!!",Enums.UserType.Referee.toString(),Enums.ActivationStatus.INACTIVE.toString()};
        instance.update(ref,params);
        System.out.println(instance.getAll());

        //instance.save(ref);
    }

}
