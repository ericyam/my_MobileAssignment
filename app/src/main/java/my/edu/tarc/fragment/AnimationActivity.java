package my.edu.tarc.fragment;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class AnimationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InputStream stream = null;
        try {
            stream = getAssets().open("nan1.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        GifDecoderView view = new GifDecoderView(this, stream);

        setContentView(view);
    }
}