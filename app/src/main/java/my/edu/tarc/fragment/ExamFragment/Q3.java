package my.edu.tarc.fragment.ExamFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import my.edu.tarc.fragment.ExamActivity;
import my.edu.tarc.fragment.R;

/**
 * Created by Eric Yam on 8/21/2016.
 */
public class Q3 extends Fragment{

    RadioButton rpear, rapple, rmelon ,rpeach;
    static boolean[] ischeck = {false, false, false, false};

    public Q3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq3, container, false);

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
            }
        });

        rapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = false;
                ischeck[1] = true;
                ischeck[2] = false;
                ischeck[3] = false;
            }
        });

        rmelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = false;
                ischeck[1] = false;
                ischeck[2] = true;
                ischeck[3] = false;
            }
        });

        rpeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischeck[0] = false;
                ischeck[1] = false;
                ischeck[2] = false;
                ischeck[3] = true;
            }
        });

        return rooteView;
    }

/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Toast.makeText(getActivity(), "fucker", Toast.LENGTH_LONG).show();

        super.onSaveInstanceState(outState);
        outState.putBoolean("Option1", rpear.isChecked());
        outState.putBoolean("Option2", rapple.isChecked());
        outState.putBoolean("Option3", rmelon.isChecked());
        outState.putBoolean("Option4", rpeach.isChecked());
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "here", Toast.LENGTH_LONG).show();
        super.onViewStateRestored(savedInstanceState);

    }*/

}
