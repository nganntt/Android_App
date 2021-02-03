package com.example.nguyenthithungan.graphview;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Sleeping {

    private static final String TAG = "Sleeping";
    Date start_time;
    Date end__time;
    String minutes_asleep;
    String minutes_awake;
    String number_of_awakenings;
    String time_in_bed;
    String minutes_rem_sleep;
    String minutes_light_sleep;
    String minutes_deep_sleep;
    String sleep_target;
    int size = 10;

    public Sleeping() {

    }

    public void printSleep() {
        Log.e( "Collumn  ", "" + start_time );
        Log.e( "  ", "" + end__time );
        Log.e( "  ", "" + minutes_asleep );
        Log.e( "  ", "" + minutes_awake );
        Log.e( "  ", "" + number_of_awakenings );
        Log.e( "  ", "" + minutes_rem_sleep );
        Log.e( "  ", "" + minutes_light_sleep );
        Log.e( "  ", "" + minutes_deep_sleep );
        Log.e( "  ", "" + sleep_target );
        Log.e( "  ", "" + time_in_bed );

    }

    public Sleeping parsingCVS(String csvLine) {
        Sleeping msleeping = new Sleeping();
        String[] ids;

        ids = csvLine.split( "," );
        try {
            msleeping.start_time = new SimpleDateFormat( "dd/MM/yyyy" ).parse( ids[0] );
            msleeping.end__time = new SimpleDateFormat( "dd/MM/yyyy" ).parse( ids[1] );
            msleeping.minutes_asleep = ids[3];
            msleeping.minutes_awake = ids[4];
            msleeping.number_of_awakenings = ids[5];
            msleeping.time_in_bed = ids[6];
            msleeping.minutes_rem_sleep = ids[7];
            msleeping.minutes_light_sleep = ids[8];
            msleeping.minutes_deep_sleep = ids[9];
            msleeping.sleep_target = ids[10];

        } catch (Exception e) {
            Log.e( "Unknown ", e.toString() );
        }

        return msleeping;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Sleeping> getSleepWeek(ArrayList<Sleeping> sleepingCVS, Date currD){
        GetDateCalenda calenda = new GetDateCalenda( currD );
        ArrayList<Sleeping> sleepWeek = new ArrayList<Sleeping>(  );
        ArrayList<Date> dateWeek = new ArrayList<Date>(  );
        dateWeek = calenda.getLastWeek(currD);


        //get date instance begin from 1 because the first line is field name
        for (int i= 1 ; i < sleepingCVS.size();i++){
            // get current time
            if (sleepingCVS.get( i ).getStart_time().equals( currD ) ){
                sleepWeek.add( sleepingCVS.get( i ) );

            }

            // get a week
            if (sleepingCVS.get(i).getStart_time().after( dateWeek.get( 0 ) ) &&
                    sleepingCVS.get(i).getStart_time().before( dateWeek.get( 1 ) ) ){
                sleepWeek.add( sleepingCVS.get( i ) );

            }

        }


        return sleepWeek;
    }





// get the day sleep in a month
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Sleeping> getSleepMonth(ArrayList<Sleeping> sleepingCVS,Date currD){
        Calendar cal = Calendar.getInstance();
        GetDateCalenda getDateCalenda= new GetDateCalenda( currD );
        Date dEndMonth = getDateCalenda.getLastDateOfMonth();
        Date dBeginMonth = getDateCalenda.getFirstDateOfMonth();
        ArrayList<Sleeping> sleepMonth = new ArrayList<Sleeping>(  );

        //get date instance begin from 1 because the first line is field name
        for (int i= 1 ; i < sleepingCVS.size();i++){

            if (sleepingCVS.get( i ).getStart_time().equals( dBeginMonth ) ){
                sleepMonth.add( sleepingCVS.get( i ) );

            }
            if (sleepingCVS.get( i ).getStart_time().equals( dEndMonth ) ){
                sleepMonth.add( sleepingCVS.get( i ) );

            }
            // get a month
            if (sleepingCVS.get(i).getStart_time().after( dBeginMonth ) &&
                    sleepingCVS.get(i).getStart_time().before( dEndMonth ) ){
                sleepMonth.add( sleepingCVS.get( i ) );

            }

        }


        return sleepMonth;
    }









    public ArrayList<Sleeping> readingCVS (InputStream input){
        String[] ids;

        ArrayList<Sleeping> mlSleeping = new ArrayList<Sleeping>();
        try {
            BufferedReader reader = new BufferedReader( new InputStreamReader( input ) );
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                Sleeping tsleeping = new Sleeping();

                tsleeping = tsleeping.parsingCVS( csvLine );
                mlSleeping.add( tsleeping );
            }


        } catch (IOException ex) {
            throw new RuntimeException( "Error in reading CSV file: " + ex );
        }
        return mlSleeping;


    }


    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd__time() {
        return end__time;
    }

    public void setEnd__time(Date end__time) {
        this.end__time = end__time;
    }

    public String getMinutes_asleep() {
        return minutes_asleep;
    }

    public void setMinutes_asleep(String minutes_asleep) {
        this.minutes_asleep = minutes_asleep;
    }

    public String getMinutes_awake() {
        return minutes_awake;
    }

    public void setMinutes_awake(String minutes_awake) {
        this.minutes_awake = minutes_awake;
    }

    public String getNumber_of_awakenings() {
        return number_of_awakenings;
    }

    public void setNumber_of_awakenings(String number_of_awakenings) {
        this.number_of_awakenings = number_of_awakenings;
    }

    public String getTime_in_bed() {
        return time_in_bed;
    }

    public void setTime_in_bed(String time_in_bed) {
        this.time_in_bed = time_in_bed;
    }

    public String getMinutes_rem_sleep() {
        return minutes_rem_sleep;
    }

    public void setMinutes_rem_sleep(String minutes_rem_sleep) {
        this.minutes_rem_sleep = minutes_rem_sleep;
    }

    public String getMinutes_light_sleep() {
        return minutes_light_sleep;
    }

    public void setMinutes_light_sleep(String minutes_light_sleep) {
        this.minutes_light_sleep = minutes_light_sleep;
    }

    public String getMinutes_deep_sleep() {
        return minutes_deep_sleep;
    }

    public void setMinutes_deep_sleep(String minutes_deep_sleep) {
        this.minutes_deep_sleep = minutes_deep_sleep;
    }

    public String getSleep_target() {
        return sleep_target;
    }

    public void setSleep_target(String sleep_target) {
        this.sleep_target = sleep_target;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}