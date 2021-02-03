package com.example.nguyenthithungan.graphview;


import android.provider.ContactsContract;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GraphViewData {

    private static final String TAG = "GraphViewData";
    private ArrayList<Sleeping> lGSleep;
    public String valueX;
    public int valueY;
    public String valueDate;


    public GraphViewData(String valueX, int valueY, String valueDate) {
        super();
        this.valueX = valueX;
        this.valueY = valueY;
        this.valueDate = valueDate;
    }

    public GraphViewData() {
        super();


    }


    public String getValueX() {
        return valueX;
    }

    public void setValueX(String valueX) {
        this.valueX = valueX;
    }

    public int getValueY() {
        return valueY;
    }

    public void setValueY(int valueY) {
        this.valueY = valueY;
    }

    /*
    private boolean isDate(int numDate, ArrayList<Sleeping> lSleepWeek) {
        for (int i = 0; i < lSleepWeek.size(); i++) {
            int iDate = lSleepWeek.get( i ).getStart_time().getDay();
            if (iDate == numDate) {
                return true;
            }

        }
        return false;
    }
*/


    public int[] setArrayValueGraph(ArrayList<Sleeping> lSleepWeek, int x) {

        int myList[] = new int[x];
        for (int i = 0; i < lSleepWeek.size(); i++) {
            int mValue = Integer.parseInt( lSleepWeek.get( i ).getMinutes_asleep() );
            myList[lSleepWeek.get( i ).getStart_time().getDay()] = mValue;
        }
        return myList;
    }


    public void drawSleepWeek(ArrayList<Sleeping> lSleepWeek, GraphView graph) {

        GraphViewData gViewData = new GraphViewData();
        int[] arr = gViewData.setArrayValueGraph( lSleepWeek, 7 );


        BarGraphSeries<DataPoint> series = new BarGraphSeries<>( new DataPoint[]{

                new DataPoint( 0, arr[0] ),
                new DataPoint( 1, arr[1] ),
                new DataPoint( 2, arr[2] ),
                new DataPoint( 3, arr[3] ),
                new DataPoint( 4, arr[4] ),
                new DataPoint( 5, arr[5] ),
                new DataPoint( 6, arr[6] )

        } );


        graph.addSeries( series );
        graph.setContentDescription( "Sleeping Chart week" );

    }


    public void drawSleepMonth(ArrayList<Sleeping> lSleepMonth, GraphView graph, Date currDate) {

        GraphViewData gViewData = new GraphViewData();




        GetDateCalenda getDateCalenda = new GetDateCalenda(currDate);

        Date lastDate = getDateCalenda.getLastDateOfMonth();
        Calendar cal = Calendar.getInstance();
        cal.setTime(lastDate);

        int day = cal.get(Calendar.DAY_OF_MONTH);
        DataPoint[] data = new DataPoint[day];

        for (int i = 1; i <= day; i++) {
            data[i] = new DataPoint( i, 0 );

            Log.d(TAG,"draw sleep month aaaaaaaaaaaaaa , data  "+ i+data[i].toString());
        }

        for (int i = 0; i < lSleepMonth.size(); i++) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(lSleepMonth.get( i ).getStart_time());
            int idate = cal1.get(Calendar.DAY_OF_MONTH);

            data[idate] = new DataPoint( idate, Integer.parseInt( lSleepMonth.get( i ).getMinutes_asleep() ) );



        }


        BarGraphSeries<DataPoint> series = new BarGraphSeries<>( data );


        graph.addSeries( series );
        graph.setContentDescription( "Sleeping Chart month" );

    }

}







