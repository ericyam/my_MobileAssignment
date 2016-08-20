package my.edu.tarc.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import my.edu.tarc.fragment.Database.BihuaData;
import my.edu.tarc.fragment.Database.UserDataSource;

public class BiHuaActivity extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"第一课", "第二课", "第三课"};
    int Numoftabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bihua);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numoftabs);

        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout)findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setViewPager(pager);
    }


    /*
    private void initToolbars() {
        Toolbar toolbarBottom = (Toolbar) findViewById(R.id.toolbar_bottom);
        toolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_next:
                        Toast.makeText(getApplicationContext(), "hihi", Toast.LENGTH_LONG).show();
                      //  break;
                }
                return true;
            }
        });
        // Inflate a menu to be displayed in the toolbar
        toolbarBottom.inflateMenu(R.menu.menu_main);
    }*/



}
