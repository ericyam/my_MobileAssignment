package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class LearningActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    intent = new Intent(LearningActivity.this, BiHuaActivity.class);
                    startActivity(intent);
                } if(position == 1){
                    intent = new Intent(LearningActivity.this, ChengyuRunActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] images = {
                R.drawable.bihua,
                R.drawable.chengyu,
                R.drawable.bible,
                R.drawable.meiriyiju,
                R.drawable.shizi,
                R.drawable.sing,
                R.drawable.dizhigui,
                R.drawable.hanyu,
        };
        private String [] title={
                "笔顺",
                "成语",
                "三字经\n(即将推出)",
                "每日一句\n(即将推出)",
                "看图识字\n(即将推出)",
                "童歌拼音\n(即将推出)",
                "弟子规\n(即将推出)",
                "汉语拼音\n(即将推出)",
        };

        private LayoutInflater inflater=null;
        public ImageAdapter(Context c){
            mContext= c;
            inflater = ( LayoutInflater)mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        public class Holder
        {
            TextView tv;
            ImageView img;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Holder holder=new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.learningfunction, null);
            //rowView.setLayoutParams(new GridView.LayoutParams(300,375));

            //set Text and Listener is here <---------------------
            holder.tv=(TextView) rowView.findViewById(R.id.item_text);
            holder.img=(ImageView) rowView.findViewById(R.id.item_image);
            holder.img.setImageResource(images[i]);
            holder.tv.setText(title[i]);
            return rowView;
        }
    }

}
