package co.njcreatives.www.assesment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import co.njcreatives.www.assesment.R;

/**
 * Created by Nithin Nj on 18-07-2018.
 */

public class SwipeAdapter extends PagerAdapter {


    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images={R.drawable.profilepic1,R.drawable.ic_chevron_left_black_24dp,R.drawable.ic_contact_phone_black_24dp};
    public SwipeAdapter(Context context)
    {
        this.context=context;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.birthday_profile,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.iv_check);
        imageView.setImageResource(images[position]);
        ViewPager viewPager=(ViewPager)container;
        viewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager)container;
        View view=(View)object;
        viewPager.removeView(view);
    }
}
