package com.theta.customnavigationdrawer;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ashish on 22/11/17.
 */

public class NavMenuAdapter extends RecyclerView.Adapter<NavMenuAdapter.ViewHolder> {
    ArrayList<LeftMenuMain> leftMenuMainArrayList;
    Context context;
    LeftMenuMain leftMenuMain;

    Typeface tfRegular, tfBold;

    public NavMenuAdapter(ArrayList<LeftMenuMain> leftMenuMainArrayList, Context context) {
        this.leftMenuMainArrayList = leftMenuMainArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.left_menu_list_row, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        leftMenuMain = leftMenuMainArrayList.get(position);

        holder.ivPMenuImg.setImageResource(leftMenuMain.getImgResID());
        holder.tvPMenuTxt.setTypeface(tfRegular);
        holder.tvPMenuTxt.setText(leftMenuMain.getItemName());
        //Change recycler view position to left
        /*RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
        int left = (int) context.getResources().getDimension(R.dimen.dim_nav_suub_menu_left);
        params.setMargins(left, 0, 0, 0);

        if ((position == 2) || (position == 3) || (position == 5) || (position == 6)) {
            holder.menuRL.setLayoutParams(params);
        }*/


    }

    @Override
    public int getItemCount() {
        return leftMenuMainArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public RelativeLayout menuRL;
        public ImageView ivPMenuImg;
        public TextView tvPMenuTxt;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            menuRL = (RelativeLayout) view.findViewById(R.id.menuRL);
            ivPMenuImg = (ImageView) view.findViewById(R.id.ivPMenuImg);
            tvPMenuTxt = (TextView) view.findViewById(R.id.tvPMenuTxt);

        }
    }
}
