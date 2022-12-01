package web.dao;

import org.slf4j.Marker;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{

    private static int USER_COUNT;
    private List<User> users;


    {
        users = new ArrayList<>();
        users.add(new User("User1", 10, "email1@gmail.com", ++USER_COUNT));
        users.add(new User("User2", 20, "email2@gmail.com", ++USER_COUNT));
        users.add(new User("User3", 30, "email3@gmail.com", ++USER_COUNT));
        users.add(new User("User4", 40, "email4@gmail.com", ++USER_COUNT));
    }

    @Override
    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }


    @Override
    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
       User userToBeUpdated = show(id);

       userToBeUpdated.setName(updatedUser.getName());
       userToBeUpdated.setAge(updatedUser.getAge());
       userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }

}
