package co.njcreatives.www.assesment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.njcreatives.www.assesment.R;

/**
 * Created by Nithin Nj on 19-07-2018.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder> {


    Context context;
    LayoutInflater inflater;
    int layoutToInflate;




    ArrayList<Integer> images = new ArrayList<Integer>() {{
        add(R.drawable.profilepic1);
        add(R.drawable.profilepic2);
        add(R.drawable.profilepic3);
        add(R.drawable.profilepic4);
        add(R.drawable.profilepic5);
        add(R.drawable.profilepic6);
        add(R.drawable.profilepic7);
        add(R.drawable.profilepic8);
        add(R.drawable.profilepic9);
        add(R.drawable.profilepic10);
        add(R.drawable.profilepic11);
        add(R.drawable.profilepic12);

    }};
    ArrayList<String> times = new ArrayList<String>() {{
        add("01:30 PM");
        add("02:40 PM");
        add("02:50 PM");
        add("04:20 PM");
        add("05:30 PM");
        add("06:50 PM");
        add("07:20 PM");
        add("08:30 PM");
        add("09:45 PM");
        add("10:20 PM");
        add("11:10 PM");
        add("12:30 PM");


    }};

    ArrayList<String> notifications = new ArrayList<String>() {{
        add("Nithin ran 1.5 hrs");
        add("Nimisha added a member");
        add("Jibin obtained a trophy");
        add("Abhijith ran 1.5 hrs");
        add("Bibin obtained a medal");
        add("Roshan got a prize ");
        add("Nithya completed task");
        add("Veena visited gym");
        add("John ran 500M");
        add("Domanic done cycling");
        add("Mathu ran 2Km");
        add("Maria got 100 coins");



    }};

    ArrayList<String> percentages = new ArrayList<String>() {{
        add("20% Completed");
        add("30% Completed");
        add("40% Completed");
        add("10% Completed");
        add("20% Completed");
        add("10% Completed");
        add("20% Completed");
        add("20% Completed");
        add("20% Completed");
        add("60% Completed");
        add("10% Completed");
        add("40% Completed");



    }};









    public TimeLineAdapter(Context context, int layoutToInflate) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.layoutToInflate = layoutToInflate;

    }

    @NonNull
    @Override
    public TimeLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=inflater.inflate(layoutToInflate,parent,false);
        TimeLineViewHolder holder=new TimeLineViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeLineViewHolder holder, int position) {
        holder.setData((ArrayList<Integer>) images,position);
    }


    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public void onBindViewHolder(@NonNull TimeLineViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {

        ImageView profilePic;
        TextView time,notification,percentage;

        public TimeLineViewHolder(View itemView) {
            super(itemView);

            profilePic=(ImageView)itemView.findViewById(R.id.iv_profilepic);
            time=(TextView)itemView.findViewById(R.id.tv_time);
            notification=(TextView)itemView.findViewById(R.id.tv_notification);
            percentage=(TextView)itemView.findViewById(R.id.tv_completion);







        }

        public void setData(ArrayList<Integer> images, int position) {

            profilePic.setImageResource(images.get(position));
            time.setText(times.get(position));
            notification.setText(notifications.get(position));
            percentage.setText(percentages.get(position));



        }
    }

}
