package com.task.dropdownexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spin,spin2;
    // spin2 is used the dynamic entries of element in the
    // in the spinner
    HashMap<String, List<String>> modelist =new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Typecasting the variable here
        spin = (Spinner) findViewById(R.id.spin1);
        spin2=findViewById(R.id.spin2);
        MyfirstSpinner myfirstSpinner =new MyfirstSpinner();
        spin.setOnItemSelectedListener(myfirstSpinner);
//
//// Array of Months acting as a data pump
//        String[] objects = {"January", "Feburary", "March", "April", "May",
//                "June", "July", "August", "September", "October", "November", "December"};
//
//// Declaring an Adapter and initializing it to the data pump
//        ArrayAdapter adapter = new ArrayAdapter(
//                getApplicationContext(), android.R.layout.simple_list_item_1, objects);
//
//// Setting Adapter to the Spinner
//        spin.setAdapter(adapter);
//
//// Setting OnItemClickListener to the Spinner
//        spin.setOnItemSelectedListener(MainActivity.this);
//    }
//
//    // Defining the Callback methods here
//    public void onItemSelected(AdapterView parent, View view, int pos,
//                               long id) {
//        Toast.makeText(getApplicationContext(),
//                spin.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG)
//                .show();
//    }
//
//    // Defining the Callback methods here
//    @Override
//    public void onNothingSelected(AdapterView arg0) {
//// TODO Auto-generated method stub


       // this method will add the element dynamically in the the spinner
       // using the Hash method of the function


    }
    private void populateModelList(){
        modelist.put("LG", Arrays.asList("lg1","lg2","lg3"));
        modelist.put("SAMSUNG", Arrays.asList("sam1","sm2","sam3"));
        modelist.put("MOTOROLA", Arrays.asList("Moto1","moto2","moto3"));
    }


    private class MyfirstSpinner implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            TextView textView=(TextView)view;

            List <String> itemModellist = MainActivity.this.modelist.get(textView.getText());
            ArrayAdapter arrayAdapter =new ArrayAdapter(
                    MainActivity.this,android.R.layout.simple_list_item_1,itemModellist);
            MainActivity.this.spin2.setAdapter(arrayAdapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            Toast.makeText(MainActivity.this,"noting is selcted",Toast.LENGTH_SHORT).show();
        }
    }
}
