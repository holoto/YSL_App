package com.ai.ysl;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ai.ysl.Boxscheme.YslList;
import com.ai.ysl.listclicklistener.OnListFragmentInteractionListener;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class MyyslRecyclerViewAdapter extends RecyclerView.Adapter<MyyslRecyclerViewAdapter.ViewHolder> {
	
	private final List<YslList> mValues;
	private final OnListFragmentInteractionListener mListener;
	
	public MyyslRecyclerViewAdapter(List<YslList> items, OnListFragmentInteractionListener listener) {
		mValues = items;
		mListener = listener;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.fragment_ysl, parent, false);
		return new ViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		holder.mItem = mValues.get(position);
		holder.mIdView.setText(mValues.get(position).getName());
		if (mValues.get(position).getPicboolean()){
			Glide.with(BaseApp.getBaseApplicationinstance().getContext()).load(mValues.get(position).getPic()).into(holder.imageView);
		}
	
		holder.mView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (null != mListener) {
					Log.e("onClick", "onClick: " );
					EventBus.getDefault().post(holder.mItem);
					mListener.onListFragmentInteraction(holder.mItem);
				}
			}
		});
	}
	
	@Override
	public int getItemCount() {
		return mValues.size();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder {
		public final View mView;
		public final TextView mIdView;
		public final ImageView imageView;
		public YslList mItem;
		
		public ViewHolder(View view) {
			super(view);
			mView = view;
			mIdView = (TextView) view.findViewById(R.id.item_number);
			imageView=(ImageView) view.findViewById(R.id.card_img);
		}
		
		@Override
		public String toString() {
			return super.toString();
		}
	}
}
