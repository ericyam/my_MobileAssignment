package my.edu.tarc.fragment.ExamFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import my.edu.tarc.fragment.R;

/**
 * Created by Eric Yam on 8/21/2016.
 */
public class Q9 extends Fragment implements View.OnClickListener{

    RelativeLayout contain, contain1, contain2, contain3;
    TextView textview1, textview2, textview3, textview4;
    private static int answered = 0;
    private static boolean correctanswer = false;

    static int[] result = {0,0,0,0};

    public Q9(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq9, container, false);
        contain = (RelativeLayout)rooteView.findViewById(R.id.contain);
        contain1 = (RelativeLayout)rooteView.findViewById(R.id.contain1);
        contain2 = (RelativeLayout)rooteView.findViewById(R.id.contain2);
        contain3 = (RelativeLayout)rooteView.findViewById(R.id.contain3);
        textview1 = (TextView)rooteView.findViewById(R.id.textView1);
        textview2 = (TextView)rooteView.findViewById(R.id.textView2);
        textview3 = (TextView)rooteView.findViewById(R.id.textView3);
        textview4 = (TextView)rooteView.findViewById(R.id.textView4);


        if(result[0] == 1) {
            contain.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            textview1.setTextColor(getResources().getColor(R.color.colorWhite));
        }
        else if(result[1] == 1) {
            contain1.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            textview2.setTextColor(getResources().getColor(R.color.colorWhite));
        }
        else if(result[2] == 1) {
            contain2.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            textview3.setTextColor(getResources().getColor(R.color.colorWhite));
        }
        else if(result[3] == 1) {
            contain3.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            textview4.setTextColor(getResources().getColor(R.color.colorWhite));
        }

        contain.setOnClickListener(this);
        contain1.setOnClickListener(this);
        contain2.setOnClickListener(this);
        contain3.setOnClickListener(this);

        return rooteView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.contain : contain.setBackgroundColor(getResources().getColor(R.color.colorBlue));correctanswer = true;
                contain1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain3.setBackgroundColor(getResources().getColor(R.color.colorGray));
                textview1.setTextColor(getResources().getColor(R.color.colorWhite));
                textview2.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview3.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview4.setTextColor(getResources().getColor(R.color.colorGBlack));
                result[0] = 1;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                break;

            case R.id.contain1 : contain1.setBackgroundColor(getResources().getColor(R.color.colorBlue));textview2.setTextColor(getResources().getColor(R.color.colorWhite));correctanswer = false;
                contain.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain3.setBackgroundColor(getResources().getColor(R.color.colorGray));
                textview1.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview2.setTextColor(getResources().getColor(R.color.colorWhite));
                textview3.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview4.setTextColor(getResources().getColor(R.color.colorGBlack));
                result[0] = 0;
                result[1] = 1;
                result[2] = 0;
                result[3] = 0;
                break;

            case R.id.contain2 : contain2.setBackgroundColor(getResources().getColor(R.color.colorBlue));textview3.setTextColor(getResources().getColor(R.color.colorWhite));correctanswer = false;
                contain.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain3.setBackgroundColor(getResources().getColor(R.color.colorGray));
                textview1.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview2.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview3.setTextColor(getResources().getColor(R.color.colorWhite));
                textview4.setTextColor(getResources().getColor(R.color.colorGBlack));
                result[0] = 0;
                result[1] = 0;
                result[2] = 1;
                result[3] = 0;
                break;

            case R.id.contain3 : contain3.setBackgroundColor(getResources().getColor(R.color.colorBlue));textview4.setTextColor(getResources().getColor(R.color.colorWhite));correctanswer = false;
                contain.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                textview1.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview2.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview3.setTextColor(getResources().getColor(R.color.colorGBlack));
                textview4.setTextColor(getResources().getColor(R.color.colorWhite));
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 1;
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
        answered = 0;
        correctanswer = false;
    }
}
