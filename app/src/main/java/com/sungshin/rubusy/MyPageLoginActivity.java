package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPageLoginActivity extends AppCompatActivity {
    private RecyclerView recyclerView_mypage_login;
    private MyPageLoginAdapter adapter_mypage_login;
    private GridLayoutManager layoutManager_login;
    //@YR 버튼
    private ImageButton logoutBtn, mypageBackBtn;
    ArrayList<MyPageLoginItem> list = new ArrayList<MyPageLoginItem>() {{
        add(new MyPageLoginItem("카테고리",R.drawable.my_page1));
        add(new MyPageLoginItem("찜",R.drawable.my_page2));
        add(new MyPageLoginItem("리뷰작성",R.drawable.my_page3));
        add(new MyPageLoginItem("작성한 리뷰",R.drawable.my_page4));

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypagelogin);

        recyclerView_mypage_login = findViewById(R.id.myPageLog_recyclerView);
        adapter_mypage_login = new MyPageLoginAdapter(getApplicationContext(), list);
        layoutManager_login = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView_mypage_login.setLayoutManager(layoutManager_login);
        recyclerView_mypage_login.setHasFixedSize(true);
        recyclerView_mypage_login.setAdapter(adapter_mypage_login);
        logoutBtn = findViewById(R.id.logoutBtn);
        mypageBackBtn = findViewById(R.id.mypagelog_backBut);

        //@YR 리뷰 버튼 동작 구현
        logoutBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //todo : @YR 세션 끊기 구현
                Intent returnToMain = new Intent(MyPageLoginActivity.this, StoreMainActivity.class);
                startActivity(returnToMain);
            }
        });
        mypageBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent returnToMain = new Intent(MyPageLoginActivity.this, StoreMainActivity.class);
                startActivity(returnToMain);
            }
        });
    }
}
