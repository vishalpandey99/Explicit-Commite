package com.example.implicitcalls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnDial, btnMsg,btnEmail,btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnMsg = findViewById(R.id.btnMsg);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +919519280154"));
                startActivity(iDial);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMessage = new Intent(Intent.ACTION_SENDTO);
                iMessage.setData(Uri.parse("smsto:"+Uri.encode("+918388499829")));
                iMessage.putExtra("sms_body", " This Is vishal Pandey and yoy");
                startActivity(iMessage);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"vishal.com@gmail.com","ankit@gmai.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please Resolve Text");
                startActivity(Intent.createChooser(iEmail,"Email Via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Download This App");
                startActivity(Intent.createChooser(iShare,"Share Via"));
            }
        });
    }
}