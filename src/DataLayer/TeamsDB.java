package DataLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TeamsDB implements DB<TeamsDB>{
    @Override
    public Optional<TeamsDB> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<TeamsDB> getAll() {
        return null;
    }

    @Override
    public void save(TeamsDB teams) throws SQLException {

    }

    @Override
    public void update(TeamsDB teams, String[] params) {

    }

    @Override
    public void delete(TeamsDB teams) {

    }
}
