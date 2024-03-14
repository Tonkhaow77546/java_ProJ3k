import java.util.Calendar;
public class CalendarNaHa {
    public static void main(String[] args) {
        Calendar s = Calendar.getInstance();

        int year = s.get(Calendar.YEAR);
        int month = s.get(Calendar.MONTH) + 1;
        int day = s.get(Calendar.DAY_OF_MONTH);

        System.out.println("Current Date: " + day + "/" + month + "/" + year);
    }
}
