import java.io.*;
import java.sql.*;

public class AdsUploader extends SQLUser{
    /*
    DB structure example:
      primary_key
    |   ads_id   |   file_name   |   hyperlink   |   image   |
          INT         VARCHAR         VARCHAR         BLOB
    */
    
    public AdsUploader(String DBAdress, String DBTable){
        super(DBAdress, DBTable);
    }
    
    public void uploadAds(int adsID, File file, String hyperLink){
        executeStatement("select * from "+getDBTable()+" where ads_id="+adsID);
        
        try(FileInputStream inputStream = new FileInputStream(file)){
            if(!resultSet.next()){
                System.out.println("ADS NOT FOUND CREATING NEW.");
                resultSet.moveToInsertRow();
                resultSet.updateInt("ads_id", adsID);
                resultSet.insertRow();
                resultSet.moveToCurrentRow();
                resultSet.next();
                System.out.println("CREATING SUCCESFULLY");
            }
            resultSet.updateString("file_name", file.getName());
            resultSet.updateString("hyperlink", hyperLink);
            resultSet.updateBlob("image", inputStream);
            resultSet.updateRow();
        }catch(IOException | SQLException e){
            System.out.println("ADS UPDATE FAILED.");
        }
    }
}