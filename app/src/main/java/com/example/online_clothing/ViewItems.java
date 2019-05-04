package com.example.online_clothing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewItems extends AppCompatActivity {

    ImageView image;
    TextView itemname, itemprice, itemdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_items);

        image = findViewById(R.id.image);
        itemname=findViewById(R.id.itemname);
        itemprice=findViewById(R.id.itemprice);
        itemdescription=findViewById(R.id.itemdescription);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            itemname.setText(bundle.getString("itemname"));
            itemprice.setText(bundle.getString("itemprice"));
            itemdescription.setText(bundle.getString("itemdescription"));
            image.setImageResource(bundle.getInt("image"));
        }



    }
}
