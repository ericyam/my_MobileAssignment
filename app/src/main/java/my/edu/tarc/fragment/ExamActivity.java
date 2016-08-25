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

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class ExamActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, buttonnext;
    TextView textViewTime;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    int fragpage = 1;
    char a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14;
    static long mins = 1800000;
    static int totalcorrect = 0;
    static int totalanswered = 0;
    boolean[] clicked = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        fragment = new Q1();
        clicked[0] = true;
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
        btn1.setBackgroundColor(getResources().getColor(R.color.colorBlue));


        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    switch(fragpage){
                    case 1 : fragment = new Q2();clicked[1] = true;buttonnext.setText("Next"); break;
                    case 2 : fragment = new Q3();clicked[2] = true;buttonnext.setText("Next"); break;
                    case 3 : fragment = new Q4();clicked[3] = true;buttonnext.setText("Next"); break;
                    case 4 : fragment = new Q5();clicked[4] = true;buttonnext.setText("Next"); break;
                    case 5 : fragment = new Q6();clicked[5] = true;buttonnext.setText("Next"); break;
                    case 6 : fragment = new Q7();clicked[6] = true;buttonnext.setText("Next"); break;
                    case 7 : fragment = new Q8();clicked[7] = true;buttonnext.setText("Next"); break;
                    case 8 : fragment = new Q9();clicked[8] = true;buttonnext.setText("Next"); break;
                    case 9 : fragment = new Q10();clicked[9] = true;buttonnext.setText("Next"); break;
                    case 10 : fragment = new Q11();clicked[10] = true;buttonnext.setText("Next"); break;
                    case 11 : fragment = new Q12();clicked[11] = true;buttonnext.setText("Next"); break;
                    case 12 : fragment = new Q13();clicked[12] = true;buttonnext.setText("Next"); break;
                    case 13 : fragment = new Q14();clicked[13] = true;buttonnext.setText("Done"); break;
                    case 14 : showResult();break;
                }
                if(fragpage < 15)
                    fragpage = fragpage + 1;

                setsmallbtnBackground();
                fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
                fragmentTransaction.commit();
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
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);

        textViewTime = (TextView)findViewById(R.id.textViewTime);
        textViewTime.setText("00:30:00");
        CounterClass timer= new CounterClass(mins,1000);
        timer.start();
        //timer.cancel();

    }

    public void setsmallbtnBackground(){
        getAnswer();
        setbtnbackground();
        if(clicked[0] && fragpage != 1){
            if (a1 == 'Y' || a1 == 'N') {
                btn1.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn1.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[1] && fragpage != 2){
            if (a2 == 'Y' || a2 == 'N') {
                btn2.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn2.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }

        }
        if(clicked[2] && fragpage != 3) {
            if (a3 == 'Y' || a3 == 'N') {
                btn3.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn3.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[3] && fragpage != 4) {
            if (a4 == 'Y' || a4 == 'N') {
                btn4.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn4.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[4] && fragpage != 5) {
            if (a5 == 'Y' || a5 == 'N') {
                btn5.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn5.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[5] && fragpage != 6) {
            if (a6 == 'Y' || a6 == 'N') {
                btn6.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn6.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[6] && fragpage != 7) {
            if (a7 == 'Y' || a7 == 'N') {
                btn7.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn7.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[7] && fragpage != 8) {
            if (a8 == 'Y' || a8 == 'N') {
                btn8.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn8.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[8] && fragpage != 9) {
            if (a9 == 'Y' || a9 == 'N') {
                btn9.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn9.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[9] && fragpage != 10) {
            if (a10 == 'Y' || a10 == 'N') {
                btn10.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn10.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[10] && fragpage != 11) {
            if (a11 == 'Y' || a11 == 'N') {
                btn11.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn11.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[11] && fragpage != 12) {
            if (a12 == 'Y' || a12 == 'N') {
                btn12.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn12.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[12] && fragpage != 13) {
            if (a13 == 'Y' || a13 == 'N') {
                btn13.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn13.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
        if(clicked[13] && fragpage != 14) {
            if (a14 == 'Y' || a14 == 'N') {
                btn14.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else {
                btn14.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }

    }

    public void getAnswer(){
        a1 = Q1.getAnswered();
        a2 = Q2.getAnswered();
        a3 = Q3.getAnswered();
        a4 = Q4.getAnswered();
        a5 = Q5.getAnswered();
        a6 = Q6.getAnswered();
        a7 = Q7.getAnswered();
        a8 = Q8.getAnswered();
        a9 = Q9.getAnswered();
        a10 = Q10.getAnswered();
        a11 = Q11.getAnswered();
        a12 = Q12.getAnswered();
        a13 = Q13.getAnswered();
        a14 = Q14.getAnswered();
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
            a14 = Q14.getAnswered();
            showResult();
        }else if(item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    public void showResult(){
        getAnswer();
        if(a1 == 'Y' || a1 == 'N') {
            totalanswered += 1;
            if (a1 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a2 == 'Y' || a2 == 'N') {
            totalanswered += 1;
            if (a2 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a3 == 'Y' || a3 == 'N') {
            totalanswered += 1;
            if (a3 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a4 == 'Y' || a4 == 'N') {
            totalanswered += 1;
            if (a4 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a5 == 'Y' || a5 == 'N') {
            totalanswered += 1;
            if (a5 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a6 == 'Y' || a6 == 'N') {
            totalanswered += 1;
            if (a6 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a7 == 'Y' || a7 == 'N') {
            totalanswered += 1;
            if (a7 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a8 == 'Y' || a8 == 'N') {
            totalanswered += 1;
            if (a8 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a9 == 'Y' || a9 == 'N') {
            totalanswered += 1;
            if (a9 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a10 == 'Y' || a10 == 'N') {
            totalanswered += 1;
            if (a10 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a11 == 'Y' || a11 == 'N') {
            totalanswered += 1;
            if (a11 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a12 == 'Y' || a12 == 'N') {
            totalanswered += 1;
            if (a12 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a13 == 'Y' || a13 == 'N') {
            totalanswered += 1;
            if (a13 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(a14 == 'Y' || a14 == 'N') {
            totalanswered += 1;
            if (a14 == 'Y') {
                totalcorrect = totalcorrect + 1;
            }
        }
        if(totalanswered == 14) {
            finish();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("time", textViewTime.getText().toString());
            intent.putExtra("totalcorrect", totalcorrect);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Please answer all the question", Toast.LENGTH_LONG).show();
            totalanswered = 0;
            totalcorrect = 0;
        }
    }

    public void setbtnbackground(){
        if(fragpage == 1){
            btn1.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn2.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn3.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn4.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn5.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn6.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn7.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn8.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn9.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn10.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn11.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn12.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn13.setBackgroundColor(getResources().getColor(R.color.colorBlue));
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
            btn14.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1 : fragment = new Q1(); fragpage = 1;clicked[0] = true;buttonnext.setText("Next");break;
            case R.id.btn2 : fragment = new Q2(); fragpage = 2;clicked[1] = true;buttonnext.setText("Next");break;
            case R.id.btn3 : fragment = new Q3(); fragpage = 3;clicked[2] = true;buttonnext.setText("Next");break;
            case R.id.btn4 : fragment = new Q4(); fragpage = 4;clicked[3] = true;buttonnext.setText("Next");break;
            case R.id.btn5 : fragment = new Q5(); fragpage = 5;clicked[4] = true;buttonnext.setText("Next");break;
            case R.id.btn6 : fragment = new Q6(); fragpage = 6;clicked[5] = true;buttonnext.setText("Next");break;
            case R.id.btn7 : fragment = new Q7(); fragpage = 7;clicked[6] = true;buttonnext.setText("Next");break;
            case R.id.btn8 : fragment = new Q8(); fragpage = 8;clicked[7] = true;buttonnext.setText("Next");break;
            case R.id.btn9 : fragment = new Q9(); fragpage = 9;clicked[8] = true;buttonnext.setText("Next");break;
            case R.id.btn10 : fragment = new Q10(); fragpage = 10;clicked[9] = true;buttonnext.setText("Next");break;
            case R.id.btn11 : fragment = new Q11(); fragpage = 11;clicked[10] = true;buttonnext.setText("Next");break;
            case R.id.btn12 : fragment = new Q12(); fragpage = 12;clicked[11] = true;buttonnext.setText("Next");break;
            case R.id.btn13 : fragment = new Q13(); fragpage = 13;clicked[12] = true;buttonnext.setText("Next");break;
            case R.id.btn14 : fragment = new Q14(); fragpage = 14;clicked[13] = true;buttonnext.setText("Done");break;
        }
        setsmallbtnBackground();
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
            String hms = String.format(" %02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            //System.out.println(hms);
            textViewTime.setText(hms);
        }
    }



}
