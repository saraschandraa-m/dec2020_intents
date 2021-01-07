package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvUsername = findViewById(R.id.textView);
        final EditText mEtUsername = findViewById(R.id.et_second_user);
        Button btnSuccess = findViewById(R.id.btn_success);
        Button btnCancel = findViewById(R.id.btn_cancel);

        Bundle data = getIntent().getExtras();

        String username = data.getString("USERNAME");

        Toast.makeText(SecondActivity.this, username, Toast.LENGTH_LONG).show();

        tvUsername.setText(username);
        mEtUsername.setText(username);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latestUsername = mEtUsername.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("NEWUSER", latestUsername);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}