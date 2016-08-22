package my.edu.tarc.fragment.ExamFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import my.edu.tarc.fragment.R;

/**
 * Created by Eric Yam on 8/21/2016.
 */
public class Q11 extends Fragment{

    RadioButton rpear, rapple, rmelon ,rpeach;
    static boolean[] ischeck = {false, false, false, false};
    private static int answered = 0;
    private static boolean correctanswer = false;

    public Q11(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq11, container, false);

        rpear = (RadioButton)rooteView.findViewById(R.id.radioButtonPear);
        rapple = (RadioButton)rooteView.findViewById(R.id.radioButtonApple);
        rmelon = (RadioButton)rooteView.findViewById(R.id.radioButtonMelon);
        rpeach = (RadioButton)rooteView.findViewById(R.id.radioButtonPeach);

        rpear.setChecked(ischeck[0]);
        rapple.setChecked(ischeck[1]);
        rmelon.setChecked(ischeck[2]);
        rpeach.setChecked(ischeck[3]);

        rpear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = true;
                ischeck[1] = false;
                ischeck[2] = false;
                ischeck[3] = false;
                answered = 1;
                correctanswer = true;
            }
        });

        rapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = false;
                ischeck[1] = true;
                ischeck[2] = false;
                ischeck[3] = false;
                answered = 1;
                correctanswer = false;
            }
        });

        rmelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = false;
                ischeck[1] = false;
                ischeck[2] = true;
                ischeck[3] = false;
                answered = 1;
                correctanswer = false;
            }
        });

        rpeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = false;
                ischeck[1] = false;
                ischeck[2] = false;
                ischeck[3] = true;
                answered = 1;
                correctanswer = false;
            }
        });

        return rooteView;
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
        ischeck[0] = false;
        ischeck[1] = false;
        ischeck[2] = false;
        ischeck[3] = false;
        answered = 0;
        correctanswer = false;
    }

}
