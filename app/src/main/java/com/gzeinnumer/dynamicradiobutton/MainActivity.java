package com.gzeinnumer.dynamicradiobutton;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.dr.DynamicRadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DynamicRadioButton dynamicRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dynamicRadioButton = findViewById(R.id.dr);

//        sample1();
        sample2();
    }

    private void sample1() {
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("Satu");
        listString.add("Dua");
        listString.add("Tiga");
        listString.add("Empat");

        dynamicRadioButton.setItemList(listString).setOnCheckedChangeListener(new DynamicRadioButton.OnCheckedChangeListener<String>() {
            @Override
            public void onCheckedChanged(String item) {
                Log.d(TAG, "onCheckedChanged: " + item);
            }
        });
    }

    private void sample2() {
        ArrayList<ExampleModel> listObject = new ArrayList<>();
        listObject.add(new ExampleModel(1, "Zein", "Balbar"));
        listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
        listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
        listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

        dynamicRadioButton.setItemList(listObject).setOnCheckedChangeListener(new DynamicRadioButton.OnCheckedChangeListener<ExampleModel>() {
            @Override
            public void onCheckedChanged(ExampleModel item) {
                Log.d(TAG, "onCheckedChanged: " + item.toString());
            }
        });
    }
}