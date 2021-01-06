package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvUsername = findViewById(R.id.textView);

        Bundle data = getIntent().getExtras();

        String username = data.getString("USERNAME");

        Toast.makeText(SecondActivity.this, username, Toast.LENGTH_LONG).show();

        tvUsername.setText(username);
    }
}