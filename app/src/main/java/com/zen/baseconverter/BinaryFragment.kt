package com.zen.baseconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_binary.*
import kotlinx.android.synthetic.main.fragment_decimal.*


class BinaryFragment : Fragment(R.layout.fragment_binary) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivBZero.setOnClickListener {
            appendOnClick("0")
        }

        ivBOne.setOnClickListener {
            appendOnClick("1")
        }

        ivBEqualTo.setOnClickListener {

            val number = (activity as MainActivity).etNumber.text.toString()

            val decimalResult = NumberFormatter.baseToDecimal(2, number)
            (activity as MainActivity).tvDecimal.text = decimalResult

            (activity as MainActivity).tvBinary.text = number

            val octalResult = NumberFormatter.decimalToBase(decimalResult, 8)
            (activity as MainActivity).tvOctal.text = octalResult

            val hexResult = NumberFormatter.decimalToBase(decimalResult, 16)
            (activity as MainActivity).tvHexadecimal.text = hexResult
        }

       // ivBClear.setOnClickListener {
     //       (activity as MainActivity).etNumber.text = "0"
      //  }
    }

    private fun appendOnClick (string: String) {
        (activity as MainActivity).etNumber.append(string)
    }

}