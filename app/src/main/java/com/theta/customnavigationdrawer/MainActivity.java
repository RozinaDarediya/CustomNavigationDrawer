package com.theta.customnavigationdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Header
    SimpleDraweeView sdUserProfile, sdUserCover;
    TextView hdrTvUserName;
    RelativeLayout hdr_layout_view_profile;
    //Custom Toolbar
    Toolbar toolbar;
    TextView tbTitle;
    RecyclerView rvLeftMenu;
    SimpleDraweeView sdNavBanner;

    //custom Navbar
    NavMenuAdapter navMenuAdapter;
    ArrayList<LeftMenuMain> leftMenuMainArrayList;
    LeftMenuMain leftMenuMain;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        sdNavBanner = (SimpleDraweeView)findViewById(R.id.sdNavBanner);
        //Custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tbTitle = (TextView) toolbar.findViewById(R.id.tbTitle);
        tbTitle.setText("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /****************************************Header View***************************************/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        hdr_layout_view_profile = (RelativeLayout) headerView.findViewById(R.id.hdr_layout_view_profile);
        sdUserCover = (SimpleDraweeView) headerView.findViewById(R.id.sdUserCover);
        hdrTvUserName = (TextView) headerView.findViewById(R.id.hdrTvUserName);
        sdUserProfile = (SimpleDraweeView) headerView.findViewById(R.id.sdUserProfile);

        //set Default Fragment Here
        fragment = new BlankFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.matrimonial_container, fragment)
                .commit();

        rvLeftMenu = (RecyclerView) findViewById(R.id.rvLeftMenu);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        rvLeftMenu.setLayoutManager(mLayoutManager1);

        leftMenuMainArrayList = new ArrayList<>();
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 1", R.drawable.ic_back, ""));
        leftMenuMainArrayList.add(new LeftMenuMain("Fragment 2", R.drawable.ic_filter, ""));

        navMenuAdapter = new NavMenuAdapter(leftMenuMainArrayList, getApplicationContext());
        rvLeftMenu.setAdapter(navMenuAdapter);
        rvLeftMenu.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                leftMenuMain = leftMenuMainArrayList.get(position);
                try {
                    if (leftMenuMain.getItemName().equals("Fragment 1")) {
                        changeFragment(new BlankFragment());
                        DrawerLayout drawer_home = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer_home.closeDrawer(GravityCompat.START);
                    }else if (leftMenuMain.getItemName().equals("Fragment 2")){
                        changeFragment(new BlankFragment2());
                        DrawerLayout drawer_home = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer_home.closeDrawer(GravityCompat.START);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    private void changeFragment(Fragment fragment) {
        try {
            String backStateName = fragment.getClass().getName();
            String fragmentTag = backStateName;

            FragmentManager manager = getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);


            if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) {
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.matrimonial_container, fragment, fragmentTag);
                fragmentTransaction.addToBackStack(backStateName);
                fragmentTransaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
