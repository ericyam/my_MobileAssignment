package my.edu.tarc.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import my.edu.tarc.fragment.ExamFragment.Q1;
import my.edu.tarc.fragment.ExamFragment.Q10;
import my.edu.tarc.fragment.ExamFragment.Q11;
import my.edu.tarc.fragment.ExamFragment.Q12;
import my.edu.tarc.fragment.ExamFragment.Q13;
import my.edu.tarc.fragment.ExamFragment.Q14;
import my.edu.tarc.fragment.ExamFragment.Q2;
import my.edu.tarc.fragment.ExamFragment.Q3;
import my.edu.tarc.fragment.ExamFragment.Q4;
import my.edu.tarc.fragment.ExamFragment.Q5;
import my.edu.tarc.fragment.ExamFragment.Q6;
import my.edu.tarc.fragment.ExamFragment.Q7;
import my.edu.tarc.fragment.ExamFragment.Q8;
import my.edu.tarc.fragment.ExamFragment.Q9;

//import com.github.lzyzsd.circleprogress.DonutProgress;


public class ResultActivity extends AppCompatActivity {

    //private DonutProgress donutProgress;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressBar progressBar;
    private TextView textviewpercentage;
    private TextView textviewgrade;
    private ListView listviewresult;
    private TextView textviewgreet;
    String greet = "";
    Button buttonclose;
    Button buttonretake;

    private static String [] title;
    private static String [] resultexam={"","",""};
    int percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        title = getResources().getStringArray(R.array.info);


        Bundle bundle = getIntent().getExtras();
        String timetaken = bundle.getString("time");
        int totalcorrect = bundle.getInt("totalcorrect");
        String[] time = timetaken.split(" : ");

        int m = 29  - Integer.parseInt(time[1]);
        int s = 59  - Integer.parseInt(time[2]);

        String newtime = String.format("%02dm%02ds   ",m,s);

        resultexam[0] = newtime;
        resultexam[2] = String.valueOf(totalcorrect) + "/14   ";
        percentage = (int)((float)totalcorrect/14 * 100);

        if(percentage < 20){
            resultexam[1] = "very bad   ";
        }else if(percentage < 40){
            resultexam[1] = "bad   ";
        }else if(percentage < 60) {
            resultexam[1] = "Normal   ";
        }else if(percentage < 80) {
            resultexam[1] = "Good   ";
        }else{
            resultexam[1] = "Excellent   ";
        }

        //donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        textviewpercentage = (TextView)findViewById(R.id.textViewPercentage);
        textviewgrade = (TextView)findViewById(R.id.textViewGrade);
        textviewgreet = (TextView)findViewById(R.id.textViewGreet);
        listviewresult = (ListView)findViewById(R.id.listViewResult);
        Button buttonclose = (Button)findViewById(R.id.buttonClose);
        Button buttonretake = (Button)findViewById(R.id.buttonRetake);

        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamActivity.mins = 1800000;
                clearAll();
                finish();
                HomeActivity.clicked = false;
                ExamActivity.otherbutton = true;
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonretake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamActivity.mins = 1800000;
                clearAll();
                finish();
                HomeActivity.clicked = true;
                ExamActivity.otherbutton = true;
                Intent intent = new Intent(getApplicationContext(), ExamActivity.class);
                startActivity(intent);
            }
        });


        CustomAdapter2 adapter = new CustomAdapter2(this, title, resultexam);
        listviewresult.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus < percentage){
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //donutProgress.setProgress(progressStatus);
                            progressBar.setProgress(progressStatus);
                            textviewpercentage.setText(String.valueOf(progressStatus) + "%");
                            if(progressStatus<20) {
                                textviewgrade.setText("F");
                                greet = "Study hard. Try next again.";
                                textviewgreet.setText(greet);
                            }
                            else if(progressStatus<40) {
                                textviewgrade.setText("D");
                                greet = "You have to make improvement.";
                                textviewgreet.setText(greet);
                            }
                                else if(progressStatus<60) {
                                textviewgrade.setText("C");
                                greet = "You are doing good.";
                                textviewgreet.setText(greet);

                            }
                            else if(progressStatus<80) {
                                textviewgrade.setText("B");
                                greet = "Well done. Further improvement.";
                                textviewgreet.setText(greet);
                            }
                                else {
                                textviewgrade.setText("A");
                                greet = "Excellent. You did a great job";
                                textviewgreet.setText(greet);
                            }

                        }

                    });

                    try{
                        Thread.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void clearAll(){
        Q1.clearAnswer();
        Q2.clearAnswer();
        Q3.clearAnswer();
        Q4.clearAnswer();
        Q5.clearAnswer();
        Q6.clearAnswer();
        Q7.clearAnswer();
        Q8.clearAnswer();
        Q9.clearAnswer();
        Q10.clearAnswer();
        Q11.clearAnswer();
        Q12.clearAnswer();
        Q13.clearAnswer();
        Q14.clearAnswer();
        ExamActivity.totalanswered = 0;
        ExamActivity.totalcorrect = 0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ExamActivity.mins = 1800000;
        clearAll();
        finish();
        HomeActivity.clicked = false;
    }
}
