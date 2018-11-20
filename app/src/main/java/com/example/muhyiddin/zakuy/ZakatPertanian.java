package com.example.muhyiddin.zakuy;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZakatPertanian extends AppCompatActivity {
    Spinner spinner;
    Button button1;
    Button buttonreset;
    EditText keuntungan;
    EditText hasiltani;
    TextView nilaizakat;
    String selectedItemText;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_pertanian);

        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        keuntungan=(EditText) findViewById(R.id.keuntungan);
        hasiltani=(EditText) findViewById(R.id.hasiltani);
        spinner= (Spinner) findViewById(R.id.spinner);
        nilaizakat=(TextView) findViewById(R.id.hasilnilai);


        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        String[] jenis = new String[]{
                "Air Hujan/Sungai",
                "Irigasi"

        };

        spinner.setPrompt("Pilih Jenis  Pengairan ");
        final List<String> jenisperairan = new ArrayList<>(Arrays.asList(jenis));


        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,jenisperairan){
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
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


                if(TextUtils.isEmpty(keuntungan.getText()) || TextUtils.isEmpty(hasiltani.getText())){
                    Toast.makeText(ZakatPertanian.this, "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                }else{
                    double a= Integer.parseInt(keuntungan.getText().toString());
                    double b= Integer.parseInt(hasiltani.getText().toString());

                    if(b>=720){
                        if (selectedItemText=="Air Hujan/Sungai"){
                            double hnilai=a*10/100;
                                    nilaizakat.setText(""+hnilai);
                        }else{
                            double hnilai=a*5/100;
                                    nilaizakat.setText(""+hnilai);
                        }

                    }else{

                        nilaizakat.setText("Anda Tidak Wajib Berzakat");
                    }
                }


            }
        });

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keuntungan.setText("");
                hasiltani.setText("");
                nilaizakat.setText("");
            }
        });



    }


}