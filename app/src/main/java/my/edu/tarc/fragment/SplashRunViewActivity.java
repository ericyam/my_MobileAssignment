package my.edu.tarc.fragment;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ImageView;

public class SplashRunViewActivity extends AppCompatActivity {
    ImageView imageMict;
    AnimationDrawable animat;
        /** Duration of wait **/
        private final int SPLASH_DISPLAY_LENGTH = 1000;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_splash_run_view);
            getSupportActionBar().hide();
            imageMict = (ImageView)findViewById(R.id.splashscreen);
            imageMict.setBackgroundResource(R.drawable.animatesplash);
            animat = (AnimationDrawable) imageMict.getBackground();
            animat.run();

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(SplashRunViewActivity.this,HomeActivity.class);
                    SplashRunViewActivity.this.startActivity(mainIntent);
                    SplashRunViewActivity.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }
    }