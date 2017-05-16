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
 //Declare all Variable of Visible component
   
    EditText empName;
    Button add;
    ListView lv;
    
  //Declare ArrayList which hold String data
    ArrayList<String> al;
    
 // Declare A Adapter from where we get data in ListView   
    ArrayAdapter<String> a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Initialization of all visible variable 
        empName=(EditText)findViewById(R.id.empName);
        add=(Button) findViewById(R.id.add);
        lv=(ListView)findViewById(R.id.list);

//Initialization Of ArrayList        
        al=new ArrayList<String>();
        
//Initialization of ArrayAdapter
        a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        
//Set data in listView from Arrayadapter
       lv.setAdapter(a);

   //When we long Click on any ListView Item that item will be Deleted if it found text in listView Item     
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(al.get(i)==""){   //Check if ListItem text in nothing
                   a.notifyDataSetChanged();  //notify ArrayAdapter
                   Toast.makeText(getApplicationContext(),"Invalid Cell",Toast.LENGTH_SHORT).show(); //print in toast that it is invalid cell

               }else{
                   //If in listView Item it get any Text
                   al.remove(i); //remove text at that position 
                   al.remove(i++); // remove respect blank created ListVie Item also
                   a.notifyDataSetChanged(); // Notify ArratyAdapter after All these Operation
                   Toast.makeText(getApplicationContext(),"Valid Cell Deleted with its respective cell",Toast.LENGTH_SHORT).show();
               }

                
                return true;
            }
        });


 // Giveing tast when we click on Add Button       
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take data from EditText where we write any name and set in string variable name 
                String name=empName.getText().toString();
                al.add(name); // Store in arrayList
                al.add("");//Also add a blank data 

                a.notifyDataSetChanged(); // notify adapter 
                empName.setText(""); // after all these clear EditText

                empName.requestFocus(); // Again Set Cursor on EditText to give name
            }
        });

    }
}
