package co.innoweb.implement;

import co.innoweb.Service.User_roleService;
import co.innoweb.model.Customer;
import co.innoweb.model.Role;
import co.innoweb.model.User_role;
import co.innoweb.repository.User_roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("User_roleService")
public class User_roleImplement implements User_roleService {

    @Autowired
    private User_roleService user_roleService;
    @Autowired private User_roleRepository user_roleRepository;
    @Autowired private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public User_roleImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User_role user_role) {
        user_roleRepository.save(user_role);
    }

    @Override
    public User_role getById(long id) {
        return user_roleRepository.findOne(id);
    }

    @Override
    public User_role update(User_role user_role) {
        User_role ur = user_roleRepository.findOne(user_role.getId());
        ur.setRole(user_role.getRole());
        ur.setCustomer(user_role.getCustomer());
        return user_roleRepository.save(ur);
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public List<User_role> user_rolelist() {
        String sql = "";
        List<User_role> user_roleList = jdbcTemplate.query(sql, new RowMapper<User_role>() {
            @Override
            public User_role mapRow(ResultSet resultSet, int i) throws SQLException {
                User_role user_role = new User_role();
                user_role.setId(resultSet.getLong("id"));
                user_role.setCustomer((Customer) resultSet.getArray("id"));
                user_role.setRole((Role) resultSet.getArray("id"));
                return user_role;
            }
        });
        return user_roleList;
    }
}
