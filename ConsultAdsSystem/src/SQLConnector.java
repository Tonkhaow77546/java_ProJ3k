

import java.sql.*;

public abstract class SQLConnector{
    private String adress;
    private String DBName;
    private String DBTable;
    /*
    TableStructure example:
    (id INTEGER NOT NULL, name VARCHAR(255) DEFAULT NULL, PRIMARY KEY ( id ))
    */
    
    private String SQLUserName;
    private String SQLPassword;
    
    protected Connection connection;
    protected ResultSet resultSet;
    protected Statement statement;
    
    private boolean connectionReady = false;
    private boolean tableReady = false;
    
    public SQLConnector(String adress, String DBName, String DBTable, String SQLUserName, String SQLPassword){
        this.adress = adress;
        this.DBName = DBName;
        this.DBTable = DBTable;
        this.SQLUserName = SQLUserName;
        this.SQLPassword = SQLPassword;
        connect();
    }
    
    public final void connect(){
        try{
            System.out.println("Start connecting to adress...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+adress, SQLUserName, SQLPassword);
            System.out.println("Adress connected!!!");
            System.out.println("Searching desired DB...");
            ResultSet catalogSet = connection.getMetaData().getCatalogs();
            while (catalogSet.next()){
                if (DBName.equals(catalogSet.getString(1))){
                    System.out.println("Found your DB!!!");
                    redirectDBAdress();
                    tableReady = true;
                    return;
                }
            }
            System.out.println("Your desired DB not found, creating new one...");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.execute("CREATE DATABASE "+DBName);
            System.out.println("Created new DB!!!");
            redirectDBAdress();
            
            System.out.println("Searching desired DBTable...");
            ResultSet tableSet = connection.getMetaData().getTables(DBName, null, DBTable, null);
            if (tableSet.next()){
                System.out.println("Found your DBTable!!!");
                tableReady = true;
            }else{
                System.out.println("Your table not found, use createTable()!!!");
            }
        }catch(ClassNotFoundException| SQLException e){
            System.out.println("###DB Connection failed###");
            System.out.println(e);
        }
    }
    
    private void redirectDBAdress(){
        try{
            System.out.println("Redirecting you to DB...");
            if(statement != null)
                statement.close();
            connection.close();
            connection = DriverManager.getConnection("jdbc:mysql://"+adress+"/"+DBName, SQLUserName, SQLPassword);
            System.out.println("Redirected you to DB!!!");
            System.out.println("Creating statement...");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement created!!!");
            connectionReady = true;
        }catch(SQLException e){
            System.out.println("###Failed to redirect DBAdress###");
            System.out.println(e);
        }
    }
    
    public void refreshConnection(){
        if (connectionReady)redirectDBAdress();
    }
    
    public final void disconnect(){
        try{
            if (connection != null && connectionReady){
                System.out.println("Start disconnecting...");
                resultSet.close();
                statement.close();
                connection.close();
                connectionReady = false;
                System.out.println("Disconnected!!!");
            }
        }catch(SQLException e){
            System.out.println("###Disconnect failed###");
            System.out.println(e);
        }
    }
    
    public void executeStatement(String cmd){
        try{
            if (connectionReady && statement != null){
                System.out.println("Start excuting statement...");
                resultSet = statement.executeQuery(cmd);
                System.out.println("Statement excuted!!!");
            }
        }catch(SQLException e){
            System.out.println("###Excute sql statement failed###");
            System.out.println(e);
        }
    }
    
    public void createTable(String structure){
        try{
            if (!tableReady){
                System.out.println("Creating new table with "+structure+"...");
                statement.execute("CREATE TABLE "+DBTable+" "+structure);
                System.out.println("Table created!!!");
                tableReady = true;
            }else{
                System.out.println("Table exits can not create another");
            }
        }catch(SQLException e){
            System.out.println("###Table create failed###");
            System.out.println(e);
        }
    }
    
    public boolean isTableReady(){
        return tableReady;
    }
    public boolean isConnectoinReady(){
        return connectionReady;
    }
    public String getAdress(){
        return adress;
    }public void setAdress(String adress){
        this.adress = adress;
    }
    public String getDBName(){
        return DBName;
    }public void setDBName(String DBName){
        this.DBName = DBName;
    }
    public String getDBTable(){
        return DBTable;
    }public void setDBTalbe(String DBTable){
        this.DBTable = DBTable;
    }
    public String getSQLUserName(){
        return SQLUserName;
    }public void setSQLUserName(String SQLUserName){
        this.SQLUserName = SQLUserName;
    }
    public String getSQLPassword(){
        return SQLPassword;
    }public void setSQLPassword(String SQLPassword){
        this.SQLPassword = SQLPassword;
    }
}