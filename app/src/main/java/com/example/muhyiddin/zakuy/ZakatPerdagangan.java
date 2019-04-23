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

public class ZakatPerdagangan extends AppCompatActivity {

    Button button1;
    Button buttonreset;
    Button buttonnishab;
    EditText totalnilai;
    EditText hutangdagang;
    EditText lababersih;
    TextView nilaizakat;
    int nishab= 46750000;

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
        setContentView(R.layout.activity_zakat_perdagangan);



        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        buttonnishab=(Button) findViewById(R.id.buttonnishab);
        totalnilai=(EditText) findViewById(R.id.totalnilai);
        hutangdagang=(EditText) findViewById(R.id.hutangdagang);
        lababersih=(EditText) findViewById(R.id.lababersih);
        nilaizakat=(TextView) findViewById(R.id.hasilnilai);

        totalnilai.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        totalnilai.setSelection(totalnilai.getText().length());

        hutangdagang.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        hutangdagang.setSelection(hutangdagang.getText().length());

        lababersih.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        lababersih.setSelection(lababersih.getText().length());








        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                double a = Double.parseDouble(totalnilai.getText().toString().replaceAll("[Rp,.]", ""));
                double b = Double.parseDouble(hutangdagang.getText().toString().replaceAll("[Rp,.]", ""));
                double c = Double.parseDouble(lababersih.getText().toString().replaceAll("[Rp,.]", ""));



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

        totalnilai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    totalnilai.removeTextChangedListener(this);


                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    totalnilai.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    totalnilai.setSelection(totalnilai.getText().length());


                    totalnilai.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        hutangdagang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    hutangdagang.removeTextChangedListener(this);


                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    hutangdagang.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    hutangdagang.setSelection(hutangdagang.getText().length());


                    hutangdagang.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lababersih.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    lababersih.removeTextChangedListener(this);


                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    lababersih.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    lababersih.setSelection(lababersih.getText().length());


                    lababersih.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

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
