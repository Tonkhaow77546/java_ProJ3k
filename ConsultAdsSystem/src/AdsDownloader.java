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
    }
    
    public ArrayList<AdsImageIcon> dowloadAds(int[] adsIDs){
        try{
            ArrayList<AdsImageIcon> adsArrayList = new ArrayList();
            for (int eachID : adsIDs){
                executeStatement("select * from "+getDBTable()+" where ads_id="+eachID);
                if (!resultSet.next()) continue;
                try (InputStream inputStream = resultSet.getBinaryStream("image")) {
                    AdsImageIcon adsImage = new AdsImageIcon(resultSet.getString("file_name"), resultSet.getString("hyperlink"),inputStream.readAllBytes());
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