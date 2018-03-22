package co.innoweb.Service;

import co.innoweb.model.Role;

import java.util.List;

public interface RoleService {
    public void save(Role role);
    public Role getById(long id);
    public Role update(Role role);
    public void delete(long id);
    public List<Role> rolelist();
}
