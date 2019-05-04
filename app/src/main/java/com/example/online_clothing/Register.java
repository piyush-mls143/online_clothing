package com.example.online_clothing;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment {

    Activity context;
    private EditText fullname, mobileno, username, password;
    Button register;




    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        context=getActivity();
        fullname = view.findViewById(R.id.fullname);
        mobileno = view.findViewById(R.id.mobileno);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        register=view.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("fullname", fullname.getText().toString());
                editor.putString("mobileno", mobileno.getText().toString());
                editor.putString("username", username.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.commit();

                Toast.makeText(context, "Register Successful", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }

}
