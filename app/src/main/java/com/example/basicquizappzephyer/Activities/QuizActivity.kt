package com.example.basicquizappzephyer.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicquizappzephyer.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding:ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list:MutableList<String> =ArrayList();
        list.add("When was first website built")
        list.add("When was first phone invented")
        list.add("When was America founded")
        list.add("When was Universities invented")
        list.add("When was independence day of Pakistan")


        val pairsArray = arrayOf(Methods.pairOne, Methods.pairTwo, Methods.pairThree, Methods.pairFour, Methods.pairFive)



        binding.tvQuestion.text = list[0]
        binding.checkBox.text= pairsArray[0].first
        binding.checkBox2.text=pairsArray[0].second
        var count=1;
        var correctAns=0

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Checkbox1 is selected
                binding.checkBox2.isChecked = false
                if (binding.checkBox.text == Methods.correctOpt[0]) {
                    // Check if the selected option is correct
                    correctAns += 1
                }
            }
        }

        // Set a listener for checkbox2
        binding.checkBox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Checkbox2 is selected
                binding.checkBox.isChecked = false
                if (binding.checkBox2.text == Methods.correctOpt[0]) {
                    // Check if the selected option is correct
                    correctAns += 1
                }
            }
        }

        binding.btnSubmit.setOnClickListener {
            // Check if count is within bounds
            if (count < list.size) {
                // Set up the question
                binding.tvQuestion.text = list[count]
                binding.checkBox.text = pairsArray[count].first
                binding.checkBox2.text = pairsArray[count].second
                val currentCorrectAnswer = Methods.correctOpt[count]


                // Set a listener for checkbox1
                binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        // Checkbox1 is selected
                        binding.checkBox2.isChecked = false
                        if (binding.checkBox.text == currentCorrectAnswer) {
                            // Check if the selected option is correct
                            correctAns += 1
                        }
                    }
                }

                // Set a listener for checkbox2
                binding.checkBox2.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        // Checkbox2 is selected
                        binding.checkBox.isChecked = false
                        if (binding.checkBox2.text == currentCorrectAnswer) {
                            // Check if the selected option is correct
                            correctAns += 1
                        }
                    }
                }

                // Increment count for the next question
                count++
            } else {
                // If all questions are answered, start the result activity
                startActivity(Intent(applicationContext, ResultActivity::class.java))
                val intent=Intent(applicationContext, ResultActivity::class.java)
                intent.putExtra("correctAns",correctAns)
                intent.putExtra("listSize",list.size)
                startActivity(intent)
            }

            // Uncheck checkboxes
            binding.checkBox.isChecked = false
            binding.checkBox2.isChecked = false
        }

    }
}
