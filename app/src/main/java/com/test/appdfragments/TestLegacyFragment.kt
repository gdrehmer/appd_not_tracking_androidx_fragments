package com.test.appdfragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appdynamics.eumagent.runtime.Instrumentation
import com.appdynamics.eumagent.runtime.SessionFrame
import com.test.appdfragments.databinding.TestAppdFragmentBinding


class TestLegacyFragment : Fragment() {

    lateinit var sessionFrame: SessionFrame

    @Deprecated("Deprecated in Java")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewBinding = TestAppdFragmentBinding.inflate(inflater)
        viewBinding.testAppdMonitorText.text = "Legacy Fragment"
        return viewBinding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionFrame =
            Instrumentation.startSessionFrame("Session Frame - Deprecated/Legacy Fragment")

    }

    @Deprecated("Deprecated in Java")
    override fun onDestroy() {
        super.onDestroy()
        sessionFrame.end()
    }

    companion object {
        fun newInstance() = TestLegacyFragment()
    }

}