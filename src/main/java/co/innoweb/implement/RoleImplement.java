package co.innoweb.implement;

import co.innoweb.Service.RoleService;
import co.innoweb.model.Role;
import co.innoweb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("RoleService")
public class RoleImplement implements RoleService {

    @Autowired private RoleService roleService;
    @Autowired private RoleRepository roleRepository;
    @Autowired private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public RoleImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role update(Role role) {
        Role r = roleRepository.findOne(role.getId());
        r.setRole_name(role.getRole_name());
        return roleRepository.save(r);
    }

    @Override
    public void delete(long id) {
        Role role = roleRepository.findOne(id);
        roleRepository.delete(role);
    }

    @Override
    public List<Role> rolelist() {
        String sql = "select * from privilege";
        List<Role> roleList = jdbcTemplate.query(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole_name(resultSet.getString("role_name"));
                return role;
            }
        });
        return roleList;
    }
}
