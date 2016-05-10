package com.example.vishnubk.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vishnubk.contact.adapters.ContactAdapter;

import java.util.List;
/*pgm implementing custom adapter
 *finding item position and content on a list view
 * dbhelper
 * adding values to a list view dynamically and retrieving it
 * using onActivity result.
 */

public class MainActivity extends AppCompatActivity {


    //final String[] items = new String[] {"vbk","3445","vishnu","53%366"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // Intent i = new Intent(MainActivity.this, contact.class);
                //startActivity(i);
            }
        });
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        final ListView listView = (ListView) findViewById(R.id.listView2);
     final ContactAdapter adapter=new ContactAdapter(this);
      listView.setAdapter(adapter);
       // listView.setAdapter(new ContactAdapter(this));


        //((ListView)findViewById(R.id.listView2)).setAdapter(new ContactAdapter(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ListView listView=(ListView) findViewById(R.id.listView2);;
                Intent i=new Intent();
                Contact contact= (Contact) adapter.getItem(position);
                i.putExtra ("name",contact.getName());
                i.putExtra("phone", contact.getPhone());
                //i.putExtra (contact.name1,items);
                setResult(RESULT_OK, i);
                //startActivity(i);
                //return i;
                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((ListView)findViewById(R.id.listView2)).setAdapter(new ContactAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
