package my.edu.tarc.fragment;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import my.edu.tarc.fragment.Database.BihuaData;
import my.edu.tarc.fragment.Database.UserDataSource;

/**
 * Created by Eric Yam on 7/31/2016.
 */
public class Tab3 extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener{
    ImageButton next;
    ImageButton previous;
    TextView textviewzhuci;
    TextView textviewdetail;
    TextView textviewpaging;
    TextView textviewpinbi;
    UserDataSource userDataSource;
    ImageButton sound;
    TextToSpeech tts;
    final int CHECK_CODE = 1;
    List<BihuaData> values = null;
    int position = 20;
    VideoView vv2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.tab_3, container, false);
        checkTTS();

        sound = (ImageButton)rootView.findViewById(R.id.imageButtonSound);
        next = (ImageButton)rootView.findViewById(R.id.next);
        previous = (ImageButton)rootView.findViewById(R.id.previous);
        textviewzhuci = (TextView)rootView.findViewById(R.id.textViewZhuCi);
        textviewdetail = (TextView)rootView.findViewById(R.id.textViewDetail);
        textviewpaging = (TextView)rootView.findViewById(R.id.textViewPaging);
        textviewpinbi = (TextView)rootView.findViewById(R.id.textViewPinBi);

        vv2 = (VideoView)rootView.findViewById(R.id.videoViewImage);
        vv2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        userDataSource = new UserDataSource(getContext());
        userDataSource.open();

        values = userDataSource.getAllUsers();
        playvideo(values.get(position).getPath());
        textviewzhuci.setText(values.get(position).getZhuci());
        textviewdetail.setText(values.get(position).getDetail());
        textviewpaging.setText( (position-19) +  "/10");
        textviewpinbi.setText(values.get(position).getPinbi());

        sound.setOnClickListener(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position < 29) {
                    position = position + 1;
                    textviewpaging.setText((position - 19) + "/10");
                    textviewzhuci.setText(values.get(position).getZhuci());
                    textviewdetail.setText(values.get(position).getDetail());
                    textviewpinbi.setText(values.get(position).getPinbi());
                    playvideo(values.get(position).getPath());
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position > 20) {
                    position = position - 1;
                    textviewpaging.setText((position - 19) + "/10");
                    textviewzhuci.setText(values.get(position).getZhuci());
                    textviewdetail.setText(values.get(position).getDetail());
                    textviewpinbi.setText(values.get(position).getPinbi());
                    playvideo(values.get(position).getPath());
                }
            }
        });
        return rootView;
    }

    public void playvideo(String uripath2){
        Uri uri2 = Uri.parse(uripath2);
        vv2.setVideoURI(uri2);
        vv2.requestFocus();
        vv2.start();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
            tts = new TextToSpeech(getContext(), this);
        }else{
            Intent install = new Intent();
            install.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            startActivity(install);
        }
    }

    @Override
    public void onClick(View view) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(values.get(position).getId(), TextToSpeech.QUEUE_FLUSH, null, null);
        }else {
            HashMap<String, String> hash = new HashMap<String,String>();
            hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM, String.valueOf(AudioManager.STREAM_NOTIFICATION));
            tts.speak(values.get(position).getId(), TextToSpeech.QUEUE_FLUSH, hash);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(tts!=null) {
            tts.stop();
            tts.shutdown();
        }
    }

    private void checkTTS(){
        Intent check = new Intent();
        check.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(check, CHECK_CODE);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.CHINESE);
        }else{
            Log.e("TTS", "Initialization Failed!");
        }
    }
}
