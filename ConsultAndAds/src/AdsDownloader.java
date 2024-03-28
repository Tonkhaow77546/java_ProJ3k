import java.io.*;
import java.util.*;
import java.sql.*;
public class AdsDownloader extends SQLUser{
    /*
    DB structure example:
      primary_key
    |   ads_id   |   file_name   |   hyperlink   |   image   |
          INT         VARCHAR         VARCHAR         BLOB
    */
    public AdsDownloader(String DBAdress, String DBTable){
        super(DBAdress, DBTable);
    }
    
    public ArrayList<HasAdsDetails> dowloadAds(int[] adsIDs){
        try{
            ArrayList<HasAdsDetails> adsArrayList = new ArrayList();
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