package co.njcreatives.www.assesment.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.njcreatives.www.assesment.R;

/**
 * Created by Nithin Nj on 17-07-2018.
 */

public class FragmentBirthday extends Fragment {

    View view;
    public FragmentBirthday(){



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.activity_recycler,container,false);
       return view;
    }
}
