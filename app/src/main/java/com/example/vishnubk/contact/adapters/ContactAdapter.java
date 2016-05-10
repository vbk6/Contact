package com.example.vishnubk.contact.adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vishnubk.contact.Contact;
import com.example.vishnubk.contact.DBHelper;
import com.example.vishnubk.contact.R;

/**
 * Created by vishnubk on 6/1/16.
 */
public class ContactAdapter extends BaseAdapter  {

    //final SQLiteDatabase mydatabase;

   // DBHelper obj= new DBHelper();
    Cursor resultSet;
    Context context;
     DBHelper DBHelper;

    public ContactAdapter(Context context) {
        this.context = context;
        DBHelper= new DBHelper(context);
        //mydatabase = context.openOrCreateDatabase("db", Context.MODE_PRIVATE, null);
       resultSet = DBHelper.getData();
    }



    @Override
    public int getCount() {
        return resultSet.getCount();
    }

    @Override
    public Object getItem(int position) {

        resultSet.moveToPosition(position);
        String name = resultSet.getString(resultSet.getColumnIndexOrThrow("name"));
        String no= resultSet.getString(2);
        return new Contact(name,no);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.item_contact, null);
        }
       TextView itemtext= (TextView) convertView.findViewById(R.id.editTexta);
        TextView itemtext1= (TextView) convertView.findViewById(R.id.editTextb);





        resultSet.moveToPosition(position);
       String name = resultSet.getString(resultSet.getColumnIndexOrThrow("name"));
        String no= resultSet.getString(2);
        itemtext.setText(name);
        ;itemtext1.setText(no);
        return convertView;


    }


}
