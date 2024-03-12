
import java.sql.*;
public class RecFinance extends DBconnect {
    public RecFinance() {
        super();
    }
    public void insertRow(String date, double money, String type, String detail){
        try {
            super.connect();
            Statement s = super.getConnection().createStatement();
            String ins = "INSERT INTO mydb.recordsfinance(id, date, money, type, detail) VALUES ('%d', '%s', '%f', '%s', '%s')".formatted(super.getID(), date, money, type, detail);
            //String del = "DELETE FROM mydb.recordsfinance where id = 1;";
            int out = s.executeUpdate(ins);
            super.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String search(int time, String date){
        ResultSet r = null;
        try{
            super.connect();
            Statement s = super.getConnection().createStatement();
            String sql = "SELECT * FROM mydb.recordsfinance where date = \"%s\" and id = %d;".formatted(date, super.getID());
            r = s.executeQuery(sql);
            for(int i=1;i <= time; i++) {
                r.next();
            }
            
            return r.getString("money") + " " + r.getString("type") +  " "+ r.getString("detail");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            super.disconnect();
        }
        return "";
    }
    public int getCount(String date){
        try {
            super.connect();
            Statement s = super.getConnection().createStatement();
            String sql = "SELECT COUNT(date) FROM mydb.recordsfinance where date = \"%s\" and id = %d;".formatted(date, super.getID());
            ResultSet rec = s.executeQuery(sql);
            rec.next();
            return rec.getInt("COUNT(date)");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            super.disconnect();
        }
        return 0;
    }
}
