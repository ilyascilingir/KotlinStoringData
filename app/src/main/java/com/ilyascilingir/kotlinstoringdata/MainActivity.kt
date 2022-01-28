package com.ilyascilingir.kotlinstoringdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ilyascilingir.kotlinstoringdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.ilyascilingir.kotlinstoringdata",
            MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",0)

        if (ageFromPreferences == 0  ) {
            binding.ageOutput.setText("Your Age: ")
        }else{
            binding.ageOutput.setText("Your Age: $ageFromPreferences")
        }

    }

    fun save (view : View) {

        val ageInput = binding.ageInput.text.toString().toIntOrNull()

        if (ageInput != null) {
            binding.ageOutput.setText("Age : " + ageInput)
            sharedPreferences.edit().putInt("age",ageInput).apply()
        }
    }

    fun delete (view : View) {

        ageFromPreferences = sharedPreferences.getInt("age",0)

        if (ageFromPreferences != 0) {
            sharedPreferences.edit().remove("age").apply()
            binding.ageOutput.setText("Your Age: ")
        }

    }

}