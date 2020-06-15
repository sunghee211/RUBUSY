package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {
    private RecyclerView recyclerView_mypage;
    private MyPageAdapter adapter_mypage;
    private GridLayoutManager layoutManager;
    ImageButton loginBtn, joinBtn;
    ArrayList<MyPageItem> list = new ArrayList<MyPageItem>() {{
        add(new MyPageItem("카테고리",R.drawable.my_page1));
        add(new MyPageItem("찜",R.drawable.my_page2));
        add(new MyPageItem("리뷰작성",R.drawable.my_page3));
        add(new MyPageItem("작성한 리뷰",R.drawable.my_page4));

    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        recyclerView_mypage = findViewById(R.id.myPage_recyclerView);
        adapter_mypage = new MyPageAdapter(getApplicationContext(), list);
        layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView_mypage.setLayoutManager(layoutManager);
        recyclerView_mypage.setHasFixedSize(true);
        recyclerView_mypage.setAdapter(adapter_mypage);
        loginBtn = findViewById(R.id.loginBtn);
        joinBtn = findViewById(R.id.joinBtn);


        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent toLogin = new Intent(MyPageActivity.this, LoginActivity.class);
                startActivity(toLogin);
            }
        });
        joinBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent toJoin = new Intent(MyPageActivity.this, Register1Activity.class);
                startActivity(toJoin);
                //todo : 우선은 개인화면이 맞나?
            }
        });
    }


}
