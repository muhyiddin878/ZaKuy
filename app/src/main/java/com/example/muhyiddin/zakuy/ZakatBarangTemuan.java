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
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);





        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(jumlahkeuntungan.getText())){
                    Toast.makeText(ZakatBarangTemuan.this, "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                }else{
                    double a= Integer.parseInt(jumlahkeuntungan.getText().toString());



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

        buttonnishab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ZakatBarangTemuan.this);
                dialog.setCancelable(true);
                dialog.setIcon(R.drawable.logo_icon);
                dialog.setMessage("Tidak Ada Minimal, Karena Merupakan Barang Temuan");
                dialog.setTitle("Nishab: ");
                dialog.setNegativeButton("TUTUP ", new DialogInterface.OnClickListener() {
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
