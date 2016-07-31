package my.edu.tarc.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.learning,R.drawable.survival,R.drawable.test,R.drawable.about};
    public static String [] prgmNameList={"LEARNING","SURVIVAL CHINESE","MOCK TEST","ABOUT APP"};
    public static String [] subList={"Learn chinese materials","All in hand","Test your skill","App developer information"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages,subList));
    }
}
