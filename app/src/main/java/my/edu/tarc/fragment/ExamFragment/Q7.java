package my.edu.tarc.fragment.ExamFragment;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Locale;

import my.edu.tarc.fragment.R;


public class Q7 extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener{

    ImageButton sound;
    TextToSpeech tts;
    final int CHECK_CODE = 1;
    ImageView imgresult, imgbtn, imgbtn1, imgbtn2, imgbtn3, imgbtn4, imgbtn5;
    private static int answered = 0;
    private static boolean correctanswer = false;
    static int[] result = {0,0,0,0,0,0};

    public Q7(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq7, container, false);
        checkTTS();
        imgresult = (ImageView)rooteView.findViewById(R.id.imageView2);
        imgbtn = (ImageView)rooteView.findViewById(R.id.imageButton4);  //che
        imgbtn1 = (ImageView)rooteView.findViewById(R.id.imageButton5); //chi
        imgbtn2 = (ImageView)rooteView.findViewById(R.id.imageButton3); //zhuo
        imgbtn3 = (ImageView)rooteView.findViewById(R.id.imageButton);  //fang
        imgbtn4 = (ImageView)rooteView.findViewById(R.id.imageButton2); //hua
        imgbtn5 = (ImageView)rooteView.findViewById(R.id.imageButton1); //jia
        sound = (ImageButton)rooteView.findViewById(R.id.imageButton6);


        if(result[0] == 1)
            imgresult.setImageResource(R.drawable.che);
        else if(result[1] == 1)
            imgresult.setImageResource(R.drawable.chi);
        else if(result[2] == 1)
            imgresult.setImageResource(R.drawable.zhuo);
        else if(result[3] == 1)
            imgresult.setImageResource(R.drawable.fang);
        else if(result[4] == 1)
            imgresult.setImageResource(R.drawable.hua);
        else if(result[5] == 1)
            imgresult.setImageResource(R.drawable.jia);

        imgbtn.setOnClickListener(this);
        imgbtn1.setOnClickListener(this);
        imgbtn2.setOnClickListener(this);
        imgbtn3.setOnClickListener(this);
        imgbtn4.setOnClickListener(this);
        imgbtn5.setOnClickListener(this);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.setPitch(1.1f);
                    tts.speak("桌", TextToSpeech.QUEUE_FLUSH, null, null);
                }else {
                    HashMap<String, String> hash = new HashMap<String,String>();
                    hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM, String.valueOf(AudioManager.STREAM_NOTIFICATION));
                    tts.speak("桌", TextToSpeech.QUEUE_FLUSH, hash);
                }
            }
        });


        return rooteView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageButton4 : imgresult.setImageResource(R.drawable.che);correctanswer = false;
                result[0] = 1;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton5 : imgresult.setImageResource(R.drawable.chi);correctanswer = false;
                result[0] = 0;
                result[1] = 1;
                result[2] = 0;
                result[3] = 0;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton3 : imgresult.setImageResource(R.drawable.zhuo);correctanswer = true;
                result[0] = 0;
                result[1] = 0;
                result[2] = 1;
                result[3] = 0;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton : imgresult.setImageResource(R.drawable.fang);correctanswer = false;
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 1;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton2 : imgresult.setImageResource(R.drawable.hua);correctanswer = false;
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                result[4] = 1;
                result[5] = 0;
                break;

            case R.id.imageButton1 : imgresult.setImageResource(R.drawable.jia);correctanswer = false;
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                result[4] = 0;
                result[5] = 1;
                break;
        }
        answered = 1;
    }

    public static char getAnswered(){
        if(answered == 1){
            if(correctanswer){
                return 'Y';
            }
            else{
                return 'N';
            }
        }else{
            return 'B';
        }
    }

    public static void clearAnswer(){
        result[0] = 0;
        result[1] = 0;
        result[2] = 0;
        result[3] = 0;
        result[4] = 0;
        result[5] = 0;
        answered = 0;
        correctanswer = false;
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
