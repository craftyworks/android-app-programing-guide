package com.ddam40.example.anonymoussns

import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.card_post.view.*

class WriteActivity : AppCompatActivity() {

    val bgList = mutableListOf<String>(
        "android.resource://com.ddam40.example.anonymoussns/drawable/default_bg",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg2",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg3",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg4",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg5",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg6",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg7",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg8",
        "android.resource://com.ddam40.example.anonymoussns/drawable/bg9"
    )

    var currentBgPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        supportActionBar?.title = "글쓰기"

        val layoutManager = LinearLayoutManager(this@WriteActivity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MyAdapter()

        sendButton.setOnClickListener {
            if (TextUtils.isEmpty(input.text)) {
                Toast.makeText(applicationContext, "메세지를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val post = Post()
            val newRef = FirebaseDatabase.getInstance().getReference("Posts").push()
            post.writeTime = ServerValue.TIMESTAMP
            post.bgUri = bgList[currentBgPosition]
            post.message = input.text.toString()
            post.writerId = getMyId()
            post.postId = newRef.key
            newRef.setValue(post)

            Toast.makeText(applicationContext, "공유되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun getMyId(): String {
        return Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                LayoutInflater.from(this@WriteActivity).inflate(
                    R.layout.card_background,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return bgList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            Log.d("바인드뷰:", "holder ${holder.javaClass}, position: $position")
            Log.d("바인드뷰:", "${Uri.parse(bgList[position])}")
            Log.d("바인드뷰", "${holder.imageView}")
            Picasso.get()
                .load(Uri.parse(bgList[position]))
                .fit()
                .centerCrop()
                .into(holder.imageView)

            holder.imageView.setOnClickListener {
                currentBgPosition = position

                Picasso.get()
                    .load(Uri.parse(bgList[position]))
                    .fit()
                    .centerCrop()
                    .into(writeBackground)
            }
        }
    }
}
