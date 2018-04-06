package com.haunguyen.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    ArrayList<ThongTinThuChi> thongTinThuChis;
    ListView listView;
    MyArrayAdapter myArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thongTinThuChis = new ArrayList<>();

        listView = (ListView) findViewById(R.id.lvListView);
        myArrayAdapter = new MyArrayAdapter(
                MainActivity.this,
                R.layout.activity_customlistview,
                thongTinThuChis);
        listView.setAdapter(myArrayAdapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(MainActivity.this, Activity_2.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            ArrayList<ThongTinThuChi> arr = (ArrayList<ThongTinThuChi>) data.getSerializableExtra("data");
            for (int i=0; i<arr.size(); i++) {
                thongTinThuChis.add(arr.get(i));
            }
            myArrayAdapter.notifyDataSetChanged();
        }
    }
}
