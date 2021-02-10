package DmitryT74.task.User;

public class UserByInt implements UserAble<Integer>{
    private Integer id;//User id
    private Integer type;//Type 0-admin, 1-user, 2-modifier
    private String NikName;//Login
    private String password;//password
    //Type of user can be changed only by admin and can give admin rights to others, for now incapsulated
    private void setType(Integer tp)
    {
        this.type=tp;
    }

    //constructor that allow user to make changes on hes/hers behalf
    UserByInt(Integer id,String log,String ps)
    {
        this.id=id;
        this.password=ps;
        this.NikName=log;
        this.type=Integer.valueOf(id);
    }
    UserByInt(Integer id,Integer tp,String nk,String pas)
    {
        this.id=id;
        this.type=tp;
        this.NikName=nk;
        this.password=pas;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getNikName() {
        return NikName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNikName(String nikName) {
        NikName = nikName;
    }

    @Override
    public Integer getType() {
        return type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.id.toString()+" "+this.NikName+" "+(((type==1))?"User":"Admin");
    }
}
