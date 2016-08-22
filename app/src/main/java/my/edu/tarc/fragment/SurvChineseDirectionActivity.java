/*package my.edu.tarc.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class SurvChineseDirectionActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private ArrayList<Person> mPersonList;
    private RecyclerView mRecyclerView;
    private CustomAdapterRcyc mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private  String [] English={"How do I get there?",
            "I'm lost.",
            "Straight",
            "Turn left",
            "Turn right",
            "The front 800m turn to the right.",
            "GAS station",
            "Slow",
            "What time do we return?",
            "Please take me to this place.",
            "Can I use my phone now?"};

    private  String [] Chinese={
            "我怎么到那儿？",
            "我迷路了。",
            "直走",
            "左转",
            "右转",
            "前方八百米向右拐。",
            "加油站",
            "慢行",
            "我们什么时候回？",
            "请带我到这个地方。",
            "现在可以使用手机了吗？"};

    private  String [] Pinyin={
            "Wǒ zěnme dào nà'er?",
            "Wǒ mí lù le.",
            "Zhí zǒu",
            "zuǒ zhuǎn",
            "yòu zhuǎn",
            "qiánfāng bābǎi mǐ xiàng yòu guǎi.",
            "Jiāyóu zhàn",
            "màn xíng",
            "wǒmen shénme shíhòu huí?",
            "Qǐng dài wǒ dào zhège dìfāng.",
            "Xiànzài kěyǐ shǐyòng shǒujīle ma?"};

    TextView textViewPinyin,textViewCn;
    ImageView imageMic;
    AnimationDrawable animatetionPc;

    TextToSpeech tts;
    final int CHECK_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surv_chinese_basic);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#333333")));

        checkTTS();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        textViewPinyin = (TextView)findViewById(R.id.textViewPinyin);
        textViewCn = (TextView)findViewById(R.id.textViewCn);

        imageMic = (ImageView)findViewById(R.id.imageMic);
        imageMic.setBackgroundResource(R.drawable.animate);
        //  imageMic.setOnClickListener(this);
        animatetionPc = (AnimationDrawable) imageMic.getBackground();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        int id = view.getId();
                        try {
                            mAdapter.setSelected(position);

                            textViewCn.setText(Chinese[position]);
                            textViewPinyin.setText(Pinyin[position]);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                //  tts.setPitch(1.1f); // saw from internet
                                tts.setSpeechRate(0.5f); // f denotes float, it actually type casts 0.5 to float
                                tts.speak(Chinese[position], TextToSpeech.QUEUE_FLUSH, null, null);
                                animatetionPc.run();

                            } else {
                                HashMap<String, String> hash = new HashMap<String, String>();
                                hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM, String.valueOf(AudioManager.STREAM_NOTIFICATION));
                                //  tts.setPitch(1.1f); // saw from internet
                                tts.setSpeechRate(0.5f); // f denotes float, it actually type casts 0.5 to float
                                tts.speak(Chinese[position], TextToSpeech.QUEUE_FLUSH, hash);

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
        );
        setupPersonList();
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




    private void setupPersonList() {
        mPersonList = new ArrayList<Person>();
        mPersonList.clear();

        for (int i = 0; i < 11; i++) {
            Person person = new Person(" " + English[i], Chinese[i]);
            mPersonList.add(person);
        }

        mAdapter = new CustomAdapterRcyc(mPersonList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    ////////////
    private void checkTTS() {
        Intent check = new Intent();
        check.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(check,CHECK_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CHECK_CODE){
            if(resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
                tts = new TextToSpeech(this,this);

            }
            else{
                Intent install = new Intent();
                install.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(install);
            }
        }
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.CHINESE);
        }
        else{
            Log.e("TTS","Initialization Failed!");
        }
    }
    // when apps exit, stop speaking

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(tts!=null){
            tts.stop();//interrupts the current utterance
            tts.shutdown();//releases the resources
        }
    }
    ////



}*/