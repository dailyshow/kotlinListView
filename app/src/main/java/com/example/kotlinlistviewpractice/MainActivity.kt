package com.example.kotlinlistviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6", "리스트7", "리스트8", "리스트9", "리스트10", "리스트11", "리스트12", "리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6", "리스트7", "리스트8", "리스트9", "리스트10", "리스트11", "리스트12")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 안드로이드에서 제공하는 기본 레이아웃을 적용한 것
//        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        // 내가 만든 레이아웃 적용한 것
        var adapter = ArrayAdapter(this, R.layout.row1, R.id.tv1, data)

        lv.adapter = adapter
//        val listener = ListListener()
//        lv.onItemClickListener = listener

        lv.setOnItemClickListener { parent, view, position, id ->
            tv.text = "${position+1} 번째 선택됨!"
        }
    }

    inner class ListListener: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            tv.text = "${data.get(position)}!"
        }

    }
}
