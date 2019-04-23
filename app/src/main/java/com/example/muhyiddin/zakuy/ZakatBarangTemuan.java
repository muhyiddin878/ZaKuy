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

public class ZakatBarangTemuan extends AppCompatActivity {

    EditText jumlahkeuntungan;
    Button button1;
    Button buttonreset;
    Button buttonnishab;
    TextView nilai;


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
        setContentView(R.layout.activity_zakat_barang_temuan);


        jumlahkeuntungan= (EditText) findViewById(R.id.jumlahhargatemuan);
        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        buttonnishab=(Button) findViewById(R.id.buttonnishab);
        nilai=(TextView) findViewById(R.id.hasilnilai);


        jumlahkeuntungan.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
        jumlahkeuntungan.setSelection(jumlahkeuntungan.getText().length());




        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(jumlahkeuntungan.getText())){
                    Toast.makeText(ZakatBarangTemuan.this, "Data must be complete!", Toast.LENGTH_SHORT).show();
                }else{
                    double a = Double.parseDouble(jumlahkeuntungan.getText().toString().replaceAll("[Rp,.]", ""));



                    double hnilai=a*20/100;
                    nilai.setText(formatRupiah.format(hnilai));
                }


            }
        });

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai.setText("");
                jumlahkeuntungan.setText("");
            }
        });

        jumlahkeuntungan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(currentNominal)){
                    jumlahkeuntungan.removeTextChangedListener(this);


                    currentNominal = charSequence.toString().replaceAll("[Rp,.]", "");

                    if (currentNominal.equals("")){
                        currentNominal = "0";
                    }

                    jumlahkeuntungan.setText(formatRupiah.format(Double.parseDouble(currentNominal)));
                    jumlahkeuntungan.setSelection(jumlahkeuntungan.getText().length());


                    jumlahkeuntungan.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonnishab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ZakatBarangTemuan.this);
                dialog.setCancelable(true);
                dialog.setIcon(R.drawable.logo_icon);
                dialog.setMessage("There is no minimum, because it is an item of discovery");
                dialog.setTitle("Nishab: ");
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
