package com.example.sagaronlineclothingshopping;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Login extends Fragment implements  View.OnClickListener {

    private EditText ET_Username, ET_Password;
    private Button BTN_Login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ET_Username = view.findViewById(R.id.ET_Username);
        ET_Password = view.findViewById(R.id.ET_Password);
        BTN_Login = view.findViewById(R.id.BTN_Login);

        BTN_Login.setOnClickListener(this);
        return view;
    }
    private void checkUser(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User",MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");

        if(username.equals(ET_Username.getText().toString()) && password.equals(ET_Password.getText().toString())){
            Toast.makeText(this.getActivity(),"Login Successfully",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this.getActivity(), Dashboard.class);
            startActivity(intent);

        }else{
            Toast.makeText(this.getActivity(),"Invalid username/password!!!",Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onClick(View v) {
        checkUser();
    }
}
