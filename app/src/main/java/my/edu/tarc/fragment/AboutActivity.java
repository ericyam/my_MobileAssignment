package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    Intent intent;

    ArrayList prgmName;
    public static int [] prgmImages1={R.drawable.developer1,R.drawable.developer2,R.drawable.letter,R.drawable.iconap};
    public static String [] prgmNameList1={"Developer","Designer","Email Address","App Version"};
    public static String [] subList1={"Daniel","John","xiaoxueba@.edu.com.my","1.5.0"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        context=this;

        lv=(ListView) findViewById(R.id.listView2);
        lv.setAdapter(new CustomAdapter1(this, prgmNameList1,prgmImages1,subList1));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 2){
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"+"xiaoxueba@.edu.com.my"));
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
