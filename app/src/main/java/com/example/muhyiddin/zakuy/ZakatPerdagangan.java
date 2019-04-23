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

public class ZakatPerdagangan extends AppCompatActivity {

    Button button1;
    Button buttonreset;
    Button buttonnishab;
    EditText totalnilai;
    EditText hutangdagang;
    EditText lababersih;
    TextView nilaizakat;
    int nishab= 46750000;


    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_perdagangan);



        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        buttonnishab=(Button) findViewById(R.id.buttonnishab);
        totalnilai=(EditText) findViewById(R.id.totalnilai);
        hutangdagang=(EditText) findViewById(R.id.hutangdagang);
        lababersih=(EditText) findViewById(R.id.lababersih);
        nilaizakat=(TextView) findViewById(R.id.hasilnilai);
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);




        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                double a= Integer.parseInt(totalnilai.getText().toString());
                double b= Integer.parseInt(hutangdagang.getText().toString());
                double c= Integer.parseInt(lababersih.getText().toString());


                if(TextUtils.isEmpty(totalnilai.getText()) || TextUtils.isEmpty(hutangdagang.getText()) || TextUtils.isEmpty(lababersih.getText())){
                    Toast.makeText(ZakatPerdagangan.this, "Data Must be Complete!", Toast.LENGTH_SHORT).show();
                }else if(a < nishab){
                    nilaizakat.setText(("You are Not Obliged to Pay Zakat"));
                }

                    else{
                    double hnilai=(a-b+c)*2.5/100;
                    nilaizakat.setText(formatRupiah.format(hnilai));
                }


            }
        });


        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalnilai.setText("");
                hutangdagang.setText("");
                lababersih.setText("");
                nilaizakat.setText("");
            }
        });
        buttonnishab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ZakatPerdagangan.this);
                dialog.setCancelable(true);
                dialog.setIcon(R.drawable.logo_icon);
                dialog.setTitle("Nishab: ");
                dialog.setMessage("Having wealth (working capital and profit) is greater or equivalent to 85 grams of pure gold if per gram Rp. 550,000 - = Rp.46,750,000 -)");
                dialog.setNegativeButton("CLOSE ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                final AlertDialog alert = dialog.create();
                alert.show();
            }
        });




    }
}
