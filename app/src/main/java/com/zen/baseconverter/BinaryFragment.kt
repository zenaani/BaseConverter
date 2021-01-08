package com.zen.baseconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_binary.*
import kotlinx.android.synthetic.main.fragment_decimal.*

/**
 * A simple [Fragment] subclass.
 */
class BinaryFragment : Fragment(R.layout.fragment_binary) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivbZero.setOnClickListener {
            appendOnClick("0")
        }

        ivbOne.setOnClickListener {
            appendOnClick("1")
        }
    }

    private fun appendOnClick (string: String) {
        etNumber.append(string)
    }


}