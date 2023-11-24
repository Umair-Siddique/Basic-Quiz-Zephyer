package com.example.basicquizappzephyer.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicquizappzephyer.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

val intent=intent
        val correctAns=intent.getIntExtra("correctAns",0)
        val totalQuestions=intent.getIntExtra("listSize",0)

        binding.tvScore.text="  $correctAns / $totalQuestions"
    }
}