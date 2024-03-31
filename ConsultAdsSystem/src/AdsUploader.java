

import java.io.*;
import java.sql.*;

public class AdsUploader extends SQLConnector{
    /*
    DB structure example:
      primary_key
    |   ads_id   |   file_name   |   hyperlink   |   image   |
          INT         VARCHAR         VARCHAR         MEDIUMBLOB
    */
    
    public AdsUploader(String adress, String DBName, String DBTable, String SQLUserName, String SQLPassword){
        super(adress, DBName, DBTable, SQLUserName, SQLPassword);
        if (!this.isTableReady()){
            this.createTable("(ads_id INTEGER NOT NULL,"
                    + " name VARCHAR(255) DEFAULT NULL,"
                    + " hyperlink VARCHAR(255) DEFAULT NULL,"
                    + " visual MEDIUMBLOB, PRIMARY KEY ( ads_id ))");
        }
    }
    
    public void uploadAds(int adsID, File file, String hyperLink){
        executeStatement("SELECT * FROM "+getDBTable()+" WHERE ads_id="+adsID);
        
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
            resultSet.updateString("name", file.getName());
            resultSet.updateString("hyperlink", hyperLink);
            resultSet.updateBlob("visual", inputStream);
            resultSet.updateRow();
        }catch(IOException | SQLException e){
            System.out.println("ADS UPDATE FAILED.");
        }
    }
}