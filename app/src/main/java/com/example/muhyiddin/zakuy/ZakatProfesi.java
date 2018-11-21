package com.example.muhyiddin.zakuy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class ZakatProfesi extends AppCompatActivity {

    Button button1;
    Button buttonreset;
    EditText pendapatan;
    EditText hutang;
    EditText hargaberas;
    TextView nisab;
    TextView nilai;
    boolean cek=true;

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_profesi);

        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        pendapatan=(EditText) findViewById(R.id.pendapatan);
        hutang=(EditText) findViewById(R.id.hutang);
        hargaberas=(EditText) findViewById(R.id.hargaberas);
        nisab=(TextView) findViewById(R.id.hasilnisab);
        nilai=(TextView) findViewById(R.id.hasilnilai);
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(pendapatan.getText()) || TextUtils.isEmpty(hutang.getText()) || TextUtils.isEmpty(hargaberas.getText())){
                    Toast.makeText(ZakatProfesi.this, "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                }else{
                    double a= Integer.parseInt(pendapatan.getText().toString());
                    double b= Integer.parseInt(hutang.getText().toString());
                    double c= Integer.parseInt(hargaberas.getText().toString());

                    double gaji_bersih=a-c;



                    double hnishab=653*c;
                    nisab.setText(formatRupiah.format(hnishab));


                    if(hnishab> gaji_bersih){

                        nilai.setText("Anda Tidak Wajib Berzakat");
                    }
                    else{

                        double hnilai=(gaji_bersih*2.5/100);
                        nilai.setText(formatRupiah.format(hnilai));

                    }
                }



            }
        });


        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pendapatan.setText("");
                hutang.setText("");
                hargaberas.setText("");
                nisab.setText("");
                nilai.setText("");
            }
        });

    }
}
