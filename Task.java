package DmitryT74.task.Application;

import java.time.LocalDate;
import java.util.Objects;
//creating abstract class of tasks
public abstract class Task {
    private  String title;//Title (Name)
    private String cat;//Category (
    private String prt;//Priority (
    private String dat_v;//Date of completing yyyy-mm-dd
    //Implementing constructor
    Task()
    {
        this.title="-";
        this.dat_v= LocalDate.now().toString();
        this.cat="t_one";
        this.prt="hig";
    }
    Task(String t,String k,String pr,String d)
    {
        this.title=t;
        this.cat=k;
        this.prt=pr;
        this.dat_v=d;
    }
    Task(Task t)
    {
        this.prt=t.prt;
        this.cat=t.cat;
        this.dat_v=t.dat_v;
        this.title=t.title;
    }
    public void setTitle(String s)
    {
        this.title=s;
    }
    void setKat(String k)
    {
        this.cat=k;
    }
    public void setPrt(String p)
    {
        this.prt=p;
    }
    public void setDat_v(String d)
    {
        this.dat_v=d;
    }
    public void setDat_v(LocalDate d)
    {
        this.dat_v=d.toString();
    }
    public String getDat_v() {
        return dat_v;
    }
    public String getKat() {
        return cat;
    }
    public String getPrt() {
        return prt;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(cat, task.cat) && Objects.equals(prt, task.prt) && Objects.equals(dat_v, task.dat_v);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, cat, prt, dat_v);
    }
    @Override
    public String toString() {
        return  title + " " +
                cat + " " + prt + " " + dat_v ;
    }
    //We declare method that return how many days left to complete our task
    public abstract long getDayToDo();//days left until completing the task
    public abstract boolean isHaveTime();//Do we still have time to complete task
}
