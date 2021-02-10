package DmitryT74.task.Application;

import java.util.*;

//Create your own sheet base
public interface TaskAble <T> {
    void pushFront(T obj);
    void pushBack(T obj);
    void popFront();
    T Front();
    T Last();
}
