package co.njcreatives.www.assesment.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import co.njcreatives.www.assesment.Adapters.MyRecyclerViewAdapter;
import co.njcreatives.www.assesment.Adapters.TimeLineAdapter;
import co.njcreatives.www.assesment.BottomNavigationActivity;
import co.njcreatives.www.assesment.BottomNavigationViewHelper;
import co.njcreatives.www.assesment.R;

public class TimeLineActivity extends AppCompatActivity {

  Toolbar mToolBar;
    String TAG="bottomNavigation";
    private  static  final int ACTIVITY_NUMBER=2;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_time_line);
        setToolBar();
        setBottomNavigationView();
        setDrawer();



        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_timeline);
        TimeLineAdapter adapter=new TimeLineAdapter(this,R.layout.timeline_recycler_layout);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Toast.makeText(TimeLineActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();



                return true;
            }
        });




        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(TimeLineActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setDrawer() {
        navigationView=(NavigationView)findViewById(R.id.nv_timeline);
        drawerLayout=(DrawerLayout)findViewById(R.id.dl_timeline);

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,mToolBar,R.string.drawerOpen,R.string.drawerClosed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

    }


    private void setToolBar() {


        mToolBar=(Toolbar)findViewById(R.id.tb_timeline);
        mToolBar.setTitle("Timeline");
        mToolBar.inflateMenu(R.menu.menu);




    }
    private void setBottomNavigationView() {


        Log.i(TAG,"inside setBottomNavigation BottomNavigation Activity");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(navigation);
        BottomNavigationViewHelper.enableNavigation(TimeLineActivity.this,navigation);
        Menu menu=navigation.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);





    }
}
