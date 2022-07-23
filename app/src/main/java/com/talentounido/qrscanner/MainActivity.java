package com.talentounido.qrscanner;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnScan;
    private TextView txtView;

    private static final int QR_SCAN_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        txtView = findViewById(R.id.txtInfo);

        btnScan.setOnClickListener(v -> {
            //Intent scan_init = new Intent(Intent.ACTION_MEDIA_SCANNER_STARTED);

            //Intent scan_init = new Intent("com.google.zxing.client.android.SCAN");
            //scan_init.putExtra("SCAN_MODE", "QR_CODE_MODE");
            //startActivityForResult(scan_init, QR_SCAN_CODE);
            Intent scan_init = new Intent("com.google.zxing.client.android.SCAN");
            if(scan_init.resolveActivity(getPackageManager())!= null){
              startActivityForResult(scan_init,QR_SCAN_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode,data);

        if (requestCode==QR_SCAN_CODE && resultCode == RESULT_OK) {
          
          Bundle extras = data.getExtras();
          String info = (String) extras.get("SCAN_RESULT");
          txtView.setText(info);
        }

    }
}
