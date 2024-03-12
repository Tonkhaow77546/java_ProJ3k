
public class Account {
    private boolean admin;
    private String name;
    private int id;
    public Account(){
        this(false, "", -1);
    }
    public Account(boolean i_admin, String i_name, int i_id){
        this.admin = i_admin;
        this.name = i_name;
        this.id = i_id;
    }
    public boolean GetAdmin(){
        return admin;
    }
    public String GetName(){
        return name;
    }
    public int GetID(){
        return id;
    }
}

