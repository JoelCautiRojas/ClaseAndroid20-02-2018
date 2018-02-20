package com.example.pc_b_013.ejemplologin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView img1 = findViewById(R.id.imagen1);
        ImageView img2 = findViewById(R.id.imagen2);
        ImageView img3 = findViewById(R.id.imagen3);
        ImageView img4 = findViewById(R.id.imagen4);
        ImageView img5 = findViewById(R.id.imagen5);
        ImageView img6 = findViewById(R.id.imagen6);

        String url1 = "http://www.programadoresperuanos.com/test_app/imagen1.jpg";
        String url2 = "http://www.programadoresperuanos.com/test_app/imagen2.jpg";
        String url3 = "http://www.programadoresperuanos.com/test_app/imagen3.jpg";
        String url4 = "http://www.programadoresperuanos.com/test_app/imagen4.jpg";
        String url5 = "http://www.programadoresperuanos.com/test_app/imagen5.jpg";
        String url6 = "http://www.programadoresperuanos.com/test_app/imagen6.jpg";

        Picasso.with(getApplicationContext()).load(url1).error(R.drawable.error).placeholder(R.drawable.cargando).into(img1);
        Picasso.with(getApplicationContext()).load(url2).error(R.drawable.error).placeholder(R.drawable.cargando).into(img2);
        Picasso.with(getApplicationContext()).load(url3).error(R.drawable.error).placeholder(R.drawable.cargando).into(img3);
        Picasso.with(getApplicationContext()).load(url4).error(R.drawable.error).placeholder(R.drawable.cargando).into(img4);
        Picasso.with(getApplicationContext()).load(url5).error(R.drawable.error).placeholder(R.drawable.cargando).into(img5);
        Picasso.with(getApplicationContext()).load(url6).error(R.drawable.error).placeholder(R.drawable.cargando).into(img6);
    }
}
