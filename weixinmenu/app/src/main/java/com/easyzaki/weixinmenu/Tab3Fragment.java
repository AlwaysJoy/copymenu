package com.easyzaki.weixinmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by easyzaki on 2016/2/11.
 */
public class Tab3Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_frag);
        tv.setText("tab3");
        return view;
    }
}
