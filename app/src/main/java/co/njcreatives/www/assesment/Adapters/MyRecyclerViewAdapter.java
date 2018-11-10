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
import java.util.List;

import co.njcreatives.www.assesment.R;

/**
 * Created by Nithin Nj on 19-07-2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {



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

    ArrayList<String> dates = new ArrayList<String>() {{
        add("19 Jan");
        add("29 Apr");
        add("14 Aug");
        add("10 Sep");
        add("06 Jul");
        add("08 Aug");
        add("22 May");
        add("11 Dec");
        add("25 Oct");
        add("23 Aug");
        add("01 Feb");
        add("12 Feb");



    }};
    ArrayList<String> names = new ArrayList<String>() {{
        add("Nithin Nj");
        add("Nimisha N");
        add("Jibin Nj");
        add("Abhijith MD");
        add("Bibin NJ");
        add("Roshan V");
        add("Nithya M");
        add("Veena S");
        add("John Babu");
        add("Domanic R");
        add("Mathu K");
        add("Maria Jose");


    }};


    public MyRecyclerViewAdapter(Context context, int layoutToInflate) {
        this.context=context;
        this.layoutToInflate=layoutToInflate;
        inflater=LayoutInflater.from(context);





    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=inflater.inflate(layoutToInflate,parent,false);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        holder.setData(images,position);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{




        ImageView birthdayPic;
        TextView name,date;

        public MyViewHolder(View itemView) {
            super(itemView);

            birthdayPic=(ImageView)itemView.findViewById(R.id.iv_birthdayImage);
            name=(TextView) itemView.findViewById(R.id.tv_birthdayName);
            date=(TextView) itemView.findViewById(R.id.tv_birthdayDate);



        }

        public void setData(ArrayList<Integer> images, int position) {


                      birthdayPic.setImageResource(images.get(position));
                      name.setText(names.get(position));
                      date.setText(dates.get(position));
                      //git


        }
    }

}
