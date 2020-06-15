package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FindPasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpas);

        ImageView backToLogin = (ImageView) findViewById(R.id.backToLogin); // 로그인페이지
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class); //로그인페이지
                startActivity(intent);
            }
            });

            Button find = (Button) findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    //todo : 비밀번호 알림창
                }
        });
    }
}
