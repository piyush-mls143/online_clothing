package com.example.online_clothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {


    Button addtem;
    List<ItemModel> itemModelList=new ArrayList<>();
    String item;

private RecyclerView recyclerAdapter;
   // RecyclerView asd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerAdapter=findViewById(R.id.recyclerViewitems);
        itemsget();
        recyclerAdapter.setLayoutManager(new GridLayoutManager(this,2));
        recyclerAdapter.setAdapter(new ItemAdapter(itemModelList,getApplicationContext()));
        addtem = findViewById(R.id.additem);
        addtem.setOnClickListener(this);
    }

    private void itemsget() {
        try {
            FileInputStream fstream = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fstream);
            BufferedReader br = new BufferedReader(isr);
            while ((item = br.readLine())!=null){
                String[] itemsData = item.split("->");
                String imageName = itemsData[3];
                int res = getResources().getIdentifier(imageName, "drawable", getPackageName());
                itemModelList.add(new ItemModel(itemsData[0],itemsData[1],itemsData[2],res));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Dashboard.this, AddItem.class);
        startActivity(intent);

    }
}
