package com.example.customviewworking;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NghiaView nghiaView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nghiaView = (NghiaView)findViewById(R.id.nghiaView);
        nghiaView.setMaxColumnAndMaxColumn(6,6);


//        nghiaView.addData(new Rect(0, 0, 4, 4));
//        nghiaView.addData(new Rect(4,0,6,4));
//        nghiaView.addData(new Rect(0,4,2,6));
//        nghiaView.addData(new Rect(2,4,4,6));
//        nghiaView.addData(new Rect(4,4,6,6));
//
//
//        nghiaView.addData(new Rect(0, 0, 3, 6));
//        nghiaView.addData(new Rect(3, 0, 6, 4));
//        nghiaView.addData(new Rect(3, 4, 6, 6));

      /*  nghiaView.addData(new Rect(0, 0, 4, 2));
        nghiaView.addData(new Rect(4, 0, 6, 4));
        nghiaView.addData(new Rect(0, 2, 4, 6));
        nghiaView.addData(new Rect(4, 4, 6, 6));*/


       /* nghiaView.addData(new Rect(3, 4, 6, 6));
        nghiaView.addData(new Rect(0, 0, 3, 3));
        nghiaView.addData(new Rect(3, 0, 6, 2));
        nghiaView.addData(new Rect(3, 2, 6, 4));
        nghiaView.addData(new Rect(0, 3, 3, 6));*/

        nghiaView.addData(new Rect(0, 0, 2, 2));
        nghiaView.addData(new Rect(0, 2, 2, 4));
        nghiaView.addData(new Rect(0, 4, 2, 6));
        nghiaView.addData(new Rect(2, 0, 4, 2));
        nghiaView.addData(new Rect(2, 2, 4, 4));
        nghiaView.addData(new Rect(2, 4, 4, 6));
        nghiaView.addData(new Rect(4, 0, 6, 2));
        nghiaView.addData(new Rect(4, 2, 6, 4));
        nghiaView.addData(new Rect(4, 4, 6, 6));



      /*  nghiaView.addData(new Rect(0, 0, 4, 4));
        nghiaView.addData(new Rect(4, 0, 6, 4));
        nghiaView.addData(new Rect(0, 4, 2, 6));
        nghiaView.addData(new Rect(2, 4, 4, 6));
        nghiaView.addData(new Rect(4, 4, 6, 6));*/

        /*nghiaView.addData(new Rect(0, 0, 2, 6));
        nghiaView.addData(new Rect(2, 0, 4, 6));
        nghiaView.addData(new Rect(4, 0, 6, 6));*/

      /* nghiaView.addData(new Rect(0, 0, 4, 2));
       nghiaView.addData(new Rect(4, 0, 6, 2));
       nghiaView.addData(new Rect(0, 2, 4, 4));
       nghiaView.addData(new Rect(4, 2, 6, 4));
       nghiaView.addData(new Rect(0, 4, 2, 6));
       nghiaView.addData(new Rect(2, 4, 4, 6));
       nghiaView.addData(new Rect(4, 4, 6, 6));*/
    }
}
