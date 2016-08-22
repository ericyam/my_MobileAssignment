/*package my.edu.tarc.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
public class CustomAdapterRcyc extends RecyclerView.Adapter<CustomAdapterRcyc.ViewHolder> {
    private ArrayList<Person> mPersonList;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    int value=0;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView personNameTextView, personDsgTextView,textViewNo;
        RelativeLayout list_row;
        ImageView plantImageView,plantImageView2;
        public ViewHolder(View v) {
            super(v);
            personNameTextView = (TextView) v.findViewById(R.id.personNameTextView);
            personDsgTextView = (TextView) v.findViewById(R.id.personDsgTextView);
            list_row = (RelativeLayout) v.findViewById(R.id.list_row);
            plantImageView = (ImageView) v.findViewById(R.id.plantImageView);
           plantImageView2 = (ImageView) v.findViewById(R.id.plantImageView2);
            textViewNo = (TextView) v.findViewById(R.id.textViewNo);
        }
    }
    public void add(int position, Person item) {
        mPersonList.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(String item) {
        int position = mPersonList.indexOf(item);
        mPersonList.remove(position);
        notifyItemRemoved(position);
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public CustomAdapterRcyc(ArrayList<Person> personList, Context context) {
        mPersonList = personList;
        mPref = context.getSharedPreferences("person", Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }
    // Create new views (invoked by the layout manager)
    @Override
    public CustomAdapterRcyc.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.personNameTextView.setText(mPersonList.get(position).getPersonName());
        holder.personDsgTextView.setText(mPersonList.get(position).getPersonDsg());
        holder.textViewNo.setText(String.format("%02d",position+1));
        Log.e("selection", "" + mPersonList.get(position).isSelected());
        if (mPersonList.get(position).isSelected()) {
         //   holder.list_row.setBackgroundColor(Color.parseColor("#d5d5d5"));
            holder.plantImageView2.setVisibility(View.VISIBLE);

            value = position;
        } else {
           // holder.list_row.setBackgroundColor(Color.TRANSPARENT);
            holder.plantImageView2.setVisibility(View.GONE);

        }

    }

    public int getPosition(){
        return value;
    }

    public void setSelected(int pos) {
        try {
            if (mPersonList.size() > 1) {
                mPersonList.get(mPref.getInt("position", 0)).setSelected(false);
                mEditor.putInt("position", pos);
                mEditor.commit();
            }
            mPersonList.get(pos).setSelected(true);
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPersonList.size();
    }
}
*/