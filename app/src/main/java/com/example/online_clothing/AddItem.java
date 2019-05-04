package com.example.online_clothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddItem extends AppCompatActivity implements View.OnClickListener {

    EditText itemname, price, description, imagename;
    Button itemadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemname = findViewById(R.id.itemname);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);
        imagename=findViewById(R.id.imagename);
        itemadd=findViewById(R.id.itemadd);

        itemadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        save();

    }

    private void save() {
        try {
            PrintStream printStream=new PrintStream(openFileOutput("items.txt", MODE_PRIVATE| MODE_APPEND));
            printStream.println(itemname.getText().toString()+"->"+price.getText().toString()+"->"+description.getText().toString()+"->"+imagename.getText().toString());
            Toast.makeText(this, "Items added at"+ getFilesDir(), Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getApplicationContext(),Dashboard.class);
            startActivity(intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
