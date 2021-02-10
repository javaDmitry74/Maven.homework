package DmitryT74.task.Application;

public class Application {
    public static void main(String[] args) {
        OneTask tsk=new OneTask("Sa","Hig","T_One","2021-02-18","2021-02-07","What is it?");
        //example
        System.out.println("Hurry up , you only have left  "+tsk.getDayToDo()+ " days");
    }
}
