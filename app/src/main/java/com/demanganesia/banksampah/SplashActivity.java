package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private  static int SPLASH_SCREEN = 4000;

    Animation topAnim, bottomAnim;
    TextView tvBank, tvSampah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //animasi
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        tvBank = findViewById(R.id.tvBank);
        tvSampah = findViewById(R.id.tvSampah);

        tvBank.setAnimation(topAnim);
        tvSampah.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent keMasuk = new Intent(SplashActivity.this, MasukActivity.class);
                startActivity(keMasuk);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}