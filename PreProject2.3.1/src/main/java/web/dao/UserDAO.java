package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> index();

    public User show(int id);

    public void update(int id, User updatedUser);
    public  void save(User user);

    void delete(int id);
}
