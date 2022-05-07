package DataLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LeaguesDB implements DB<LeaguesDB> {
    @Override
    public Optional<LeaguesDB> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<LeaguesDB> getAll() {
        return null;
    }

    @Override
    public void save(LeaguesDB leagues) throws SQLException {

    }

    @Override
    public void update(LeaguesDB leagues, String[] params) {

    }

    @Override
    public void delete(LeaguesDB leagues) {

    }
}
