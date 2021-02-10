package DmitryT74.task.User;

import java.util.Objects;
//Parameters for String.
public class UserByString implements User<String> {
    private String id;//identificator
    private String type;//Type of user Admin or User ( normal/regular)
    private String login;//Login name
    private String password;//password for user
    //Type of user can be changed only by admin and can give admin rights to others, for now incapsulated
    private void setType(String tp)
    {
        this.type=tp;
    }
    //constructor that allow user to make changes on hes/hers behalf
    UserByString(String id, String log, String ps)
    {
        this.id=id;
        this.password=ps;
        this.login=log;
        this.type="User";
    }
    UserByString(String id, String tp, String nk, String pas)
    {
        this.id=id;
        this.type=tp;
        this.login=nk;
        this.password=pas;
    }
    @Override
    public String getId() {
        return id;
    }
    public String getNikName() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNikName(String nikName) {
        login = nikName;
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return this.id+" "+this.login+" "+this.type;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserByString)) return false;
        UserByString userByString = (UserByString) o;
        return Objects.equals(id, userByString.id) && Objects.equals(type, userByString.type) && Objects.equals(login, userByString.login) && Objects.equals(password, userByString.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, type, login, password);
    }
}
