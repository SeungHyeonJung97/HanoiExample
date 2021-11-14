package com.example.hanoiexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hanoiexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val arraylist: ArrayList<String> = ArrayList()
    private val adapter = HanoiAdapter(arraylist);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this@MainActivity

        binding.hanoiResult.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.hanoiResult.setHasFixedSize(true)
    }

    private fun hanoi(num: Int, from: Char, by: Char, to: Char) {
        if(num == 1){
            arraylist.add(String.format(resources.getString(R.string.hanoi_format),num,from,to))
            binding.hanoiResult.adapter = adapter
        }else{
            hanoi(num-1, from, to, by)
            arraylist.add(String.format(resources.getString(R.string.hanoi_format),num,from,to))
            hanoi(num-1, by, from, to)
        }
        Log.d(""+num,"번째 hanoi 실행");
    }

    fun onClear(view: View){
        arraylist.clear()
        adapter.notifyDataSetChanged()
    }

    fun hanoiStart(view: View){
        if(binding.etValue.text.isNotEmpty()){
            hanoi(Integer.parseInt(binding.etValue.text.toString()), 'A', 'B', 'C');
            binding.etValue.setText("")
        }else{
            Toast.makeText(this, "값을 입력해주세요 !", Toast.LENGTH_SHORT).show()
        }
    }
}