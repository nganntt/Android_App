package com.example.nguyenthithungan.graphview;

//import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;





import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.icu.util.Calendar;



public class GetDateCalenda {
    private static final String TAG = "GetDateCalenda";

    public Date currentDate;
    private int endMonth;
    private int endWeek;

    public GetDateCalenda(Date currentDate) {
        this.currentDate = currentDate;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Date> getLastWeek(Date currD) {
        ArrayList<Date> week = new ArrayList<Date>();
        Calendar c = Calendar.getInstance();
        c.setTime( currD );
        int i = c.get( Calendar.DAY_OF_WEEK ) - c.getFirstDayOfWeek();
        c.add( Calendar.DATE, -i - 7 );
        Date start = c.getTime();
        week.add( start );
        c.add( Calendar.DATE, 6 );
        Date end = c.getTime();
        week.add( end );


        return week;

    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public  Date getLastDateOfMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    public  Date getFirstDateOfMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);

        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }



}
