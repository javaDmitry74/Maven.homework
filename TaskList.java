package DmitryT74.task.Application;

import java.util.LinkedList;

 class TasksList<T> implements TaskAble<T>{
    private LinkedList<T>date;
    TasksList()
    {
        this.date=new LinkedList<T>();
    }
    @Override
    public void pushFront(T obj)  {
        this.date.addFirst(obj);
    }
    //adding to end database of tasks
    @Override
    public void pushBack(T obj) {
        this.date.addLast(obj);
    }
    //extracting highest priority task
    @Override
    public T Front() {
        return date.getFirst();
    }
    //extracting latest added task
    @Override
    public T Last() {
        return date.getLast();
    }
    //Deleting from the front and then addition will be based on priority of task
    @Override
    public void popFront() {
        date.removeFirst();
    }
    public  int getSize()
    {
        return this.date.size();
    }

}
