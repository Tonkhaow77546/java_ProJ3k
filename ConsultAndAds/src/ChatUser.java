import java.sql.*;
import java.util.*;

public class ChatUser extends SQLUser{
    /*
    DB structure example:
      primary_key
    |   room_id   |   chat_history   |
          INT           LONGTEXT
    */
    
    private String userName;
    private String localChat;
    private ThreadHelper threadHelper;
    private Thread workingThread;
    
    public ChatUser(String DBAdress, String DBTable, int roomID, String userName){
        super(DBAdress, DBTable);
        this.userName = userName;
        executeStatement("select * from "+getDBTable()+" where room_id="+roomID);
        try{
            if(!resultSet.next()){
                System.out.println("CHAT ROOM NOT FOUND CREATING NEW.");
                resultSet.moveToInsertRow();
                resultSet.updateInt("room_id", roomID);
                resultSet.insertRow();
                resultSet.moveToCurrentRow();
                resultSet.next();
                System.out.println("CREATING SUCCESFULLY");
            }
            threadHelper = new ThreadHelper(this);
            workingThread = new Thread(threadHelper);
        }catch(SQLException e){
            System.out.println("CHAT USER CREATE FAILED.");
        }
    }
    
    public void updateDBChat(String message){
        try{
            resultSet.refreshRow();
            String oldChat = resultSet.getString("chat_history");
            if (oldChat == null || oldChat.isBlank() || oldChat.equals("null"))
                oldChat = "";
            resultSet.updateString("chat_history", oldChat+userName+":"+message+"\n");
            resultSet.updateRow();
        }catch(SQLException e){
            System.out.println("UPDATE DB CHAT FAILED.");
            System.out.println(e);
        }
    }
    
    public void updateLocalChat(){
        try{
            resultSet.refreshRow();
            localChat = resultSet.getString("chat_history");
            System.out.println("LOCAL CHAT UPDATED.");
        }catch(SQLException e){
            System.out.println("FAILED TO UPDATE LOCAL CHAT.");
            System.out.println(e);
        }
    }
    public void autoUpdate(){
        workingThread.start();
    }public void stopAutoUpdate(){
        workingThread.interrupt();
    }
    
    public String getRawLocalChat(){
        updateLocalChat();
        return localChat;
    }public ArrayList<String> getModLocalChat(){
        updateLocalChat();
        return new ArrayList(Arrays.asList(localChat.split("\n")));
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
                user.updateLocalChat();
                Thread.sleep(600);
            }
        }catch(InterruptedException e){
            System.out.println("THREAD INTERRUPTED.");
            System.out.println(e);
        }
    }
}