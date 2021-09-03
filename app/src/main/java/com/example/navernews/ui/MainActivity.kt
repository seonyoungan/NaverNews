package com.example.navernews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navernews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    private val adapter by lazy{
        NewsAdapter()
    } //어댑더 객체만들었ㄴ는데 레이지로 선언된건 선행될것들이 만들어진다음에 천천히 만들겠다는 거

    private val linearLayoutManager = LinearLayoutManager(this)

    private var index = 1

    private var query = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //메인액티비티랑 연결
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


//        val titles = arrayListOf("title1", "title2", "title3", "title4")
//        val contents = arrayListOf("안녕하세요","반갑습니다.","저는안선", "영입니다.")
//        val adapter = NewsAdapter(titles, contents)

        /* .rvNews.layoutManager = LinearLayoutManager(this)깔끔하게쓰기
        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
         */
        binding.rvNews.let {
            it.layoutManager = linearLayoutManager
            it.setHasFixedSize(true)
            it.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
            it.adapter = adapter
            it.addOnScrollListener(
                object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        if(linearLayoutManager.findLastVisibleItemPosition() > adapter.itemCount -5)
                            viewModel.getNewsList(query, index++)
                    }
                }
            )
        }
        // LinearLayoutManager는 일렬로된 매니저
        // GridLayoutManager는 격자로된 매니저

        binding.btnSearch.setOnClickListener{
            index = 1 //인덱스를 초기화함
            query = binding.etSearch.text.toString()
            viewModel.getNewsList(query, index++)

        }


        viewModel.newsListLiveData.observe(this, {
            adapter.submitList(it.toMutableList()) //it은 observe됐을때 가져오는 리스트인데, it을 어댑터에 연결해주겠다는 것. 그러면 알아서 리사이클뷰가 바뀐다.
            // 어댑터 : 뉴스아이템.xml을 액티비티메인.xml로 연결시켜주기 위한 것
            //라이브러리 데이터ㄱㅏ 변경될때마다 observe가 동작한다,,

        })
    }
}