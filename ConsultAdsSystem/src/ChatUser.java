import java.sql.*;
import java.util.*;

public class ChatUser extends SQLConnector{
    private String chatUserName;
    private String localChatData;
    private ThreadHelper threadHelper;
    private Thread workingThread;
    
    public ChatUser(String adress, String DBName, String DBTable, 
            String SQLUserName, String SQLPassword,
            int roomId, String chatUserName){
        super(adress, DBName, DBTable, SQLUserName, SQLPassword);
        this.chatUserName = chatUserName;
        
        if (!this.isTableReady()){
            this.createTable("(room_id INTEGER NOT NULL, chat_history LONGTEXT DEFAULT NULL, PRIMARY KEY ( room_id ))");
        }
        
        executeStatement("SELECT * FROM "+getDBTable()+" WHERE room_id="+roomId);
        try{
            if(!resultSet.next()){
                System.out.println("CHAT ROOM NOT FOUND CREATING NEW.");
                resultSet.moveToInsertRow();
                resultSet.updateInt("room_id", roomId);
                resultSet.insertRow();
                resultSet.moveToCurrentRow();
                resultSet.next();
                System.out.println("CREATING SUCCESFULLY");
            }
            threadHelper = new ThreadHelper(this);
            workingThread = new Thread(threadHelper);
        }catch(SQLException e){
            System.out.println("CHAT USER CREATE FAILED.");
            System.out.println(e);
        }
    }
    
    public void sendMessageToDB(String message){
        try{
            resultSet.refreshRow();
            String oldChat = resultSet.getString("chat_history");
            if (oldChat == null || oldChat.isBlank() || oldChat.equals("null"))
                oldChat = "";
            resultSet.updateString("chat_history", oldChat+chatUserName+":"+message+"\n");
            resultSet.updateRow();
        }catch(SQLException e){
            System.out.println("UPDATE DB CHAT FAILED.");
            System.out.println(e);
        }
    }
    
    public void updateLocalChatData(){
        try{
            resultSet.refreshRow();
            localChatData = resultSet.getString("chat_history");
            System.out.println("LOCAL CHAT UPDATED.");
        }catch(SQLException e){
            System.out.println("FAILED TO UPDATE LOCAL CHAT.");
            System.out.println(e);
        }
    }
    public void autoUpdateLocalChat(){
        workingThread.start();
    }public void stopAutoUpdateLocalChatData(){
        workingThread.interrupt();
    }
    
    public String getRawLocalChatData(){
        updateLocalChatData();
        return localChatData;
    }public ArrayList<String> getModLocalChatData(){
        updateLocalChatData();
        return new ArrayList(Arrays.asList(localChatData.split("\n")));
    }
}
class ThreadHelper implements Runnable{
    private final ChatUser user;
    public ThreadHelper(ChatUser user){
        this.user = user;
    }
    @Override
    public void run(){
        try{
            while(true){
                user.updateLocalChatData();
                Thread.sleep(600);
            }
        }catch(InterruptedException e){
            System.out.println("THREAD INTERRUPTED.");
            System.out.println(e);
        }
    }
}