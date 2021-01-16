package com.zen.baseconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_decimal.*
import kotlinx.android.synthetic.main.fragment_octal.*

class OctalFragment : Fragment(R.layout.fragment_octal) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivOZero.setOnClickListener {
            appendOnClick("0")
        }

        ivOOne.setOnClickListener {
            appendOnClick("1")
        }

        ivOTwo.setOnClickListener {
            appendOnClick("2")
        }

        ivOThree.setOnClickListener {
            appendOnClick("3")
        }

        ivOFour.setOnClickListener {
            appendOnClick("4")
        }

        ivOFive.setOnClickListener {
            appendOnClick("5")
        }

        ivOSix.setOnClickListener {
            appendOnClick("6")
        }

        ivOSeven.setOnClickListener {
            appendOnClick("7")
        }

        ivOEqualTo.setOnClickListener {

            val number = (activity as MainActivity).etNumber.text.toString()

            val decimalResult = NumberFormatter.baseToDecimal(8, number)
            (activity as MainActivity).tvDecimal.text = decimalResult

            val binaryResult = NumberFormatter.decimalToBase(decimalResult, 2)
            (activity as MainActivity).tvBinary.text = binaryResult

            (activity as MainActivity).tvOctal.text = number

            val hexResult = NumberFormatter.decimalToBase(decimalResult, 16)
            (activity as MainActivity).tvHexadecimal.text = hexResult

        }
    }

    private fun appendOnClick (string: String) {
        (activity as MainActivity).etNumber.append(string)
    }
}