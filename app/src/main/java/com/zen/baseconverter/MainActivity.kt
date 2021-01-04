package com.zen.baseconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Logical Error in Decimal to Hexadecimal Conversion - Fixed
         * Binary Diff Value when > 10.000 - Fixed
         * HexToDecimal - Add ABCDEF - Not Fixed

         * Not Compatible for negative numbers - Not Fixed (Should try 1s and 2s complement)
         * Can't take Large Binary Numbers as input - Not Fixed (Try Converting to Long)
         **/

        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()

                when (adapterView?.getItemAtPosition(position).toString()) {

                    "Decimal" -> {
                        Toast.makeText(this@MainActivity, "Shit! You got the decimal logic brah!", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString().toInt()

                            val decimalResult = number
                            tvDecimal.text = decimalResult.toString()

                            val binaryResult = decimalToAny(number, 2)
                            tvBinary.text = binaryResult

                            val octalResult = decimalToAny(number, 8)
                            tvOctal.text = octalResult

                            val hexResult = decimalToAny(number, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Binary" -> {
                        Toast.makeText(this@MainActivity, "Hell Yeah! You made it to binary", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString().toInt()

                            val decimalResult = binaryToDecimal(number)
                            tvDecimal.text = decimalResult.toString()

                            val binaryResult = number
                            tvBinary.text = binaryResult.toString()

                            val octalResult = decimalToAny(decimalResult, 8)
                            tvOctal.text = octalResult

                            val hexResult = decimalToAny(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Octal" -> {
                        Toast.makeText(this@MainActivity, "Cool! Its Octal", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString().toInt()

                            val decimalResult = octalToDecimal(number)
                            tvDecimal.text = decimalResult.toString()

                            val binaryResult = decimalToAny(decimalResult, 2)
                            tvBinary.text = binaryResult

                            val octalResult = decimalToAny(decimalResult, 8)
                            tvOctal.text = octalResult

                            val hexResult = decimalToAny(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Hexadecimal" -> {
                        Toast.makeText(this@MainActivity, "Finally you did it!!!!! Dens Keli", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString().toInt()

                            val decimalResult = hexToDecimal(number)
                            tvHexadecimal.text = decimalResult.toString()

                            val binaryResult = decimalToAny(decimalResult, 2)
                            tvBinary.text = binaryResult

                            val octalResult = decimalToAny(decimalResult, 8)
                            tvOctal.text = octalResult

                            val hexResult = decimalToAny(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "I guess no one's gonna see this", Toast.LENGTH_LONG).show()
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}

//Convert Decimal System To Other Base System
private fun decimalToAny(number: Int, base: Int): String {
    var n = number
    var baseResult: String = ""
    var remString: String = ""
    var i: Int = 1

    while (n != 0) {
        remString = (n % base).toString()

        if(base > 10) {
            when(remString) {
                "10" -> remString = "A"
                "11" -> remString = "B"
                "12" -> remString = "C"
                "13" -> remString = "D"
                "14" -> remString = "E"
                "15" -> remString = "F"
            }
        }

        n /= base
        baseResult += remString
        i *= 10
    }
    return baseResult.reversed()
}

private fun binaryToDecimal(number: Int): Int {
    var n: Int = number
    var decimalNumber: Double = 0.0
    var i: Int = 0
    var lastDigit: Int = 0

    while (n > 0) {
        lastDigit = n % 10
        decimalNumber += (lastDigit * 2.toDouble().pow(i.toDouble()))
        n /= 10
        i += 1
    }
    return decimalNumber.toInt()
}


private fun octalToDecimal(number: Int): Int {
    var n: Int = number
    var decimalNumber: Double = 0.0
    var i: Int = 0
    var lastDigit: Int = 0

    while (n > 0) {
        lastDigit = n % 10
        decimalNumber += (lastDigit * 8.toDouble().pow(i.toDouble()))
        n /= 10
        i += 1
    }
    return decimalNumber.toInt()
}

private fun hexToDecimal(number: Int): Int {
    var n: Int = number
    var decimalNumber: Double = 0.0
    var i: Int = 0
    var lastDigit: Int = 0

    while (n > 0) {
        lastDigit = n % 10
        decimalNumber += (lastDigit * 16.toDouble().pow(i.toDouble()))
        n /= 10
        i += 1
    }
    return decimalNumber.toInt()
}


