package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Eric Yam on 8/21/2016.
 */
public class CustomAdapter2 extends BaseAdapter{
    String [] result, result2;
    Context context;

    private static LayoutInflater inflater=null;

    public CustomAdapter2(ResultActivity resultActivity, String[] title, String[] resultexam) {
        // TODO Auto-generated constructor stub
        result=title;
        context=resultActivity;
        result2=resultexam;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv, tv2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView = inflater.inflate(R.layout.resultlistview, parent, false);

        // Get the Layout Parameters for ListView Current Item View
        LayoutParams params = rowView.getLayoutParams();

        // Set the height of the Item View
        params.height = 120;
        rowView.setLayoutParams(params);


        holder.tv=(TextView) rowView.findViewById(R.id.textViewTitle);
        holder.tv2=(TextView) rowView.findViewById(R.id.textViewResult);
        holder.tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        holder.tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);


        holder.tv.setText(result[position]);
        holder.tv2.setText(result2[position]);


        return rowView;
    }

}
