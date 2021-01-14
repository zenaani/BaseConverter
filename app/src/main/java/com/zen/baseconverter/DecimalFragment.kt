package com.zen.baseconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_decimal.*


class DecimalFragment : Fragment(R.layout.fragment_decimal) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivZero.setOnClickListener {
            appendOnClick("0")
        }

        ivOne.setOnClickListener {
            appendOnClick("1")
        }

        ivTwo.setOnClickListener {
            appendOnClick("2")
        }

        ivThree.setOnClickListener {
            appendOnClick("3")
        }

        ivFour.setOnClickListener {
            appendOnClick("4")
        }

        ivFive.setOnClickListener {
            appendOnClick("5")
        }

        ivSix.setOnClickListener {
            appendOnClick("6")
        }

        ivSeven.setOnClickListener {
            appendOnClick("7")
        }

        ivEight.setOnClickListener {
            appendOnClick("8")
        }

        ivNine.setOnClickListener {
            appendOnClick("9")
        }

        ivEqualTo.setOnClickListener {

            val number = etNumber.text.toString()

            (activity as MainActivity).tvDecimal.text = number

            val binaryResult = NumberFormatter.decimalToBase(number, 2)
            (activity as MainActivity).tvBinary.text = binaryResult

            val octalResult = NumberFormatter.decimalToBase(number, 8)
            (activity as MainActivity).tvOctal.text = octalResult

            val hexResult = NumberFormatter.decimalToBase(number, 16)
            (activity as MainActivity).tvHexadecimal.text = hexResult

        }
    }

    private fun appendOnClick (string: String) {
        (activity as MainActivity).etNumber.append(string)
    }

}
