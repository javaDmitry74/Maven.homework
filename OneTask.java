package DmitryT74.task.Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class OneTask extends Task {
    private String dat_cr;//Data of creation the task
    //Now constructors
    private String body;//short description of the task

    private Priority StrToEnumPr(String s) {
        //Priority to 3 kinds
        Priority ans;
        if (s.equalsIgnoreCase("hig"))
            ans = Priority.Hig;
        else if (s.equalsIgnoreCase("low"))
            ans = Priority.Low;
        else ans = Priority.Middle;
        return ans;
    }

    private Categor StrToEnumKot(String s) {
        //Category also 3 kinds
        Categor ans;
        if (s.equalsIgnoreCase("t_one"))
            ans = Categor.T_One;
        else if (s.equalsIgnoreCase("t_two"))
            ans = Categor.T_Two;
        else ans = Categor.T_Three;
        return ans;
    }

    //Incapsulating changes about data of creating task only admin can do that
    private void setDat_cr(String d) {
        this.dat_cr = d;
    }
    //polymorphism reloading method changes by  LocalDate
    private void setDat_cr(LocalDate lc) {
        this.dat_cr = lc.toString();
    }
    private enum Categor {
        //category of tasks
        T_One,
        T_Two,
        T_Three
    }
    private Categor ct;//category of tasks

    private enum Priority {
        Hig,
        Middle,
        Low
    }
    private Priority priority;

    //Implementing constructor
    OneTask()//constructor by default
    {
        super();//calling constructor from superclass
        this.body = "-";
        this.dat_cr = LocalDate.now().toString();
        priority = Priority.Hig;
        ct = Categor.T_One;
    }
    //constructor parameters
    OneTask(String t, String k, String pr, String d, String d_c, String _bd) {
        super(t, k, pr, d);//transfering parameters of constructor to superclass
        this.priority = this.StrToEnumPr(super.getPrt());//re-transforming to enumerated type
        this.ct = this.StrToEnumKot(super.getKat());
        this.dat_cr = d_c;
        this.body = _bd;
    }
    OneTask(OneTask obj) {
        super(obj);
        this.ct = obj.ct;
        this.body = obj.body;
        this.dat_cr = obj.dat_cr;
        this.priority = obj.priority;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getDat_cr() {
        return dat_cr;
    }
    public void setKt(Categor kt) {
        this.ct = ct;
    }
    public void setKt(String k) {
        this.ct = this.StrToEnumKot(super.getKat());
    }
    public String getKt() {
        return ct.toString();
    }
    public String getPriority() {
        return priority.toString();
    }
    public void setPriority(Priority p) {
        this.priority = p;
    }
    public void setPriority(String sp) {
        this.priority = this.StrToEnumPr(super.getPrt());//re-transforming to enumerated type
    }
    //reloading method  toString
    @Override
    public String toString() {
        return super.toString() + " " +
                this.dat_cr + " " + this.body;
    }
    //implemented method giving us how many days left until task is complete
    @Override
    public long getDayToDo() {
        LocalDate cur = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DatDo = LocalDate.parse(super.getDat_v(), formatter);
        return cur.until(DatDo, ChronoUnit.DAYS);
    }
    //implementing check if we still have time to complete task than we will have True
    @Override
    public boolean isHaveTime() {
        if (getDayToDo() > 0) {
            return true;
        }
        return false;
    }
}