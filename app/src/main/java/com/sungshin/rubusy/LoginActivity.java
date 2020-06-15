package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ID 찾기 페이지로
        Button button1 = (Button) findViewById(R.id.findid);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindLoginActivity.class);
                startActivity(intent);
            }
        });

        //비밀번호 찾기 페이지로
        Button button2 = (Button) findViewById(R.id.findpas);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindPasActivity.class);
                startActivity(intent);
            }
        });
        //todo : 개인회원/사업주회원 버튼 값에 따라 검증할 데이터 베이스 다름. radiobutton 기능 구현

        ImageView acloginbtn = (ImageView) findViewById(R.id.acloginbtn);// 메인으로
        //todo : @YR 로그인 기능 구현 및 데베 검증 기능 필요.
        acloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StoreMainActivity.class);
                startActivity(intent);
            }
        });

        Button findlogin = (Button) findViewById(R.id.findlogin);
        findlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo : 로그인 기능, 자동로그인, 아이디 저장 구현 및 버튼 이벤트 창
            }
        });
    }
}
