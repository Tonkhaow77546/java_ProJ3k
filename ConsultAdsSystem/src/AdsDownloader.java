

import java.io.*;
import java.util.*;
import java.sql.*;
public class AdsDownloader extends SQLConnector{
    /*
    DB structure example:
      primary_key
    |   ads_id   |   file_name   |   hyperlink   |   image   |
          INT         VARCHAR         VARCHAR         BLOB
    */
    
    public AdsDownloader(String adress, String DBName, String DBTable, String SQLUserName, String SQLPassword){
        super(adress, DBName, DBTable, SQLUserName, SQLPassword);
        
        if (!this.isTableReady()){
            this.createTable("(ads_id INTEGER NOT NULL,"
                    + " name VARCHAR(255) DEFAULT NULL,"
                    + " hyperlink VARCHAR(255) DEFAULT NULL,"
                    + " visual MEDIUMBLOB, PRIMARY KEY ( ads_id ))");
        }
    }
    
    public ArrayList<AdsImageIcon> dowloadAds(){
        try{
            ArrayList<AdsImageIcon> adsArrayList = new ArrayList();
            executeStatement("select * from "+getDBTable());
            while(resultSet.next()){
                try (InputStream inputStream = resultSet.getBinaryStream("visual")) {
                    AdsImageIcon adsImage = new AdsImageIcon(resultSet.getString("name"), resultSet.getString("hyperlink"),inputStream.readAllBytes());
                    adsArrayList.add(adsImage);
                }
            }
            return adsArrayList;
        }catch(IOException | SQLException e){
            System.out.println("FAILED TO DOWNLOAD IMAGE.");
            System.out.println(e);
            return null;
        }
    }
}