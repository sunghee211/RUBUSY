package com.sungshin.rubusy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        //todo : intent로 넘겨받은 가게이름 setText
        storeName.setText("가게이름")

        //리뷰 목록 및 정보
        val reviewList = listOf(
            ReviewModel(R.drawable.food1,"정말 맛있어요!","H유진 넌 정말 멋지고 랩도 잘하고 모든 것이 펄풱 이건 인생의 진리지 ",
                4.5F),
            ReviewModel(R.drawable.food1,"별점이 아깝다","장사 하시는 거 다시 한 번 생각해보세요",
                1.5F),
            ReviewModel(R.drawable.food2,"별미","좋네요",
                4.0F),
            ReviewModel(R.drawable.food1,"정말 맛있어요!","H유진 넌 정말 멋지고 랩도 잘하고 모든 것이 펄풱 이건 인생의 진리지 ",
                4.5F),
            ReviewModel(R.drawable.food2,"정말 맛있어요!","H유진 넌 정말 멋지고 랩도 잘하고 모든 것이 펄풱 이건 인생의 진리지 ",
                4.5F),
            ReviewModel(R.drawable.food2,"정말 맛있어요!","H유진 넌 정말 멋지고 랩도 잘하고 모든 것이 펄풱 이건 인생의 진리지 ",
                4.5F),
            ReviewModel(R.drawable.food1,"정말 맛있어요!","H유진 넌 정말 멋지고 랩도 잘하고 모든 것이 펄풱 이건 인생의 진리지 ",
                4.5F),
            ReviewModel(R.drawable.food2,"정말 맛있어요!","H유진 넌 정말 멋지고 랩도 잘하고 모든 것이 펄풱 이건 인생의 진리지 ",
                4.5F)
        )

        val adapter = ReviewDataAdapter(reviewList)
        reviewLayout.adapter = adapter
        reviewLayout.layoutManager = LinearLayoutManager(this)

        //todo : 가게이름도 다시 돌려줘서 불러야할까
        back_detail.setOnClickListener {
            val intent = Intent(this, StoreDetailActivity::class.java )
            startActivity(intent)
        }
    }
}
