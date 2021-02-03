package com.example.nguyenthithungan.graphview;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.lang.reflect.Array;
import java.nio.channels.GatheringByteChannel;
import java.text.ParseException;
import java.util.ArrayList;


import com.opencsv.CSVReader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private InputStream inputStream;
    private String[] ids;


    private static final String TAG = MainActivity.class.getSimpleName();


    @TargetApi(Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );




        Sleeping sleeping = new Sleeping();

        ArrayList<Sleeping> lsleeping = new ArrayList<Sleeping>(  ) ;


        try {
            inputStream = getResources().openRawResource( R.raw.totalsleep );
            lsleeping = sleeping.readingCVS( inputStream );
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sCurrD = "12/09/2017";
        Date currentD = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );

        try {
            currentD = dateFormat.parse( sCurrD );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d( TAG,"year before format"+  currentD );
        GraphView graph = (GraphView) findViewById( R.id.graph );
        ArrayList<Sleeping> lsleepingWeek = sleeping.getSleepWeek( lsleeping, currentD );
      //



        GraphViewData gViewData = new GraphViewData();
        int[] arr = gViewData.setArrayValueGraph( lsleepingWeek, 7 );


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











     //  ArrayList<Sleeping> lsleepingMonth = sleeping.getSleepMonth( lsleeping, currentD );

     //   GraphViewData gViewData = new GraphViewData();
      //  gViewData.drawSleepMonth( lsleepingMonth,graph,currentD );

      //  gViewData.drawSleepWeek( lsleepingWeek,graph );






        /*   show grap of weeek
        ArrayList<Sleeping> lsleepingWeek;
        lsleepingWeek = sleeping.getSleepingWeek( lsleeping, CurrentD );
        GraphView graph = (GraphView) findViewById( R.id.graph );
        GraphViewData gViewData = new GraphViewData();
        int[] arr = gViewData.setArrayValueGraph(lsleepingWeek,7);


        BarGraphSeries<DataPoint> series = new BarGraphSeries<>( new DataPoint[]{


                new DataPoint( 0 ,arr[0]),
                new DataPoint( 1 ,arr[1] ),
                new DataPoint( 2 ,arr[2] ),
                new DataPoint( 3 ,arr[3]),
                new DataPoint( 4 ,arr[4]),
                new DataPoint( 5 ,arr[5]),
                new DataPoint( 6 ,arr[6] )

        } );


        graph.addSeries( series );
        graph.setContentDescription( "Sleeping Chart" );

*/

    }






}
