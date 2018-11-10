package co.njcreatives.www.assesment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.animation.Animation;

import co.njcreatives.www.assesment.Activities.ApprovalActivity;
import co.njcreatives.www.assesment.Activities.DashboardActivity;
import co.njcreatives.www.assesment.Activities.TimeLineActivity;

/**
 * Created by Nithin Nj on 20-07-2018.
 */

public class BottomNavigationViewHelper {


    public static void setupBottomNavigationView(BottomNavigationView bottomNavigationView)
    {

    }


    public static void enableNavigation(final Context context,BottomNavigationView view) {

        view.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        if(ApprovalActivity.class != context.getClass())
                        {
                            context.startActivity(new Intent( context,ApprovalActivity.class));
                        }




                        break;


                    case R.id.navigation_dashboard:
                        if(DashboardActivity.class != context.getClass())
                        {
                            context.startActivity(new Intent( context,DashboardActivity.class));
                        }


                        break;
                    case R.id.navigation_notifications:
                        if(TimeLineActivity.class != context.getClass())
                        {
                            context.startActivity(new Intent( context,TimeLineActivity.class));
                        }

                        break;
                }






            }
        });

    }
}
