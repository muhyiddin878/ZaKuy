package com.example.muhyiddin.zakuy;

import android.content.Intent;
import android.graphics.Color;
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

public class ZakatTernak extends AppCompatActivity {

    Spinner spinner1;
    Button button1;
    Button buttonreset;
    EditText jumlahhewan;
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
        setContentView(R.layout.activity_zakat_ternak);


        spinner1=(Spinner) findViewById(R.id.spinner);
        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        jumlahhewan=(EditText) findViewById(R.id.jumlahhewan);
        nilai=(TextView) findViewById(R.id.hasilnilai);


        String[] jenis = new String[]{
                "Unta",
                "Sapi",
                "Kambing"

        };

        final List<String> jenishewan= new ArrayList<>(Arrays.asList(jenis));


        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,jenishewan){
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
        spinner1.setPrompt("Pilih Jenis Hewan");
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


                if(TextUtils.isEmpty(jumlahhewan.getText())){
                    Toast.makeText(ZakatTernak.this, "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                }else if(spinner1 == null){
                    Toast.makeText(ZakatTernak.this, "Jenis Hewan Dipilih!", Toast.LENGTH_SHORT).show();
                }else if(spinner1.getSelectedItem()==null){
                    Toast.makeText(ZakatTernak.this, "Jenis Hewan Harus Dipilih!", Toast.LENGTH_SHORT).show();
                }else{
                    int a= Integer.parseInt(jumlahhewan.getText().toString());


                        if(selectedItemText=="Unta"){
                            if(a<5){
                                nilai.setText("Anda Tidak Wajib Berzakat");
                            }else if(a>=5 && a<10){
                                nilai.setText("1 ekor kambing umur 2 tahun, atau 1 ekor domba umur 1 tahun");

                            }else if(a>=10&&a<15){
                                nilai.setText("2 ekor kambing umur 2 tahun, atau 2 ekor domba umur 1 tahun");
                            }
                            else if(a>=15 && a<20){
                                nilai.setText("3 ekor kambing umur 2 tahun, atau 3 ekor domba umur 1 tahun");
                            }
                            else if(a>=20 && a <25){
                                nilai.setText("4 ekor kambing umur 2 tahun, atau 4 ekor domba umur 1 tahun");
                            }else if(a>=25 && a<36){
                                nilai.setText("1 ekor onta betina umur 1 tahun");
                            }else if(a>=36 && a<46){
                                nilai.setText("1 ekor onta betina umur 2 tahun");
                            }else if(a>=46 && a<61){
                                nilai.setText("1 ekor onta betina umur 3 tahun");
                            }else if(a>=61 && a<76){
                                nilai.setText("1 ekor onta betina umur 4 tahun");
                            }else if(a>=76 && a<91){
                                nilai.setText("2 ekor onta betina umur 2 tahun");
                            }else if(a>=91 && a<121){
                                nilai.setText("2 ekor onta betina umur 3 tahun");
                            }else {
                                nilai.setText("3 ekor onta betina umur 2 tahun");
                            }

                        }else if(selectedItemText=="Sapi"){
                            if(a<30){
                                nilai.setText("Anda Tidak Wajib Berzakat");
                            }else if (a>=30 && a<40){
                                nilai.setText("1 ekor sapi umur 1 tahun");
                            }else{
                                nilai.setText("1 ekor sapi umur 2 tahun");
                            }
                        }else {
                            if(a<40){
                                nilai.setText("Anda Tidak Wajib Berzakat");
                            }else if(a>=40 && a<121){
                                nilai.setText("2 ekor kambing umur 2 tahun, atau 2 ekor domba umur 1 tahun");
                            }else if(a>=121 && a<201){
                                nilai.setText("3 ekor kambing umur 2 tahun, atau 3 ekor domba umur 1 tahun");
                            }else {
                                nilai.setText("4 ekor kambing umur 2 tahun, atau 4 ekor domba umur 1 tahun.");
                            }

                        }





                }


            }
        });





        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahhewan.setText("");
                nilai.setText("");
            }
        });
    }
}
