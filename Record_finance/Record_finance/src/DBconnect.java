



import java.sql.*;
public class DBconnect implements FunctionDB{
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String user = "root";
    private final String pass = "root";
    protected Connection connect;
    protected int id;
    
    @Override
    public void setID(int id){
        this.id = id;
    }
    @Override
    public Connection getConnection() {
        return connect;
    }
    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url,user, pass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getID(){
        return this.id;
    }
}
