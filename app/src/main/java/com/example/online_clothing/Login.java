package com.example.online_clothing;


import android.content.Context;
import android.content.Intent;
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
public class Login extends Fragment {
    Context context;
    private EditText input_username,input_password;
    Button btn_login;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_login, container, false);
        input_username = view.findViewById(R.id.input_username);
        input_password = view.findViewById(R.id.input_password);
        btn_login=view.findViewById(R.id.btn_login);

        context=getActivity();


        btn_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=context.getSharedPreferences("User", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username", "");
                String password=sharedPreferences.getString("password", "");

                if(username.equals(input_username.getText().toString()) ||
                password.equals(input_password.getText().toString()))
                {
                    Intent intent=new Intent(context,Dashboard.class);
                    startActivity(intent);
                    Toast.makeText(context,"Sucessful", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context,"error! username or password Invalid", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }


}
