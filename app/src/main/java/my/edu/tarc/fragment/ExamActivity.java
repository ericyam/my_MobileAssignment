package my.edu.tarc.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import my.edu.tarc.fragment.ExamFragment.Q1;
import my.edu.tarc.fragment.ExamFragment.Q10;
import my.edu.tarc.fragment.ExamFragment.Q11;
import my.edu.tarc.fragment.ExamFragment.Q2;
import my.edu.tarc.fragment.ExamFragment.Q3;
import my.edu.tarc.fragment.ExamFragment.Q4;
import my.edu.tarc.fragment.ExamFragment.Q5;
import my.edu.tarc.fragment.ExamFragment.Q6;
import my.edu.tarc.fragment.ExamFragment.Q7;
import my.edu.tarc.fragment.ExamFragment.Q8;
import my.edu.tarc.fragment.ExamFragment.Q9;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class ExamActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, buttonnext;
    TextView textViewTime;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    int fragpage = 1;
    char a1, a2;
    static long mins = 1800000;
    int totalcorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        fragment = new Q1();
        fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.container, fragment);
        fragmentTransaction.commit();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btn13 = (Button)findViewById(R.id.btn13);
        btn14 = (Button)findViewById(R.id.btn14);

        buttonnext = (Button)findViewById(R.id.buttonNext);
        btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(fragpage){
                    case 1 : fragment = new Q2();break;
                    case 2 : fragment = new Q3();break;
                    case 3 : fragment = new Q4();break;
                    case 4 : fragment = new Q5();break;
                    case 5 : fragment = new Q6();break;
                    case 6 : fragment = new Q7();break;
                    case 7 : fragment = new Q8();break;
                    case 8 : fragment = new Q9();break;
                    case 9 : fragment = new Q10();break;
                    case 10 : fragment = new Q11();break;
                }
                fragpage = fragpage + 1;
                setbtnbackground();
                fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
                fragmentTransaction.commit();

                a1 = Q1.getAnswered();
                if (a1 == 'Y' || a1 == 'N') {
                    btn1.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                    if(a1 == 'Y')
                        totalcorrect =  totalcorrect + 1;
                }else
                    btn1.setBackgroundColor(getResources().getColor(R.color.colorOrange));



            }
        });
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);

        textViewTime = (TextView)findViewById(R.id.textViewTime);
        textViewTime.setText("00:30:00");
        CounterClass timer= new CounterClass(mins,1000);
        timer.start();
        //timer.cancel();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_done){
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("time", textViewTime.getText().toString());
            intent.putExtra("Totalcorrect", totalcorrect);
            startActivity(intent);
        }
        return true;
    }

    public void setbtnbackground(){
        if(fragpage == 1){
            btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 2){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 3){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 4){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 5){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 6){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 7){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 8){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 9){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 10){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 11){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 12){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 13){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn14.setBackground(getResources().getDrawable(R.drawable.border_style));
        }else if(fragpage == 14){
            btn1.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn2.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn3.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn4.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn5.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn6.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn7.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn8.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn9.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn10.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn11.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn12.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn13.setBackground(getResources().getDrawable(R.drawable.border_style));
            btn14.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1 : fragment = new Q1(); fragpage = 1;break;
            case R.id.btn2 : fragment = new Q2(); fragpage = 2;break;
            case R.id.btn3 : fragment = new Q3(); fragpage = 3;break;
            case R.id.btn4 : fragment = new Q4(); fragpage = 4;break;
            case R.id.btn5 : fragment = new Q5(); fragpage = 5;break;
            case R.id.btn6 : fragment = new Q6(); fragpage = 6;break;
            case R.id.btn7 : fragment = new Q7(); fragpage = 7;break;
            case R.id.btn8 : fragment = new Q8(); fragpage = 8;break;
            case R.id.btn9 : fragment = new Q9(); fragpage = 9;break;
            case R.id.btn10 : fragment = new Q10(); fragpage = 10;break;
            case R.id.btn11 : fragment = new Q11(); fragpage = 11;break;
        }
        setbtnbackground();
        fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override public void onFinish() {
            textViewTime.setText("Completed.");
        }
        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            mins = mins - 1000;
            String hms = String.format("%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            //System.out.println(hms);
            textViewTime.setText(hms);
        }
    }


}
