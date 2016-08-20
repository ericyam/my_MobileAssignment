package my.edu.tarc.fragment.Database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import my.edu.tarc.fragment.R;

/**
 * Created by Eric Yam on 8/20/2016.
 */
public class UserRecordAdapter extends ArrayAdapter<BihuaData> {
    public UserRecordAdapter(Activity context, int resource, List<BihuaData> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BihuaData bihuadata = getItem(position);

        if(convertView == null){
            convertView	=	LayoutInflater.from(getContext()).inflate(R.layout.tab_1, parent, false);
        }

        TextView textviewzhuci, textviewdetail;
        textviewzhuci = (TextView)convertView.findViewById(R.id.textViewZhuCi);
        textviewdetail = (TextView)convertView.findViewById(R.id.textViewDetail);

        textviewzhuci.setText(bihuadata.getZhuci());
        textviewdetail.setText(bihuadata.getDetail());

        return convertView;
    }
}
