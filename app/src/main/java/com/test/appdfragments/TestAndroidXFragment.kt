package com.test.appdfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appdynamics.eumagent.runtime.Instrumentation
import com.appdynamics.eumagent.runtime.SessionFrame
import com.test.appdfragments.databinding.TestAppdFragmentBinding

class TestAndroidXFragment : Fragment() {

    lateinit var sessionFrame: SessionFrame

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewBinding = TestAppdFragmentBinding.inflate(inflater)
        viewBinding.testAppdMonitorText.text = "AndroidX Fragment"
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionFrame = Instrumentation.startSessionFrame("Session Frame - AndroidX")
    }

    override fun onDestroy() {
        super.onDestroy()
        sessionFrame.end()
    }

    companion object {
        fun newInstance() = TestAndroidXFragment()
    }
}