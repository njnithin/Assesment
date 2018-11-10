package co.njcreatives.www.assesment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import co.njcreatives.www.assesment.Activities.ApprovalActivity;
import co.njcreatives.www.assesment.Activities.DashboardActivity;
import co.njcreatives.www.assesment.Activities.TimeLineActivity;
import co.njcreatives.www.assesment.Fragments.FragmentCustom;
import co.njcreatives.www.assesment.Fragments.FragmentMonthly;
import co.njcreatives.www.assesment.Fragments.FragmentWeekly;

public class BottomNavigationActivity extends AppCompatActivity {
    Toolbar mToolBar;
    String TAG="bottomNavigation";



/*    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;


            switch (item.getItemId()) {
                case R.id.navigation_home:
                   *//* fragment=new FragmentMonthly();
                    mToolBar.setTitle("Home");*//*
                    startActivity(new Intent(getApplicationContext(), TimeLineActivity.class));

                    break;


                case R.id.navigation_dashboard:
                    startActivity(new Intent(getApplicationContext(), DashboardActivity.class));


                    break;
                case R.id.navigation_notifications:
                    fragment=new FragmentWeekly();
                    mToolBar.setTitle("Notifications");

                    break;
            }
            return loadFragment(fragment);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_bottom_navigation);




    /*    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/
        setToolBar();
        //loadFragment(new FragmentMonthly());
        mToolBar.setTitle("Home");

        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Toast.makeText(BottomNavigationActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


          setBottomNavigationView();



    }

    private void setBottomNavigationView() {



        Log.i(TAG,"inside setBottomNavigation BottomNavigation Activity");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(navigation);
        BottomNavigationViewHelper.enableNavigation(BottomNavigationActivity.this,navigation);







    }

    private void setToolBar() {

        mToolBar=(Toolbar)findViewById(R.id.bottom_nav_toolbar);
        mToolBar.inflateMenu(R.menu.menu);


    }
    private boolean loadFragment(Fragment fragment){
/*
        if(fragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return  true;
        }

        return false;*/
       return  false;


    }

}
