package com.sungshin.rubusy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPageLoginOwnerActivity extends AppCompatActivity {
    private RecyclerView recyclerView_mypage_login_owner;
    private MyPageLoginOwnerAdapter adapter_mypage_login_owner;
    private GridLayoutManager layoutManager_login_owner;

    ArrayList<MyPageLoginOwnerItem> list = new ArrayList<MyPageLoginOwnerItem>() {{
        add(new MyPageLoginOwnerItem("카테고리",R.drawable.my_page1));
        //add(new MyPageLoginOwnerItem("",R.drawable.my_page2));
        add(new MyPageLoginOwnerItem("리뷰댓글작성",R.drawable.my_page3));
        add(new MyPageLoginOwnerItem("설정",R.drawable.my_page5));

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypageloginowner);

        recyclerView_mypage_login_owner = findViewById(R.id.myPageLogOwner_recyclerView);
        adapter_mypage_login_owner = new MyPageLoginOwnerAdapter(getApplicationContext(), list);
        layoutManager_login_owner = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView_mypage_login_owner.setLayoutManager(layoutManager_login_owner);
        recyclerView_mypage_login_owner.setHasFixedSize(true);
        recyclerView_mypage_login_owner.setAdapter(adapter_mypage_login_owner);

    }
}
