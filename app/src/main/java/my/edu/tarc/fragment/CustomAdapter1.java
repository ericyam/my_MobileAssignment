package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter1 extends BaseAdapter{
    String [] result, result2;
    Context context;
    int [] imageId;
    Intent intent;

    private static LayoutInflater inflater=null;

    public CustomAdapter1(AboutActivity aboutActivity, String[] prgmNameList, int[] prgmImages, String[] subList) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=aboutActivity;
        imageId=prgmImages;
        result2=subList;
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
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.navigation1, null);
        //set Text and Listener is here <---------------------
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView2);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.tv2.setText(result2[position]);


        return rowView;
    }


}