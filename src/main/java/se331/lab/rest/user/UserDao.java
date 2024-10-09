package se331.lab.rest.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}