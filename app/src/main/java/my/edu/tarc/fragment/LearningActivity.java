package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class LearningActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));


    }

    @Override
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

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] images = {
                R.drawable.bihua,
                R.drawable.bihua,
                R.drawable.bihua,
                R.drawable.bihua,
                R.drawable.bihua,
                R.drawable.bihua,
                R.drawable.bihua
        };
        private String [] title={
                "阿斯顿",
                "c++",
                "JAVA",
                "Jsp",
                "Jsp",
                "Jsp",
                "Jsp"};

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
            /*ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(280,280));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
            imageView.setImageResource(images[i]);*/

            Holder holder=new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.learningfunction, null);
            rowView.setLayoutParams(new GridView.LayoutParams(300,350));

            //set Text and Listener is here <---------------------
            holder.tv=(TextView) rowView.findViewById(R.id.item_text);
            holder.img=(ImageView) rowView.findViewById(R.id.item_image);
            holder.img.setImageResource(images[i]);
            holder.tv.setText(title[i]);
            return rowView;
        }
    }

}
