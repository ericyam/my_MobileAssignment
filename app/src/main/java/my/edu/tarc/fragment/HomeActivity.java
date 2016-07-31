package my.edu.tarc.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.haha,R.drawable.emergency,R.drawable.emergency,R.drawable.emergency};
    public static String [] prgmNameList={"阿斯顿","c++","JAVA","Jsp"};
    public static String [] subList={"cdasdasdasdasdasd","c++","JAVA","Jsp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages,subList));
    }
}
