package com.example.golu.alterrec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText empName;
    Button add;
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empName=(EditText)findViewById(R.id.empName);
        add=(Button) findViewById(R.id.add);
        lv=(ListView)findViewById(R.id.list);

        al=new ArrayList<String>();
        a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(a);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(al.get(i)==""){
                   a.notifyDataSetChanged();
                   Toast.makeText(getApplicationContext(),"Invalid Cell",Toast.LENGTH_SHORT).show();

               }else{
                   al.remove(i);
                   al.remove(i++);
                   a.notifyDataSetChanged();
                   Toast.makeText(getApplicationContext(),"Valid Cell Deleted with its respective cell",Toast.LENGTH_SHORT).show();
               }

                  /* al.remove(i);
                a.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Selected row Deleted",Toast.LENGTH_SHORT).show();*/

                // Return fro here
                return true;
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=empName.getText().toString();
                al.add(name);
                al.add("");

                a.notifyDataSetChanged();
                empName.setText("");

                empName.requestFocus();
            }
        });

    }
}
