package DataLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TeamsDB implements DB<TeamsDB>{
    @Override
    public String get(String name) {
        return "";
    }

    @Override
    public List<String> getAll() {
        return null;
    }

    @Override
    public void save(TeamsDB t) {

    }

    @Override
    public void update(TeamsDB teams, String[] params) {

    }

    @Override
    public void delete(TeamsDB teams) {

    }
}
