package com.theta.customnavigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ashish on 22/11/17.
 */

public class RootFragment extends Fragment implements OnBackPressListener {

    private Toolbar toolbar;

    public TextView tbTitle;
    private ImageView tbIvBack;
    private ImageView tbIvMap;
    private ImageView tbIvMatrimonyFilter;

    public boolean isBackClick = true;

    public OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null) {
            //For Set Font
            //tfRegular = Global.setRegularFont(getActivity());
            //tfBold = Global.setBoldFont(getActivity());


            toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
            tbTitle = (TextView) toolbar.findViewById(R.id.tbTitle);
            //   tbTitle.setTypeface(tfBold);
            tbIvBack = (ImageView) toolbar.findViewById(R.id.tbIvBack);
            tbIvMap = (ImageView) toolbar.findViewById(R.id.tbIvMap);
            tbIvMatrimonyFilter = (ImageView) toolbar.findViewById(R.id.tbIvMatrimonyFilter);
        }
    }

    public void replaceFragment(int containerId, Fragment fragment, String title) {

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.addToBackStack(title);
        transaction.replace(containerId, fragment, title).commit();
    }

    public void setTitle(String title) {

        if (tbTitle != null)
            tbTitle.setText(title);
    }

    public void displayBack() {
        tbIvBack.setVisibility(View.VISIBLE);
        if (isBackClick) {
            tbIvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        if (mListener != null)
                            mListener.onBackClicked();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public ImageView displayMap() {
        tbIvMap.setVisibility(View.VISIBLE);
        return tbIvMap;
    }

    public void hideMap() {
        tbIvMap.setVisibility(View.GONE);


    } public ImageView displayMatrimonyFilter() {
        tbIvMatrimonyFilter.setVisibility(View.VISIBLE);
        return tbIvMatrimonyFilter;
    }

    public void hideMatrimonyFilter() {
        tbIvMatrimonyFilter.setVisibility(View.GONE);

    }

    public void hideBack() {
        tbIvBack.setVisibility(View.GONE);
    }

    /*public void clearBackStack() {

        Intent intent = new Intent(getActivity(), ServiceListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Global.activityBackTransition(getActivity());


    }*/

    public void oneBackStack() {

        for (int i = 0; i < 1; i++) {
            tbIvBack.performClick();
        }
    }


    public void clearBackStack() {

        for (int i = 0; i < 2; i++) {
            tbIvBack.performClick();
        }
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    public interface OnFragmentInteractionListener {
        void onBackClicked();
    }
}
