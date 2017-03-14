package dao;

import dto.AuthUser;
import dto.Role;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nikolay on 03.01.2017.
 */
public class UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT * FROM users INNER JOIN roles ON users.role_id=roles.id";
    private static final String SELECT_AUTH_USER = "SELECT users.id, users.login, roles.authority FROM users INNER JOIN roles ON users.role_id=roles.id WHERE login=?";
    private static final String ADD_USER = "INSERT INTO users (role_id, login, password, enabled) VALUES(?, ?, ?, ?)";
    private static final String SELECT_ROLES = "SELECT * FROM roles";
    private static final String UPDATE_USER = "UPDATE users SET role_id = ?, login = ?, password = ?, enabled = ? WHERE id = ?";
    private static final String SELECT_BY_ID="SELECT * FROM users u INNER JOIN roles r ON u.role_id=r.id WHERE u.id=?";

    public List<User> getUsers() {
        List<User> users = jdbcTemplate.query(SELECT_ALL, new UserRowMapper());
        return users;
    }

    public AuthUser getAuthUser(String login) {
        AuthUser authUser = jdbcTemplate.queryForObject(SELECT_AUTH_USER, new AuthUserRowMapper(), login);
        return authUser;
    }

    public void addUser(User user) {
        jdbcTemplate.update(ADD_USER, user.getRole().getId(), user.getLogin(), user.getPassword(), user.getEnabled());
    }

    public List<Role> getRoles() {
        List<Role> roles = jdbcTemplate.query(SELECT_ROLES, new RoleRowMapper());
        return roles;
    }

    public void updateUser(User user){
        jdbcTemplate.update(UPDATE_USER, user.getRole().getId(), user.getLogin(), user.getPassword(), user.getEnabled(), user.getId());
    }

    public User getUserById(Integer id){
        User user = jdbcTemplate.queryForObject(SELECT_BY_ID, new UserRowMapper(), id);
        return user;
    }


    public static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setAuthority(resultSet.getString("authority"));
            user.setRole(role);
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEnabled(resultSet.getBoolean("enabled"));
            return user;
        }
    }

    public static class RoleRowMapper implements RowMapper<Role> {
        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setAuthority(resultSet.getString("authority"));
            return role;
        }
    }

    public static class AuthUserRowMapper implements RowMapper<AuthUser> {
        @Override
        public AuthUser mapRow(ResultSet resultSet, int i) throws SQLException {
            AuthUser authUser = new AuthUser();
            authUser.setId(resultSet.getInt("id"));
            authUser.setLogin(resultSet.getString("login"));
            authUser.setRole(resultSet.getString("authority"));
            return authUser;
        }
    }
}
