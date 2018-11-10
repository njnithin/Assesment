package co.njcreatives.www.assesment.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
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
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import co.njcreatives.www.assesment.Adapters.MyRecyclerViewAdapter;
import co.njcreatives.www.assesment.BottomNavigationViewHelper;
import co.njcreatives.www.assesment.R;

public class ApprovalActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar mToolBar;
    ViewPager viewPager;
    String TAG="bottomNavigation";
    private  static  final int ACTIVITY_NUMBER=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_approval);
/*
        viewPager=(ViewPager)findViewById(R.id.approval_viewPager);
        SwipeAdapter swipeAdapter=new SwipeAdapter(this);
        viewPager.setAdapter(swipeAdapter);*/
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_dashboard_birthday);
        MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(this,R.layout.birthday_recycler_layout);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setToolBar();
        setDrawer();
        setBottomNavigationView();

        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {



                Toast.makeText(ApprovalActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               Toast.makeText(ApprovalActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();



               return true;
           }
       });





    }



    private void setDrawer() {
        navigationView=(NavigationView)findViewById(R.id.nv_approval);
        drawerLayout=(DrawerLayout)findViewById(R.id.dl_approval);

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,mToolBar,R.string.drawerOpen,R.string.drawerClosed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setToolBar() {

        mToolBar=(Toolbar)findViewById(R.id.approval_toolbar);
        mToolBar.setTitle("Approval");
        mToolBar.inflateMenu(R.menu.menu);




    }

    public void viewAllBirthDays(View view) {


        startActivity(new Intent(this, ViewAllBirthdayActivity.class));




    }


    private void setBottomNavigationView() {


        Log.i(TAG,"inside setBottomNavigation Approval Activity");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(navigation);
        BottomNavigationViewHelper.enableNavigation(ApprovalActivity.this,navigation);
        Menu menu=navigation.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);





    }
}
