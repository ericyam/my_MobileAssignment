package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SurvChineseActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    Intent intent;

    ArrayList prgmName;
    public static int [] prgmImages2={R.drawable.pushpin,R.drawable.love,R.drawable.meet,R.drawable.food,R.drawable.health,R.drawable.shopping,R.drawable.emergency,R.drawable.fun};
    public static String [] prgmNameList2;
    public static String [] subList2={"","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surv_chinese);
        prgmNameList2 = getResources().getStringArray(R.array.survivallist);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));
        context=this;

        lv=(ListView) findViewById(R.id.listView3);
        lv.setAdapter(new CustomAdapter(this,prgmNameList2, prgmImages2, subList2));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(position == 0){
                  //  lv.setBackgroundColor(Color.parseColor("#d5d5d5"));
                    intent = new Intent(SurvChineseActivity.this, SurvChineseBasicActivity.class);
                    startActivity(intent);
                }
                if(position == 1){

                    intent = new Intent(SurvChineseActivity.this, SurvChineseFlirtActivity.class);
                    startActivity(intent);
                }
                if(position == 2){
                    intent = new Intent(SurvChineseActivity.this, SurvChineseDirectionActivity.class);
                    startActivity(intent);
                }
                if(position == 3){
                    intent = new Intent(SurvChineseActivity.this, SurvChineseFoodActivity.class);
                    startActivity(intent);
                }
                if(position == 4){
                    intent = new Intent(SurvChineseActivity.this, SurvChineseHealthActivity.class);
                    startActivity(intent);
                }
                if(position == 5){
                    intent = new Intent(SurvChineseActivity.this, SurvChineseShoppingActivity.class);
                    startActivity(intent);
                }
                if(position == 6){
                    intent = new Intent(SurvChineseActivity.this, SurvChineseEmergencyActivity.class);
                    startActivity(intent);
                }
                if(position == 7){
                    intent = new Intent(SurvChineseActivity.this, SurvChineseEntertainmentActivity.class);
                    startActivity(intent);
                }



            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
