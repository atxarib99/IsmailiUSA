package com.example.arib.ismailiusa;

import android.app.TabActivity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        setNewTab(this, tabHost, "tab1", R.string.tab1_name, R.drawable.tanks, R.id.tab1);
        setNewTab(this, tabHost, "tab2", R.string.tab2_name, R.drawable.tanks, R.id.tab2);
        setNewTab(this, tabHost, "tab3", R.string.tab3_name, R.drawable.tanks, R.id.tab3);
        setNewTab(this, tabHost, "tab4", R.string.tab4_name, R.drawable.tanks, R.id.tab4);
    }

    private void setNewTab(Context context, TabHost tabHost, String tag, int title, int icon, int contentID) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(getTabIndicator(tabHost.getContext(), title, icon));
        tabSpec.setContent(contentID);
        tabHost.addTab(tabSpec);
    }

    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        ImageView iv = view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
        TextView tv = view.findViewById(R.id.textView);
        tv.setText(title);
        return view;
    }
}
