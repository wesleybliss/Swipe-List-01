package com.gammagamma.swipelist01.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gammagamma.swipelist01.app.R;

import java.util.ArrayList;


public class FirstListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String[]> mItems;
    private LayoutInflater mLayoutInflater;

    static class ViewHolder {
        TextView textPrimary;
        TextView textSecondary;
    }

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

        ViewHolder viewHolder;

        if ( view == null ) {

            view = LayoutInflater.from(mContext).inflate( R.layout.list_item_1, null );

            viewHolder = new ViewHolder();
            viewHolder.textPrimary = (TextView) view.findViewById( R.id.textPrimary );
            viewHolder.textSecondary = (TextView) view.findViewById( R.id.textSecondary );

            view.setTag( viewHolder );

        }
        else {

            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.textPrimary.setText( mItems.get(position)[0] );
        viewHolder.textSecondary.setText( mItems.get(position)[1] );

        return view;

    }

    public void toggleOptions( final View view, final int position,
                               final ViewGroup parent, final boolean visible ) {

        final RelativeLayout itemContent = (RelativeLayout) view.findViewById( R.id.itemContent );
        final RelativeLayout itemOptions = (RelativeLayout) view.findViewById( R.id.itemOptions );

        if ( itemOptions.getVisibility() == View.VISIBLE ) {
            itemContent.setVisibility( View.VISIBLE );
            itemOptions.setVisibility( View.INVISIBLE );
        }
        else {
            itemContent.setVisibility( View.INVISIBLE );
            itemOptions.setVisibility( View.VISIBLE );
        }

    }

}
