package DataLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RefereesDB implements DB<RefereesDB>{
    @Override
    public Optional<RefereesDB> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<RefereesDB> getAll() {
        return null;
    }

    @Override
    public void save(RefereesDB referee) throws SQLException {

    }

    @Override
    public void update(RefereesDB referee, String[] params) {

    }

    @Override
    public void delete(RefereesDB referee) {

    }
}
