package com.example.muhyiddin.zakuy;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ZakatEmasPerak extends AppCompatActivity {

    Spinner spinner1;
    Button button1;
    Button buttonreset;
    Button buttonnishab;
    EditText hargajual;
    EditText jumlahemasperak;
    TextView nilai;
    String  selectedItemText;


    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_emas_perak);


        spinner1=(Spinner) findViewById(R.id.spinner);
        button1=( Button) findViewById(R.id.button1);
        buttonreset= (Button) findViewById(R.id.buttonreset);
        buttonnishab= (Button) findViewById(R.id.buttonnishab);
        hargajual= (EditText) findViewById(R.id.hargajual);
        jumlahemasperak=(EditText) findViewById(R.id.jumlahemasperak);
        nilai=(TextView) findViewById(R.id.hasilnilai);
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);


        String[] jenis = new String[]{
                "Emas",
                "Perak"

        };
        spinner1.setPrompt("Pilih Jenis");
        final List<String> jenisemasperak = new ArrayList<>(Arrays.asList(jenis));


        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,jenisemasperak){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position%2 == 1) {
                    // Set the item background color
                    tv.setBackgroundColor(Color.parseColor("#FF73F773"));
                }
                else {
                    // Set the alternate item background color
                    tv.setBackgroundColor(Color.parseColor("#FF34F234"));
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner1.setAdapter(spinnerArrayAdapter);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                Toast.makeText
                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {





                if(TextUtils.isEmpty(hargajual.getText())){
                    Toast.makeText(ZakatEmasPerak.this, "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                }else if(spinner1 == null){
                    Toast.makeText(ZakatEmasPerak.this, "Jenis Harus Dipilih!", Toast.LENGTH_SHORT).show();
                }else if(spinner1.getSelectedItem()==null){
                    Toast.makeText(ZakatEmasPerak.this, "Jenis Harus Dipilih!", Toast.LENGTH_SHORT).show();
                }
                else{
                    double a= Integer.parseInt(hargajual.getText().toString());
                    double b= Integer.parseInt(jumlahemasperak.getText().toString());

                    if(b>=84.8){
                            double hnilaitemp=b*2.5/100;
                            double hnilai=hnilaitemp*a;
                            nilai.setText(formatRupiah.format(hnilai));


                    }else{

                        nilai.setText("Anda Tidak Wajib Berzakat");
                    }
                }


            }
        });

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hargajual.setText("");
                jumlahemasperak.setText("");
                nilai.setText("");
            }
        });

        buttonnishab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(ZakatEmasPerak.this);
                dialog.setCancelable(true);
                dialog.setIcon(R.drawable.logo_icon);
                dialog.setMessage("Minimal Kepemilikan Emas/Perak 84,8 gram");
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


