package co.njcreatives.www.assesment.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import co.njcreatives.www.assesment.Adapters.MyRecyclerViewAdapter;
import co.njcreatives.www.assesment.R;

public class ViewAllBirthdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recycler);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_birthDay);
        MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(this, R.layout.allbirthday_recycler_layout);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



























    }
}
