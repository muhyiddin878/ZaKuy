package com.example.muhyiddin.zakuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ZakatPerdagangan extends AppCompatActivity {

    Button button1;
    Button buttonreset;
    EditText totalnilai;
    EditText hutangdagang;
    EditText lababersih;
    TextView nilaizakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_perdagangan);



        button1=(Button) findViewById(R.id.button1);
        buttonreset=(Button) findViewById(R.id.buttonreset);
        totalnilai=(EditText) findViewById(R.id.totalnilai);
        hutangdagang=(EditText) findViewById(R.id.hutangdagang);
        lababersih=(EditText) findViewById(R.id.lababersih);
        nilaizakat=(TextView) findViewById(R.id.hasilnilai);




        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                double a= Integer.parseInt(totalnilai.getText().toString());
                double b= Integer.parseInt(hutangdagang.getText().toString());
                double c= Integer.parseInt(lababersih.getText().toString());


                double hnilai=(a-b+c)*2.5/100;
                nilaizakat.setText(""+hnilai);

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

    }
}
