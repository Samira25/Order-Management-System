package co.innoweb.Service;

import co.innoweb.model.User_role;

import java.util.List;

public interface User_roleService {
    public void save(User_role user_role);
    public User_role getById(long id);
    public User_role update(User_role user_role);
    public void delete(long id);
    public List<User_role> user_rolelist();
}
