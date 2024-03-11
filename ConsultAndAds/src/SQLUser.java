import java.sql.*;

public abstract class SQLUser{
    private String DBAdress;
    private String DBTable;
    
    
    protected Connection connection;
    protected ResultSet resultSet;
    protected Statement statement;
    
    public SQLUser(String DBAdress, String DBTable){
        this.DBAdress = DBAdress;
        this.DBTable = DBTable;
        
        connect();
    }
    
    public final void connect(){
        try{
            System.out.println("START CONNECTING.");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+DBAdress);
            System.out.println("DATABASE CONNECTED.");
        }catch(ClassNotFoundException| SQLException e){
            System.out.println("CONNECTION FAILED.");
            System.out.println(e);
        }
    }
    public final void disconnect(){
        try{
            if (connection != null){
                resultSet.close();
                statement.close();
                connection.close();
            }
        }catch(SQLException e){
            System.out.println("DISCONNECT FAILED.");
            System.out.println(e);
        }
    }
    
    public void executeStatement(String cmd){
        try{
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(cmd);
        }catch(SQLException e){
            System.out.println("COMMAND ERROR");
            System.out.println(e);
        }
        
    }
    
    public String getDBAdress(){
        return DBAdress;
    }public void setDBAdress(String DBAdress){
        this.DBAdress = DBAdress;
    }
    
    public String getDBTable(){
        return DBTable;
    }public void setDBTable(String DBTable){
        this.DBTable = DBTable;
    }
}