package com.test.appdfragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.appdfragments.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivitySecondBinding.inflate(layoutInflater)

        when(intent.getSerializableExtra(PARAM_TYPE) as TestType){
            TestType.AndroidXFragment -> showAndroidXFragment()
            TestType.DeprecatedFragment -> showDeprecatedFragment()
        }
        setContentView(viewBinding.root)
    }

    private fun showAndroidXFragment() {
        val fragment: TestAndroidXFragment = TestAndroidXFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.master_fragment_placeholder,
                fragment,
                "TestFragment"
            )
            .commit()
    }

    private fun showDeprecatedFragment() {
        val fragment: TestLegacyFragment = TestLegacyFragment.newInstance()
        fragmentManager.beginTransaction()
            .replace(
                R.id.master_fragment_placeholder,
                fragment,
                "TestFragment"
            ).commit()
    }

    companion object {
        private const val PARAM_TYPE = "PARAM_TYPE"
        fun startActivity(context: Context, testType: TestType){
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(PARAM_TYPE, testType)
            }
            context.startActivity(intent)
        }
    }
}

enum class TestType {
    AndroidXFragment, DeprecatedFragment
}