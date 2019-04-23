package com.example.muhyiddin.zakuy;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ZakatPertanian extends AppCompatActivity {
    Spinner spinner;
    Button button1;
    Button buttonreset;
    Button buttonnishab;
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
        buttonnishab=(Button) findViewById(R.id.buttonnishab);
        keuntungan=(EditText) findViewById(R.id.keuntungan);
        hasiltani=(EditText) findViewById(R.id.hasiltani);
        spinner= (Spinner) findViewById(R.id.spinner);
        nilaizakat=(TextView) findViewById(R.id.hasilnilai);
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);


        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        String[] jenis = new String[]{
                "Rainwater / River",
                "irrigation"

        };

        spinner.setPrompt("Select Type of Irrigation ");
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
                    Toast.makeText(ZakatPertanian.this, "Data Must be Complete!", Toast.LENGTH_SHORT).show();
                }else if(spinner == null){
                    Toast.makeText(ZakatPertanian.this, "Watering Types Must Be Selected!", Toast.LENGTH_SHORT).show();
                }else if(spinner.getSelectedItem()==null){
                    Toast.makeText(ZakatPertanian.this, "Watering Types Must Be Selected!", Toast.LENGTH_SHORT).show();
                }else{
                    double a= Integer.parseInt(keuntungan.getText().toString());
                    double b= Integer.parseInt(hasiltani.getText().toString());

                    if(b>=720){
                        if (selectedItemText=="Rainwater / River"){
                            double hnilai=a*10/100;
                                    nilaizakat.setText(formatRupiah.format(hnilai));
                        }else{
                            double hnilai=a*5/100;
                                    nilaizakat.setText(formatRupiah.format(hnilai));
                        }

                    }else{

                        nilaizakat.setText("You are Not Obliged to Pay Zakat");
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
        buttonnishab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ZakatPertanian.this);
                dialog.setCancelable(true);
                dialog.setIcon(R.drawable.logo_icon);
                dialog.setTitle("Nishab: ");
                dialog.setMessage("Minimum Farming Results Are 720KG");
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
