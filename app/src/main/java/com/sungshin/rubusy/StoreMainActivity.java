package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StoreMainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<StoreModel> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference, memberReference, ownerReference, database2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        recyclerView = findViewById(R.id.mainList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        mAuth = FirebaseAuth.getInstance();
        memberReference = FirebaseDatabase.getInstance().getReference("Member");
        ownerReference = FirebaseDatabase.getInstance().getReference("Owner");
        database2 = FirebaseDatabase.getInstance().getReference();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("StoreModel");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    StoreModel storeModel = snapshot.getValue(StoreModel.class);
                    arrayList.add(storeModel); //담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준디
                }
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생시
                Log.e("MainActivity", String.valueOf(databaseError.toException())); //에러문 출력

            }
        });

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    StoreModel storeModel = snapshot.getValue(StoreModel.class);
                    arrayList.add(storeModel); //담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준디
                }
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생시
                Log.e("MainActivity", String.valueOf(databaseError.toException())); //에러문 출력

            }
        });
        adapter = new storeAdapter(arrayList,this);
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결

        ImageButton categoryBtn = (ImageButton) findViewById(R.id.categoryBtn);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(intent);
            }
        });
        ImageButton myPageBtn = (ImageButton) findViewById(R.id.myPageBtn);
        myPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(mAuth.getCurrentUser() ==null) {
                            //로그인이 안돼있으면 로그인 화면으로 넘기기
                            Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
                            startActivity(intent);

                        }else if(mAuth.getCurrentUser().getEmail()
                                .equals(dataSnapshot.child("Member").child(mAuth.getCurrentUser().getUid()).child("email").getValue())) {
                            //로그인이 돼있으면
                            Intent intent = new Intent(getApplicationContext(), MyPageLoginActivity.class);
                            startActivity(intent);
                        }else if(mAuth.getCurrentUser().getEmail()
                                .equals(dataSnapshot.child("Owner").child(mAuth.getCurrentUser().getUid()).child("email").getValue())){
                            Intent intent = new Intent(getApplicationContext(), MyPageLoginOwnerActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
            }
        });
        ImageButton searchBtn = (ImageButton) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //todo : 검색기능 구현
//                Intent intent = new Intent(getApplicationContext(),);
            }
        });

    }
}