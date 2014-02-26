package com.gammagamma.swipelist01.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gammagamma.swipelist01.app.R;

import java.util.ArrayList;


public class FirstListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String[]> mItems;
    private LayoutInflater mLayoutInflater;

    public FirstListAdapter( final Context context, ArrayList<String[]> items ) {

        super();
        mContext = context;
        mItems = items;

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(
            mContext.LAYOUT_INFLATER_SERVICE
        );

    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem( final int position ) {
        return position;
    }

    public long getItemId( final int position ) {
        return position;
    }

    public View getView( final int position, View view, final ViewGroup parent ) {

        if ( view == null ) {
            view = mLayoutInflater.inflate( R.layout.list_item_1, null );
        }

        TextView textPrimary = (TextView) view.findViewById( R.id.textPrimary );
        TextView textSecondary = (TextView) view.findViewById( R.id.textSecondary );

        textPrimary.setText( mItems.get(position)[0] );
        textSecondary.setText( mItems.get(position)[1] );

        return view;

    }

}
