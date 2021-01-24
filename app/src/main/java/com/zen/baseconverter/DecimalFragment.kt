package com.zen.baseconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_decimal.*


class DecimalFragment : Fragment(R.layout.fragment_decimal) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivDZero.setOnClickListener {
            appendOnClick("0")
        }

        ivDOne.setOnClickListener {
            appendOnClick("1")
        }

        ivDTwo.setOnClickListener {
            appendOnClick("2")
        }

        ivDThree.setOnClickListener {
            appendOnClick("3")
        }

        ivDFour.setOnClickListener {
            appendOnClick("4")
        }

        ivDFive.setOnClickListener {
            appendOnClick("5")
        }

        ivDSix.setOnClickListener {
            appendOnClick("6")
        }

        ivDSeven.setOnClickListener {
            appendOnClick("7")
        }

        ivDEight.setOnClickListener {
            appendOnClick("8")
        }

        ivDNine.setOnClickListener {
            appendOnClick("9")
        }

        ivDEqualTo.setOnClickListener {

            val number = (activity as MainActivity).etNumber.text.toString()

            (activity as MainActivity).tvDecimal.text = number

            val binaryResult = NumberFormatter.decimalToBase(number, 2)
            (activity as MainActivity).tvBinary.text = binaryResult

            val octalResult = NumberFormatter.decimalToBase(number, 8)
            (activity as MainActivity).tvOctal.text = octalResult

            val hexResult = NumberFormatter.decimalToBase(number, 16)
            (activity as MainActivity).tvHexadecimal.text = hexResult

        }

        ivDClear.setOnClickListener {
            (activity as MainActivity).etNumber.text = ""
        }
    }

    private fun appendOnClick (string: String) {
        (activity as MainActivity).etNumber.append(string)
    }
}
