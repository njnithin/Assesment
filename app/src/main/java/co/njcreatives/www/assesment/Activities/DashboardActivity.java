package co.njcreatives.www.assesment.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.Toast;

import co.njcreatives.www.assesment.BottomNavigationViewHelper;
import co.njcreatives.www.assesment.Fragments.FragmentCustom;
import co.njcreatives.www.assesment.Fragments.FragmentMonthly;
import co.njcreatives.www.assesment.Fragments.FragmentWeekly;
import co.njcreatives.www.assesment.R;
import co.njcreatives.www.assesment.Adapters.ViewPagerAdapter;

public class DashboardActivity extends AppCompatActivity {

    String TAG="bottomNavigation";
    private  static  final int ACTIVITY_NUMBER=1;

    TabLayout tabLayout;
    ViewPager viewPager;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar mToolBar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);


        setToolBar();
        setDrawer();
        setTabLayout();
        setBottomNavigationView();

        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {



                Toast.makeText(DashboardActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Toast.makeText(DashboardActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();



                return true;
            }
        });

        Menu menu=mToolBar.getMenu();
        MenuItem item=menu.findItem(R.id.menuSearch);
        searchView=(SearchView)item.getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                 Toast.makeText(DashboardActivity.this, "Search: "+query, Toast.LENGTH_SHORT).show();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
       /* searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {   //setting the complete data


                return true;
            }
        });
     */


    }

    private void setTabLayout() {

        tabLayout=(TabLayout)findViewById(R.id.tl_time);
        viewPager=(ViewPager)findViewById(R.id.vp_time);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentWeekly(),"Weekly");
        viewPagerAdapter.addFragment(new FragmentMonthly(),"Monthly");
        viewPagerAdapter.addFragment(new FragmentCustom(),"Custom");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void setDrawer() {
     navigationView=(NavigationView)findViewById(R.id.nv_dashboard);
        drawerLayout=(DrawerLayout)findViewById(R.id.dl_dashboard);

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,mToolBar,R.string.drawerOpen,R.string.drawerClosed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

    }

    private void setToolBar() {

        mToolBar=(Toolbar)findViewById(R.id.toolbar);
        mToolBar.setTitle("Dashboard");

        mToolBar.inflateMenu(R.menu.menu_search);







    }

    private void setBottomNavigationView() {


        Log.i(TAG,"inside setBottomNavigation BottomNavigation Activity");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(navigation);
        BottomNavigationViewHelper.enableNavigation(DashboardActivity.this,navigation);
        Menu menu=navigation.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);





    }


}
