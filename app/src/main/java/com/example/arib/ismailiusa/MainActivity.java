package com.example.arib.ismailiusa;

import android.app.TabActivity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import layout.AnnouncementsFragment;
import layout.HeadlinesFragment;
import layout.JubileeFragment;
import layout.MoreFragment;

public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnFragmentInteractionListener,
        JubileeFragment.OnFragmentInteractionListener,
        AnnouncementsFragment.OnFragmentInteractionListener,
        MoreFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the tabhost from view
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        //setup the tabhost with fragments
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        //Create 4 tabs
        tabHost.addTab(tabHost.newTabSpec("Headlines")
                .setIndicator(getTabIndicator(tabHost.getContext(),
                        R.string.tab1_name,
                        R.drawable.tanks)), HeadlinesFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("Jubilee")
                .setIndicator(getTabIndicator(tabHost.getContext(),
                        R.string.tab2_name,
                        R.drawable.tanks)), JubileeFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("Announcements")
                .setIndicator(getTabIndicator(tabHost.getContext(),
                        R.string.tab3_name,
                        R.drawable.tanks)), AnnouncementsFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("More")
                .setIndicator(getTabIndicator(tabHost.getContext(),
                        R.string.tab4_name,
                        R.drawable.tanks)), MoreFragment.class, null);
    }

    //Sets up the each tabs buttons view
    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        ImageView iv = view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
        TextView tv = view.findViewById(R.id.textView);
        tv.setText(title);
        return view;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        //leaving blank because nothing needs to be done just yet
    }
}
