package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class Categoryasian extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<StoreModel> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private String sort;


    TextView TextViewkr;
    TextView TextViewam;
    TextView TextViewcafe;
    TextView TextViewfood;
    TextView TextViewfast;
    TextView TextViewasian;
    TextView TextViewstorename;
    ImageButton backbtn2;
    ImageButton mypageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asian);
        Intent toKorean = getIntent();
        String category = toKorean.getExtras().getString("TextViewkr");
        TextView TextViewStorename = (TextView)findViewById(R.id.TextViewstorename);
        TextViewStorename.setText(category);

        if (TextViewStorename.getText().toString().equals("한식")) {
            sort = "한식";
            Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                    .orderByChild("category")
                    .equalTo("한식");
            query.addListenerForSingleValueEvent(valueEventListener);
        } else if (TextViewStorename.getText().toString().equals("아시안 음식")) {
            sort = "asian";
            Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                    .orderByChild("category")
                    .equalTo("asian");
            query.addListenerForSingleValueEvent(valueEventListener);
        } else if (TextViewStorename.getText().toString().equals("카페")) {
            sort = "카페";
            Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                    .orderByChild("category")
                    .equalTo("카페");
            query.addListenerForSingleValueEvent(valueEventListener);
        } else if (TextViewStorename.getText().toString().equals("분식")) {
            sort = "분식";
            Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                    .orderByChild("category")
                    .equalTo("분식");
            query.addListenerForSingleValueEvent(valueEventListener);
        } else if (TextViewStorename.getText().toString().equals("패스트 푸드")) {
            sort = "패스트 푸드";
            Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                    .orderByChild("category")
                    .equalTo("패스트 푸드");
            query.addListenerForSingleValueEvent(valueEventListener);
        } else {sort = "양식";
            Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                    .orderByChild("category")
                    .equalTo("양식");
            query.addListenerForSingleValueEvent(valueEventListener);}

        backbtn2 = findViewById(R.id.back_category2);
        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Categoryasian.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        mypageBtn = findViewById(R.id.myPageBtn);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Categoryasian.this, MyPageActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.mainList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        Query query = FirebaseDatabase.getInstance().getReference("StoreModel")
                .orderByChild("category")
                .equalTo("asian");
        query.addListenerForSingleValueEvent(valueEventListener);


        adapter = new storeAdapter(arrayList,this);
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            arrayList.clear();
            if (dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    StoreModel storeModel = snapshot.getValue(StoreModel.class);
                    arrayList.add(storeModel);
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}