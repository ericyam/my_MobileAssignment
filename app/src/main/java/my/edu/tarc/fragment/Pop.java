package my.edu.tarc.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;

/**
 * Created by KIT on 1/8/2016.
 */
public class Pop extends Activity  {


    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
     //   setContentView(R.layout.popwindow);
///
      DisplayMetrics dm = new DisplayMetrics();
       getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
      //  getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Dialog alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.popwindow);

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        alertDialog.getWindow().setLayout((int)(width * .8) ,(int)(height  * .6));


    }
}
