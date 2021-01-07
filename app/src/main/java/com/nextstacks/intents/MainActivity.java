package com.nextstacks.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

// access_specifier datatype function_name(parameters){}

    //KEY_VALUE

    private EditText etUsername;
    private EditText etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_user_name);
        final EditText etPassword = findViewById(R.id.et_user_password);
         etPhoneNumber = findViewById(R.id.et_user_phone);

        Button btnMove = findViewById(R.id.btn_move);
        Button btnMoveWithResult = findViewById(R.id.btn_move_result);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = etUsername.getText().toString();
                String passwordValue = etPassword.getText().toString();
//                String phoneNumberValue = etPhoneNumber.getText().toString();

                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                secondIntent.putExtra("USERNAME", usernameValue);
                secondIntent.putExtra("PASSWORD", passwordValue);
//                secondIntent.putExtra("PHONENO", phoneNumberValue);
                startActivity(secondIntent);
            }
        });

        btnMoveWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = etUsername.getText().toString();
                String passwordValue = etPassword.getText().toString();
//                String phoneNumberValue = etPhoneNumber.getText().toString();

                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                secondIntent.putExtra("USERNAME", usernameValue);
                secondIntent.putExtra("PASSWORD", passwordValue);
                startActivityForResult(secondIntent, 134);
            }
        });
    }

    //Explicit

    //Implicit

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 134){
            if(resultCode == Activity.RESULT_OK){
                Bundle returnData = data.getExtras();
                String newUsername = returnData.getString("NEWUSER");
                etUsername.setText(newUsername);
//                String newUsername = data.getExtras().getString()
            }else{
                Toast.makeText(MainActivity.this, "User Pressed Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}