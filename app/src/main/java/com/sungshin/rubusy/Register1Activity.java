package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Register1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        Button button3 = (Button) findViewById(R.id.bui);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register2Activity.class);
                startActivity(intent);
            }
        });

        ImageView imageView2 = (ImageView) findViewById(R.id.backToMyPage); // 수현씨 마이페이지로 넘기기
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class); // 마이페이지
                startActivity(intent);
            }
        });

        Button check2 = (Button) findViewById(R.id.dupCheck);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo : 아이디 값 중복체크 후 알림창
            }
        });

        Button combtn = (Button) findViewById(R.id.combtn);
        combtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //todo : 회원가입 완료 데이터 넘겨주고 이벤트창
                }
        });

    }
}
