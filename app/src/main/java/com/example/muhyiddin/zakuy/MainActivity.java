package com.example.muhyiddin.zakuy;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CarouselView carouselView;
    CardView card1;
    CardView card2;

    int[] sampleImages = {R.drawable.bg2, R.drawable.bg_zakat, R.drawable.logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
        setContentView(R.layout.activity_main);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imagelistener);

        card1= (CardView) findViewById(R.id.card_view);
        card2= (CardView) findViewById(R.id.card_view2);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
    }

    ImageListener imagelistener= new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_view:

                Intent intent = new Intent(MainActivity.this, ZakatProfesi.class);
                startActivity(intent);

            break;

            case R.id.card_view2:
                Intent intent2 = new Intent(MainActivity.this, ZakatProfesi.class);
                startActivity(intent2);
        }
    }
}
