package my.edu.tarc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Eric Yam on 7/31/2016.
 */
public class Tab1 extends Fragment {

    GifView gifView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.tab_1, container, false);

        gifView = (GifView) rootView.findViewById(R.id.gifview);

        return rootView;
    }
}
