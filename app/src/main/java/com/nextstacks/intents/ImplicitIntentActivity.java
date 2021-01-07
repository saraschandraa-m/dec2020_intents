package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        final EditText mEtPhone = findViewById(R.id.et_phone);
        final EditText mEtEmailAddress = findViewById(R.id.et_email_address);
        final EditText mEtSubject = findViewById(R.id.et_subject);
        final EditText mEtContent = findViewById(R.id.et_content);

        Button mBtnCall = findViewById(R.id.btn_call);
        Button mBtnBrowser = findViewById(R.id.btn_open_browser);
        Button mBtnSendEmail = findViewById(R.id.btn_send_email);

        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = mEtPhone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });

        mBtnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://nextstacks.com"));
                startActivity(browserIntent);
            }
        });

        mBtnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = mEtEmailAddress.getText().toString();
                String subject = mEtSubject.getText().toString();
                String content = mEtContent.getText().toString();


                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                mailIntent.putExtra(Intent.EXTRA_TEXT, content);
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
                mailIntent.setType("message/rfc822");
                startActivity(mailIntent);
            }
        });
    }
}