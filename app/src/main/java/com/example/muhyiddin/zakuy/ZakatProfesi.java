package com.example.muhyiddin.zakuy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
    Button buttonnishab;
    EditText pendapatan;
    EditText hutang;
    EditText hargaberas;
    TextView nisab;
    TextView nilai;
    boolean cek=true;
    private String currentNominal = "0";
    Locale localeID = new Locale("in", "ID");
    private NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

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
        buttonnishab=(Button) findViewById(R.id.buttonnishab);
        pendapatan=(EditText) findViewById(R.id.pendapatan);
        hutang=(EditText) findViewById(R.id.hutang);
        hargaberas=(EditText) findViewById(R.id.hargaberas);
        nisab=(TextView) findViewById(R.id.hasilnisab);
        nilai=(TextView) findViewById(R.id.hasilnilai);





        pendapatan.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        pendapatan.setSelection(pendapatan.getText().length());

        hutang.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        hutang.setSelection(pendapatan.getText().length());

        hargaberas.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        hargaberas.setSelection(pendapatan.getText().length());


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(pendapatan.getText()) || TextUtils.isEmpty(hutang.getText()) || TextUtils.isEmpty(hargaberas.getText())){
                    Toast.makeText(ZakatProfesi.this, "Data Must be Complete!", Toast.LENGTH_SHORT).show();
                }else{
                    double a = Double.parseDouble(pendapatan.getText().toString().replaceAll("[Rp,.]", ""));
                    double b = Double.parseDouble(pendapatan.getText().toString().replaceAll("[Rp,.]", ""));
                    double c = Double.parseDouble(pendapatan.getText().toString().replaceAll("[Rp,.]", ""));
                    double gaji_bersih=a-c;



                    double hnishab=653*c;
                    nisab.setText(formatRupiah.format(hnishab));


                    if(hnishab> gaji_bersih){

                        nilai.setText("You are Not Obliged to Pay Zakat");
                    }
                    else{

                        double hnilai=(gaji_bersih*2.5/100);
                        nilai.setText(formatRupiah.format(hnilai));

                    }
                }



            }
        });

        pendapatan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    pendapatan.removeTextChangedListener(this);

                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    pendapatan.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    pendapatan.setSelection(pendapatan.getText().length());


                    pendapatan.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        hutang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    hutang.removeTextChangedListener(this);

                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    hutang.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    hutang.setSelection(hutang.getText().length());


                    hutang.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        hargaberas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    hargaberas.removeTextChangedListener(this);

                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    hargaberas.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    hargaberas.setSelection(hargaberas.getText().length());


                    hargaberas.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

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
        buttonnishab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ZakatProfesi.this);
                dialog.setCancelable(true);
                dialog.setIcon(R.drawable.logo_icon);
                dialog.setTitle("Nishab: ");
                dialog.setMessage("\n" + "Worth the price of 653kg of rice");
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
