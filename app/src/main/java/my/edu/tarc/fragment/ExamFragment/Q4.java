package my.edu.tarc.fragment.ExamFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import my.edu.tarc.fragment.R;

/**
 * Created by Eric Yam on 8/21/2016.
 */
public class Q4 extends Fragment implements View.OnClickListener{
    RelativeLayout contain, contain1, contain2, contain3;
    static int[] result = {0,0,0,0};

    public Q4(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooteView = inflater.inflate(R.layout.examq4, container, false);
        contain = (RelativeLayout)rooteView.findViewById(R.id.contain);
        contain1 = (RelativeLayout)rooteView.findViewById(R.id.contain1);
        contain2 = (RelativeLayout)rooteView.findViewById(R.id.contain2);
        contain3 = (RelativeLayout)rooteView.findViewById(R.id.contain3);


        if(result[0] == 1)
            contain.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else if(result[1] == 1)
            contain1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else if(result[2] == 1)
            contain2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else if(result[3] == 1)
            contain3.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        contain.setOnClickListener(this);
        contain1.setOnClickListener(this);
        contain2.setOnClickListener(this);
        contain3.setOnClickListener(this);



        return rooteView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.contain : contain.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                contain1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain3.setBackgroundColor(getResources().getColor(R.color.colorGray));
                result[0] = 1;
                result[1] = 0;
                result[2] = 0;
                result[3] = 0;
                break;

            case R.id.contain1 : contain1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                contain.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain3.setBackgroundColor(getResources().getColor(R.color.colorGray));
                result[0] = 0;
                result[1] = 1;
                result[2] = 0;
                result[3] = 0;
                break;

            case R.id.contain2 : contain2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                contain.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain3.setBackgroundColor(getResources().getColor(R.color.colorGray));
                result[0] = 0;
                result[1] = 0;
                result[2] = 1;
                result[3] = 0;
                break;

            case R.id.contain3 : contain3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                contain.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                contain2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
                result[3] = 1;
                break;
        }
    }
}
