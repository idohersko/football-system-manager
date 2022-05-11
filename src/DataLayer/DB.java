package DataLayer;
import java.sql.SQLException;
import java.util.*;

public interface DB <T> {

    String get(String name);

    List<String> getAll();

    void save(T t) throws SQLException;

    void update(T t, String[] params) throws SQLException;

    void delete(T t);
}
