package DataLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GamesDB implements DB<GamesDB> {
    @Override
    public Optional<GamesDB> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<GamesDB> getAll() {
        return null;
    }

    @Override
    public void save(GamesDB games) throws SQLException {

    }

    @Override
    public void update(GamesDB games, String[] params) {

    }

    @Override
    public void delete(GamesDB games) {

    }
}
