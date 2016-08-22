package my.edu.tarc.fragment.ExamFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import my.edu.tarc.fragment.R;

/**
 * Created by Eric Yam on 8/21/2016.
 */
public class Q14 extends Fragment implements View.OnClickListener{

    ImageView imgresult, imgbtn, imgbtn1, imgbtn2, imgbtn3, imgbtn4, imgbtn5;
    private static int answered = 0;
    private static boolean correctanswer = false;
    static int[] result = {0,0,0,0,0,0};


    public Q14(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq14, container, false);
        imgresult = (ImageView)rooteView.findViewById(R.id.imageView2);
        imgbtn = (ImageView)rooteView.findViewById(R.id.imageButton4);  //nv
        imgbtn1 = (ImageView)rooteView.findViewById(R.id.imageButton5); //an
        imgbtn2 = (ImageView)rooteView.findViewById(R.id.imageButton3); //tian
        imgbtn3 = (ImageView)rooteView.findViewById(R.id.imageButton);  //nan
        imgbtn4 = (ImageView)rooteView.findViewById(R.id.imageButton2); //bai
        imgbtn5 = (ImageView)rooteView.findViewById(R.id.imageButton1); //cao

        if(result[0] == 1)
            imgresult.setImageResource(R.drawable.re);
        else if(result[1] == 1)
            imgresult.setImageResource(R.drawable.shan);
        else if(result[2] == 1)
            imgresult.setImageResource(R.drawable.yue);
        else if(result[3] == 1)
            imgresult.setImageResource(R.drawable.tu);
        else if(result[4] == 1)
            imgresult.setImageResource(R.drawable.xiao);
        else if(result[5] == 1)
            imgresult.setImageResource(R.drawable.xing);

        imgbtn.setOnClickListener(this);
        imgbtn1.setOnClickListener(this);
        imgbtn2.setOnClickListener(this);
        imgbtn3.setOnClickListener(this);
        imgbtn4.setOnClickListener(this);
        imgbtn5.setOnClickListener(this);

        return rooteView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageButton4 : imgresult.setImageResource(R.drawable.re);correctanswer = false;
                result[0] = 1;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton5 : imgresult.setImageResource(R.drawable.shan);correctanswer = true;
                result[0] = 0;
                result[1] = 1;
                result[2] = 0;
                result[3] = 0;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton3 : imgresult.setImageResource(R.drawable.yue);correctanswer = false;
                result[0] = 0;
                result[1] = 0;
                result[2] = 1;
                result[3] = 0;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton : imgresult.setImageResource(R.drawable.tu);correctanswer = false;
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 1;
                result[4] = 0;
                result[5] = 0;
                break;

            case R.id.imageButton2 : imgresult.setImageResource(R.drawable.xiao);correctanswer = false;
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                result[4] = 1;
                result[5] = 0;
                break;

            case R.id.imageButton1 : imgresult.setImageResource(R.drawable.xing);correctanswer = false;
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
}
