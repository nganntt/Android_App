package com.example.nguyenthithungan.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        TextView title = (TextView) findViewById( R.id.title );
        TextView content = (TextView)findViewById(R.id.content);

        title.setText( "This is title of application" );
        String sContent = "This is the content of the appliction, i need to use Stirng Builder to build it";

        StringBuilder stringBuilder = new StringBuilder( );
        for(int i=0 ; i< 100;i++){
            stringBuilder.append(sContent  );
        }

        content.setText( stringBuilder.toString() );


    }
}
