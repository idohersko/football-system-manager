package DataLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GamesDB implements DB<GamesDB> {
    @Override
    public String get(String name) {
        return "";
    }

    @Override
    public List<String> getAll() {
        return null;
    }

    @Override
    public void save(GamesDB t) {

    }

    @Override
    public void update(GamesDB games, String[] params) {

    }

    @Override
    public void delete(GamesDB games) {

    }
}
