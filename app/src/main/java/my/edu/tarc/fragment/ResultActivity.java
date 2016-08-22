package my.edu.tarc.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.github.lzyzsd.circleprogress.DonutProgress;


public class ResultActivity extends AppCompatActivity {

    //private DonutProgress donutProgress;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressBar progressBar;
    private TextView textviewpercentage;
    private TextView textviewgrade;
    private ListView listviewresult;

    private static String [] title={"Time Taken","Performance","Correct Count","History"};
    private static String [] resultexam={"","","",">   "};
    int percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        String timetaken = bundle.getString("time");
        int totalcorrect = bundle.getInt("totalcorrect");
        String[] time = timetaken.split(" : ");

        int m = 29  - Integer.parseInt(time[1]);
        int s = 59  - Integer.parseInt(time[2]);

        String newtime = String.format("%02dm%02ds   ",m,s);

        resultexam[0] = newtime;
        resultexam[1] = "good";
        resultexam[2] = String.valueOf(totalcorrect) + "/14";


        //donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        textviewpercentage = (TextView)findViewById(R.id.textViewPercentage);
        textviewgrade = (TextView)findViewById(R.id.textViewGrade);
        listviewresult = (ListView)findViewById(R.id.listViewResult);

        CustomAdapter2 adapter = new CustomAdapter2(this, title, resultexam);
        listviewresult.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus < 100){
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //donutProgress.setProgress(progressStatus);
                            progressBar.setProgress(progressStatus);
                            textviewpercentage.setText(String.valueOf(progressStatus) + "%");
                            if(progressStatus<0)
                                textviewgrade.setText("F");
                            else if(progressStatus<40)
                                textviewgrade.setText("D");
                            else if(progressStatus<60)
                                textviewgrade.setText("C");
                            else if(progressStatus<80)
                                textviewgrade.setText("B");
                            else
                                textviewgrade.setText("A");
                        }
                    });
                    try{
                        Thread.sleep(30);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
