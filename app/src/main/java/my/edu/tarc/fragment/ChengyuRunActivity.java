package my.edu.tarc.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChengyuRunActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButtonclose;
    private ImageView imagech;
    private Dialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyu_run);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

         alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.popwindow);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().setLayout((int) (width * .9), (int) (height * .8));
        imagech = (ImageView) alertDialog.getWindow().findViewById(R.id.imageViewcycontent);
        alertDialog.setCanceledOnTouchOutside(true);


        imageButton1 = (ImageButton)findViewById(R.id.imageButtoncy1);
        imageButton2 = (ImageButton)findViewById(R.id.imageButtoncy2);
        imageButton3 = (ImageButton)findViewById(R.id.imageButtoncy3);
        imageButton4 = (ImageButton)findViewById(R.id.imageButtoncy4);
        imageButtonclose = (ImageButton) alertDialog.getWindow().findViewById(R.id.imageButtonclose);
        imageButtonclose.setOnClickListener(this);
        imageButton1.setOnClickListener(this);  imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);  imageButton4.setOnClickListener(this);

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
    public void onClick (View v){
        if(v.getId()==R.id.imageButtoncy1) {
            alertDialog.show();
            imagech.setImageResource(R.drawable.imagecy1);

        } if(v.getId()==R.id.imageButtoncy2) {
            alertDialog.show();
            imagech.setImageResource(R.drawable.imagecy2);

        } if(v.getId()==R.id.imageButtoncy3) {
            alertDialog.show();
            imagech.setImageResource(R.drawable.imagecy3);


        } if(v.getId()==R.id.imageButtoncy4) {
            alertDialog.show();
            imagech.setImageResource(R.drawable.imagecy4);

        }
        if(v.getId()==R.id.imageButtonclose)
            alertDialog.dismiss();
    }
}
