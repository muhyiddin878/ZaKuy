package com.example.muhyiddin.zakuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ZakatBarangTemuan extends AppCompatActivity {

    EditText jumlahkeuntungan;
    Button button1;
    Button buttonreset;
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
        nilai=(TextView) findViewById(R.id.hasilnilai);




        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(jumlahkeuntungan.getText())){
                    Toast.makeText(ZakatBarangTemuan.this, "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                }else{
                    double a= Integer.parseInt(jumlahkeuntungan.getText().toString());



                    double hnilai=a*20/100;
                    nilai.setText(""+hnilai);
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
    }
}
