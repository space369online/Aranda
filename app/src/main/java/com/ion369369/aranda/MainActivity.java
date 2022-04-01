package com.ion369369.aranda;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theButtonIsClicked();
    }

    public void theButtonIsClicked() {
        Button button1 = findViewById(R.id.button1);
        TextView textView2 = findViewById(R.id.afisaj);
        EditText editText1 = findViewById(R.id.writeSpace);
        ImageView image1 = findViewById(R.id.image1);
        MediaPlayer song1 = MediaPlayer.create(MainActivity.this, R.raw.song1);

        image1.setVisibility(View.INVISIBLE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textEntered = editText1.getText().toString();

                if(textEntered.contains("Mihai")) {
                    textView2.setText("Mihai Cristian");
                    image1.setImageResource(R.drawable.mihai_profil_personal);
                } else if(textEntered.contains("Cristian")) {
                    textView2.setText("Mihai Cristian");
                    image1.setImageResource(R.drawable.mihai_profil_personal);
                } else if(textEntered.contains("start")) {
                    textView2.setText("Ceea ce faci te face.");
                    image1.setImageResource(R.drawable.p3);
                    song1.start();
                } else if(textEntered.contains("stop")) {
                    textView2.setText("Ceea ce faci te face.");
                    image1.setImageResource(R.drawable.p3);
                    song1.stop();
                } else {
                    textView2.setText("Ceea ce faci te face.");
                    image1.setImageResource(R.drawable.p3);
                }

                image1.setVisibility(View.VISIBLE);
                try {
                    Double kilograms = Double.parseDouble(textEntered);
                    Double pounds = convertFromKilogramsToPounds(kilograms);

                    textView2.setText(pounds.toString() + " pounds");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }

        });
    }

    public Double convertFromKilogramsToPounds(Double num1) {
        return num1 * 2.205;
    }

}