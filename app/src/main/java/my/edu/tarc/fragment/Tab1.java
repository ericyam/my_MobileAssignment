package my.edu.tarc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import my.edu.tarc.fragment.Database.BihuaData;
import my.edu.tarc.fragment.Database.UserDataSource;

/**
 * Created by Eric Yam on 7/31/2016.
 */
public class Tab1 extends Fragment {
    ImageButton next;
    ImageButton previous;
    GifView gifView;
    TextView textviewzhuci;
    TextView textviewdetail;
    TextView textviewpaging;
    TextView textviewpinbi;
    UserDataSource userDataSource;

    int position=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.tab_1, container, false);

        gifView = (GifView) rootView.findViewById(R.id.gifview);
        next = (ImageButton)rootView.findViewById(R.id.next);
        previous = (ImageButton)rootView.findViewById(R.id.previous);
        textviewzhuci = (TextView)rootView.findViewById(R.id.textViewZhuCi);
        textviewdetail = (TextView)rootView.findViewById(R.id.textViewDetail);
        textviewpaging = (TextView)rootView.findViewById(R.id.textViewPaging);
        textviewpinbi = (TextView)rootView.findViewById(R.id.textViewPinBi);

        userDataSource = new UserDataSource(getContext());
        userDataSource.open();

        final List<BihuaData> values = userDataSource.getAllUsers();
        textviewzhuci.setText(values.get(position).getZhuci());
        textviewdetail.setText(values.get(position).getDetail());
        textviewpaging.setText( (position+1) +  "/20");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position < values.size() - 1)
                    position++;
                textviewpaging.setText( (position+1) +  "/20");
                textviewzhuci.setText(values.get(position).getZhuci());
                textviewdetail.setText(values.get(position).getDetail());
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position > 0)
                    position--;
                textviewpaging.setText( (position+1) +  "/20");
                textviewzhuci.setText(values.get(position).getZhuci());
                textviewdetail.setText(values.get(position).getDetail());
            }
        });



        return rootView;
    }
}
