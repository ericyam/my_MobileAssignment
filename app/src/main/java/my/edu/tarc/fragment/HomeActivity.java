package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import my.edu.tarc.fragment.Database.BihuaData;
import my.edu.tarc.fragment.Database.UserDataSource;

public class HomeActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    Intent intent;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.learning,R.drawable.survival,R.drawable.test,R.drawable.about};
    public static String [] prgmNameList={"LEARNING","SURVIVAL CHINESE","MOCK TEST","ABOUT APP"};
    public static String [] subList={"Learn chinese material","All in hand","Test your skill","App developer information"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        saveRecord();

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages,subList));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    intent = new Intent(HomeActivity.this, LearningActivity.class);
                    startActivity(intent);
                }
                if(position == 1){
                    intent = new Intent(HomeActivity.this, SurvChineseActivity.class);
                    startActivity(intent);
                }
                if(position == 3){
                    intent = new Intent(HomeActivity.this, AboutActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void saveRecord(){
        UserDataSource userDataSource = new UserDataSource(this);
        userDataSource.open();
        userDataSource.delete();

        String[] zhuci = {"男孩\n男人", "番薯\n饭并"};
        String[] detail ={"男 (he; male; son )\n〈名〉\n(1) (会意。从田,从力。表示用力(一说指耒)在田间耕作。本义:男人,与“女”相对)\n\n(2) 同本义 [man]\n\n(3) 又如:男事(古指成年男子应尽的职责);男夫(成年男子);男圻(犹男服);男教(对男子的教化);男德(有德行的男子);男权(男子在家庭、社会中的支配性特权)\n\n(4) 引申为儿子 [boy;son]",
                "番"};
        BihuaData bihuaData = new BihuaData();
        for(int i=0; i<zhuci.length; i++) {
            bihuaData.setZhuci(zhuci[i]);
            bihuaData.setDetail(detail[i]);
            userDataSource.insertUser(bihuaData);
        }

    }
}
