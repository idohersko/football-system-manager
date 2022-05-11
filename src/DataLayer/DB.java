package DataLayer;
import java.sql.SQLException;
import java.util.*;

public interface DB <T> {

    String get(String name);

    List<String> getAll();

    void save(T t) throws SQLException;

    void update(T t, String[] params) throws SQLException;

    void delete(T t);


    //todo - in many function, i have done some system out prints, will it fuck up the tests ? is it right ?
}
