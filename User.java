package DmitryT74.task.User;
//implement and parameterize user class
public interface User<T> {
    T getId();//return id
    T getType();//return level of access or change user data ( admin or user)
}
