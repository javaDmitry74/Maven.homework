package DmitryT74.task.User;
//We implement and parameterize user class
public interface UserAble <T>{
    T getId();//return id
    T getType();//return level of access or change user data ( admin or user)
}
