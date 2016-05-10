package com.example.vishnubk.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class contact extends AppCompatActivity {
    //public static String name;
    //public static String item;
    //public static String item1;
    //public static String phone;
    Button button;
    static final int pick_contact = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(contact.this, MainActivity.class);
                startActivityForResult(i, pick_contact);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pick_contact) {
            if (resultCode == RESULT_OK) {

              String  item = data.getStringExtra("name");
              String  item1=data.getStringExtra("phone");
                TextView textView=(TextView)findViewById(R.id.editTexta);
                textView.setText(item);
                TextView textView1=(TextView)findViewById(R.id.editTextb);
                textView1.setText(item1);
            }
        }
    }
}