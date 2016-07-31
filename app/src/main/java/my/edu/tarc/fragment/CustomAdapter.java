package my.edu.tarc.fragment;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
public class CustomAdapter extends BaseAdapter{
    String [] result, result2;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(HomeActivity homeActivity, String[] prgmNameList, int[] prgmImages, String[] subList) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=homeActivity;
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
        rowView = inflater.inflate(R.layout.navigation, null);

        //set Text and Listener is here <---------------------
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView2);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.tv2.setText(result2[position]);
        /*rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });*/
        return rowView;
    }

}