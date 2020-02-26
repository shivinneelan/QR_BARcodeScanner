package com.mca.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText qrText_;
    Button qrGeneration_,qrScan_;
    String qrtext = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    qrText_ = (EditText) findViewById(R.id.qrText);
    qrGeneration_ = (Button) findViewById(R.id.generateQRButton);
    qrScan_ = (Button) findViewById(R.id.scanQRButton);


    qrGeneration_.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            qrtext = qrText_.getText().toString().trim();

            if(qrtext != "" && !qrtext.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, QR_DisplayActivity.class);
                        intent.putExtra("QR_Text", qrtext);
                startActivity(intent);
            }
            else
                Toast.makeText(MainActivity.this,"Enter Data ",Toast.LENGTH_LONG).show();
        }
    });

    qrScan_.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QR_ReadActivity.class);
            startActivity(intent);
        }
    });

    }
}
