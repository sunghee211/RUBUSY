package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OperatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);

        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5); // 수현씨 마이페이지로 넘기기
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPageLoginOwnerActivity.class); // @YR 사업주 로그인 후 마이페이지
                startActivity(intent);
            }
        });

        Button ok3 = (Button) findViewById(R.id.ok3);
        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo : 가게정보 넘긴후 버튼이벤트창 -> 상세페이지
            }
        });
    }
}

