package com.sungshin.rubusy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class CategoryActivity extends AppCompatActivity {
    GridLayout categoryGrid;
    ImageButton backBtn;
    TextView TextViewkr;
    TextView TextViewam;
    TextView TextViewcafe;
    TextView TextViewfood;
    TextView TextViewfast;
    TextView TextViewasian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryGrid = findViewById(R.id.categoryGrid);
        setSingleEvent(categoryGrid);

        backBtn = findViewById(R.id.back_category);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        CategoryActivity.this,
                        StoreMainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setSingleEvent(GridLayout categoryGrid) {
        for(int i = 0; i < categoryGrid.getChildCount(); i++){
            //그리드 뷰의 모든 자식들은 카드뷰이다. 카드뷰 객체로 타입캐스팅을하자.
            CardView cardview = (CardView)categoryGrid.getChildAt(i);
            final int finalI = i;
            cardview.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    Toast.makeText(CategoryActivity.this, "동작확인"+ finalI, Toast.LENGTH_SHORT).show();
                    switch (finalI){
                        case 0:
                            Intent toKorean = new Intent(getApplicationContext(), Categoryasian.class);
                            toKorean.putExtra("TextViewkr","한식");
                            startActivity(toKorean);
                            break;
                        case 1:
                            Intent toWestern = new Intent(getApplicationContext(), Categoryasian.class);
                            toWestern.putExtra("TextViewkr","양식");
                            startActivity(toWestern);
                            break;
                        case 2:
                            Intent toBeverage = new Intent(getApplicationContext(), Categoryasian.class);
                            toBeverage.putExtra("TextViewkr","카페");
                            startActivity(toBeverage);
                            break;
                        case 3:
                            Intent toFlour = new Intent(getApplicationContext(), Categoryasian.class);
                            toFlour.putExtra("TextViewkr","분식");
                            startActivity(toFlour);
                            break;
                        case 4:
                            Intent toFast = new Intent(getApplicationContext(), Categoryasian.class);
                            toFast.putExtra("TextViewkr","패스트 푸드");
                            startActivity(toFast);
                            break;
                        case 5:
                            Intent toAsian = new Intent(getApplicationContext(), Categoryasian.class);
                            toAsian.putExtra("TextViewkr","아시안 음식");
                            startActivity(toAsian);
                            break;

                    }
                }

            });
        }
    }

}
