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
public class Q5 extends Fragment implements View.OnClickListener{
    RadioButton radiobuttonswim;
    RadioButton radiobuttonjog;
    RadioButton radiobuttonjump;
    RadioButton radiobuttonbadminton;
    static boolean[] ischeck = {false, false, false, false};
    private static int answered = 0;
    private static boolean correctanswer = false;

    public Q5(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq5, container, false);
        radiobuttonswim = (RadioButton)rooteView.findViewById(R.id.radioButtonSwim);
        radiobuttonjog = (RadioButton)rooteView.findViewById(R.id.radioButtonJog);
        radiobuttonjump = (RadioButton)rooteView.findViewById(R.id.radioButtonJump);
        radiobuttonbadminton = (RadioButton)rooteView.findViewById(R.id.radioButtonBadminton);

        radiobuttonswim.setChecked(ischeck[0]);
        radiobuttonjog.setChecked(ischeck[1]);
        radiobuttonjump.setChecked(ischeck[2]);
        radiobuttonbadminton.setChecked(ischeck[3]);

        radiobuttonswim.setOnClickListener(this);
        radiobuttonjog.setOnClickListener(this);
        radiobuttonjump.setOnClickListener(this);
        radiobuttonbadminton.setOnClickListener(this);

        return rooteView;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.radioButtonSwim){
            radiobuttonjog.setChecked(false);
            radiobuttonjump.setChecked(false);
            radiobuttonbadminton.setChecked(false);
            ischeck[0] = true;
            ischeck[1] = false;
            ischeck[2] = false;
            ischeck[3] = false;
            correctanswer = true;
        }
        else if(view.getId() == R.id.radioButtonJog) {
            radiobuttonswim.setChecked(false);
            radiobuttonjump.setChecked(false);
            radiobuttonbadminton.setChecked(false);
            ischeck[0] = false;
            ischeck[1] = true;
            ischeck[2] = false;
            ischeck[3] = false;
            correctanswer = false;
        }else if(view.getId() == R.id.radioButtonJump){
            radiobuttonswim.setChecked(false);
            radiobuttonjog.setChecked(false);
            radiobuttonbadminton.setChecked(false);
            ischeck[0] = false;
            ischeck[1] = false;
            ischeck[2] = true;
            ischeck[3] = false;
            correctanswer = false;
        }else if(view.getId() == R.id.radioButtonBadminton){
            radiobuttonswim.setChecked(false);
            radiobuttonjog.setChecked(false);
            radiobuttonjump.setChecked(false);
            ischeck[0] = false;
            ischeck[1] = false;
            ischeck[2] = false;
            ischeck[3] = true;
            correctanswer = false;
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
        ischeck[0] = false;
        ischeck[1] = false;
        ischeck[2] = false;
        ischeck[3] = false;
        answered = 0;
        correctanswer = false;
    }
}
