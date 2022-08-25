package com.test.appdfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.appdfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)

        viewBinding.buttonShowAndroidx.setOnClickListener {
            SecondActivity.startActivity(this, TestType.AndroidXFragment)
        }

        viewBinding.buttonShowDeprecated.setOnClickListener {
            SecondActivity.startActivity(this, TestType.DeprecatedFragment)
        }
        setContentView(viewBinding.root)
    }
}