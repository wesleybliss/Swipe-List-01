package com.gammagamma.swipelist01.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.gammagamma.swipelist01.app.Adapters.FirstListAdapter;

import java.util.ArrayList;


public class MainActivity
    extends Activity
    implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ListView mListView;
    private FirstListAdapter firstListAdapter;
    private Context mContext;
    private SwipeDetector swipeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mListView = (ListView) findViewById( android.R.id.list );

        // @debug dummy data
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

        mListView.setOnItemLongClickListener( this );
        mListView.setOnItemClickListener( this );

        swipeDetector = new SwipeDetector();
        mListView.setOnTouchListener( swipeDetector );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
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
        return super.onOptionsItemSelected( item );
    }

    @Override
    public void onItemClick( AdapterView<?> parent, View view, int position, long id ) {
        if ( swipeDetector.swipeDetected() ) {
            Toast.makeText( this, "You swiped!", Toast.LENGTH_LONG ).show();
        }
        else {
            Toast.makeText( this, "You normal tapped", Toast.LENGTH_LONG ).show();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        firstListAdapter.toggleOptions( view, position, parent, true );
        return false;
    }

}
