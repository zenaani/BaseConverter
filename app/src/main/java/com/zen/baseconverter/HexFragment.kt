package com.zen.baseconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_hex.*

class HexFragment : Fragment(R.layout.fragment_hex) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivHZero.setOnClickListener {
            appendOnClick("0")
        }

        ivHOne.setOnClickListener {
            appendOnClick("1")
        }

        ivHTwo.setOnClickListener {
            appendOnClick("2")
        }

        ivHThree.setOnClickListener {
            appendOnClick("3")
        }

        ivHFour.setOnClickListener {
            appendOnClick("4")
        }

        ivHFive.setOnClickListener {
            appendOnClick("5")
        }

        ivHSix.setOnClickListener {
            appendOnClick("6")
        }

        ivHSeven.setOnClickListener {
            appendOnClick("7")
        }

        ivHEight.setOnClickListener {
            appendOnClick("8")
        }

        ivHNine.setOnClickListener {
            appendOnClick("9")
        }

        ivHA.setOnClickListener {
            appendOnClick("A")
        }

        ivHB.setOnClickListener {
            appendOnClick("B")
        }

        ivHC.setOnClickListener {
            appendOnClick("C")
        }

        ivHD.setOnClickListener {
            appendOnClick("D")
        }

        ivHE.setOnClickListener {
            appendOnClick("E")
        }

        ivHF.setOnClickListener {
            appendOnClick("F")
        }

        ivHEqualTo.setOnClickListener {

            val number = (activity as MainActivity).etNumber.text.toString()

            val decimalResult = NumberFormatter.baseToDecimal(16, number)
            (activity as MainActivity).tvDecimal.text = decimalResult

            val binaryResult = NumberFormatter.decimalToBase(decimalResult, 2)
            (activity as MainActivity).tvBinary.text = binaryResult

            val octalResult = NumberFormatter.decimalToBase(decimalResult, 8)
            (activity as MainActivity).tvOctal.text = octalResult

            (activity as MainActivity).tvHexadecimal.text = number

        }
    }

    private fun appendOnClick (string: String) {
        (activity as MainActivity).etNumber.append(string)
    }
}