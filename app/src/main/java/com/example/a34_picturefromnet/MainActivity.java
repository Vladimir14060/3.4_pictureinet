package com.example.a34_picturefromnet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap myBitmap;
    URL url;
    AnotherThread anotherThread;
    class AnotherThread extends Thread {
        @Override
        public void run() {

            InputStream input = null;
            try {
                input = (InputStream) url.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            myBitmap = BitmapFactory.decodeStream(input);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        try {
            url = new URL("https://sun9-33.userapi.com/impf/cmlRmKLgneshUbqYz1i-WG2a-Fhgxs7ea_gbJw/e-jC48iLooY.jpg?size=1120x1120&quality=96&sign=64dee8aade2c53794663ff5e5ac15266&type=album");
            anotherThread = new AnotherThread();
            anotherThread.start();
            Thread.sleep(3000);
            imageView.setImageBitmap(myBitmap);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}