package dto;

/**
 * Created by Nikolay on 03.01.2017.
 */
public class Role {
    private Integer id;
    private String authority;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getAuthority(){
        return authority;
    }

    public void setAuthority(String authority){
        this.authority=authority;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
