package com.sungshin.rubusy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WriteReviewActivity extends AppCompatActivity {
    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });

        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6); // 수현씨 마이페이지로 넘기기 todo : (레이팅바, 리뷰내용 넘겨주기)
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getApplicationContext(), MyPageLoginActivity.class); //@YR 로그인 후 개인 마이페이지
                startActivity(intent);
            }
        });

        Button registerButton4 = (Button) findViewById(R.id.registerButton4);
        registerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo : 리뷰 전송 후 이벤트창
            }
        });

    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

                Uri selectedImageUri = data.getData();
                imageView.setImageURI(selectedImageUri);
            }
        }


}
