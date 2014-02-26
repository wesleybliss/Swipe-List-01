package com.gammagamma.swipelist01.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.gammagamma.swipelist01.app.Adapters.FirstListAdapter;

import java.util.ArrayList;


public class MainActivity extends Activity {


    private ListView mListView;
    private FirstListAdapter firstListAdapter;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mListView = (ListView) findViewById( android.R.id.list );

        ArrayList<String[]> data = new ArrayList<String[]>();
        for ( int i = 0; i < 10; i++ ) {
            String[] temp = {
                "Item #" + String.valueOf(i),
                "Lalalala lala la la."
            };
            data.add( temp );
        }

        firstListAdapter = new FirstListAdapter( this, data );
        mListView.setAdapter( firstListAdapter );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
