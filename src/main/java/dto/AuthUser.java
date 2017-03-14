package dto;

/**
 * Created by Nikolay on 04.01.2017.
 */
public class AuthUser {
    private Integer id;
    private String login;
    private String role;
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", username='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
