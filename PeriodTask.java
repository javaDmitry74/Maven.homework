package DmitryT74.task.Application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PeriodTask extends Task{
    private String dat_cr;//Data when task are created
    //now constructors
    private  String body;//description of the task
    private long perCnt;//periods in days
    //Incapsulation of data , only admin can change
    private void setDat_cr(String d)
    {
        this.dat_cr=d;
    }
    //polymorphism reloading method changes by  LocalDate
    private void setDat_cr(LocalDate lc)
    {
        this.dat_cr=lc.toString();
    }
    private enum Category {
        //category of tasks
        T_One,
        T_Two,
        T_Three;
    }
    private Category ct;//category of tasks
    private enum Priority
    {
        Hig,
        Middle,
        Low
    }
    private Priority priority;
    //Implementing constructor
    PeriodTask()//constructor by default
    {
        super();//calling constructor from superclass
        this.body="-";
        this.dat_cr= LocalDate.now().toString();
        priority= Priority.Hig;
        ct= Category.T_One;
        this.perCnt=0;
    }
    //constructor parameters
    PeriodTask(String t,String k,String pr,String d,String d_c,String _bd)
    {
        super(t,k,pr,d);//transfering parameters of constructor to superclass
        this.priority= Priority.valueOf(pr);//re-transforming to enumerated type
        this.ct= Category.valueOf(k);
        this.dat_cr=d_c;
        this.body=_bd;
        this.perCnt=getDayToDo();
    }
    PeriodTask(PeriodTask obj)
    {
        super(obj);
        this.ct=obj.ct;
        this.body=obj.body;
        this.dat_cr=obj.dat_cr;
        this.priority=obj.priority;
        this.perCnt=obj.perCnt;
    }
    //only admins can change data that why we incapsulating
    private void setPerCnt(long perCnt) {
        this.perCnt = perCnt;
        //when period will change so and date of completing the task
        LocalDate lc=LocalDate.parse(super.getDat_v());
        lc=lc.plusDays(perCnt);
        super.setDat_v(lc);
    }
    //now getter which returning period in days
    public long getPerCnt() {
        return perCnt;
    }
    //rest is like class OneTask
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getDat_cr() {
        return dat_cr;
    }
    public void setKt(Category kt) {
        this.ct = kt;
    }
    public void setKt(String k)
    {
        this.ct= Category.valueOf(k);
    }
    public String getKt() {
        return ct.toString();
    }
    public String getPriority() {
        return priority.toString();
    }
    public void setPriority(Priority p)
    {
        this.priority=p;
    }
    public void setPriority(String sp)
    {
        this.priority= Priority.valueOf(sp);
    }

    @Override
    public String toString() {
        return super.toString()+" "+
                this.dat_cr+" "+this.body+" "+String.valueOf(this.perCnt);
    }
    //now implementing method giving us how many days left until task is complete
    @Override
    public long getDayToDo()
    {
        LocalDate cur=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DatDo=LocalDate.parse(super.getDat_v(),formatter);
        return cur.until(DatDo, ChronoUnit.DAYS);
    }
    //implementing check if we still have time to complete task than we will have True
    @Override
    public boolean isHaveTime()
    {
        if (getDayToDo()>0) {
            return true;
        }
        return false;
    }
    //implementing method that show us period of completing the task
    public long CntPer(LocalDate lc)
    {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate=LocalDate.parse(this.dat_cr,formatter);
        long ans=startDate.until(lc,ChronoUnit.DAYS);
        return Math.floorDiv(ans,this.perCnt);
    }

}
