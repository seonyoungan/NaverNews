package com.example.navernews.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.navernews.databinding.NewsItemBinding
import com.example.navernews.model.Items

//뉴스 어댑터 부를때 뉴스타이틀이라는 배열을 받음. 받은 타이틀을 아이템 하나하나 뉴스아이템에 넣어

//val : 한번 넣으면 못 바꾸는 변수(사실상 상수) , var : 바꿀 수 있는 변수, fun : 함수, class : class

//리스트뷰, diffutil사용
class NewsAdapter()
    : ListAdapter<Items, NewsAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Items>() {
        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.title == newItem.title //비교하기 *oldItem: 이전아이템 <-> newItem

        }

        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }
    }
    ) {
    //메인액티비티에서 뉴스타이틀, 뉴스컨텐츠를 매개변수로 가져옴. 리사이클러뷰는 뉴스어댑터에 타입을 지정

    private lateinit var context : Context

    //news_item.xml이랑 연결
    inner class ViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(newsItems: Items){
            binding.tvNewsTittle.text = newsItems.title
            binding.tvNewsContent.text = newsItems.description
        }
    }

    //리사이클러뷰 실행될떄 꼭 필요한 3가지 override ~~~
    //리사이클러 어댑터가 처음 만들어질때 실행되는거
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = NewsItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    //실제 xml이랑 각 아이템이 바인드될때 실행되는 것
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}