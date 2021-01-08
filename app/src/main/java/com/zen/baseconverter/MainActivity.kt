package com.zen.baseconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Logical Error in Decimal to Hexadecimal Conversion - Fixed
         * Binary Diff Value when > 10.000 - Fixed
         * HexToDecimal - Add ABCDEF - Fixed
         * Can't take Large Binary Numbers as input - Not Fixed (Took Long and used Strings to append)

         * Not Compatible for negative numbers - Not Fixed (Should try 1s and 2s complement)
         * New algo for negative nos in decimalToBase 2s complement (Mainly for baseToDecimal since it crashes

         **/

        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()

                when (adapterView?.getItemAtPosition(position).toString()) {

                    "Decimal" -> {
                        Toast.makeText(this@MainActivity, "Shit! You got the decimal logic brah!", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            tvDecimal.text = number

                            val binaryResult = decimalToBase(number, 2)
                            tvBinary.text = binaryResult

                            val octalResult = decimalToBase(number, 8)
                            tvOctal.text = octalResult

                            val hexResult = decimalToBase(number, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Binary" -> {
                        Toast.makeText(this@MainActivity, "Hell Yeah! You made it to binary", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            val decimalResult = baseToDecimal(2, number)
                            tvDecimal.text = decimalResult

                            tvBinary.text = number

                            val octalResult = decimalToBase(decimalResult, 8)
                            tvOctal.text = octalResult

                            val hexResult = decimalToBase(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Octal" -> {
                        Toast.makeText(this@MainActivity, "Cool! Its Octal", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            val decimalResult = baseToDecimal(8, number)
                            tvDecimal.text = decimalResult

                            val binaryResult = decimalToBase(decimalResult, 2)
                            tvBinary.text = binaryResult

                            tvOctal.text = number

                            val hexResult = decimalToBase(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Hexadecimal" -> {
                        Toast.makeText(this@MainActivity, "Finally you did it!!!!! Dens Keli", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            val decimalResult = baseToDecimal(16, number)
                            tvDecimal.text = decimalResult

                            val binaryResult = decimalToBase(decimalResult, 2)
                            tvBinary.text = binaryResult

                            val octalResult = decimalToBase(decimalResult, 8)
                            tvOctal.text = octalResult

                            tvHexadecimal.text = number
                        }
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "I guess no one's gonna see this", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Do Nothing
            }
        }

        val decimalFragment = DecimalFragment()
        val binaryFragment = BinaryFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, decimalFragment)
            commit()
        }

        btnDecimal.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, decimalFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnBinary.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, binaryFragment)
                addToBackStack(null)
                commit()
            }
        }









    }

    /**
    private fun clear () {
        etNumber.text = ""
    }
    **/

    //Convert Decimal System To Other Base System
    /***
    Used Long here max values generate results. Update code in else tag
     ***/
    private fun decimalToBase(number: String, base: Int): String {
        var n = number.toLong()
        var i: Int = 1

        var baseResultString: String = ""
        var remString: String = ""

        var baseResult: Long = 0L
        var remainder: Long = 0L

        var result: String =""

        while (n != 0L) {

            if (n > 0) {
                remString = (n % base).toString()
                when (remString) {
                    "10" -> remString = "A"
                    "11" -> remString = "B"
                    "12" -> remString = "C"
                    "13" -> remString = "D"
                    "14" -> remString = "E"
                    "15" -> remString = "F"
                }

                n /= base
                baseResultString += remString
                i *= 10

                result = baseResultString.reversed()
            } else {

                remainder = n % base
                n /= base
                baseResult += (remainder * i)
                i *= 10

                result = baseResult.toString()
            }
        }

        return result
    }

    /***
     * Used a combination of string and long. Thus Negative numbers doesn't work here i guess, should create a new algorithm after gaining extra knowledge
     ***/

    private fun baseToDecimal (base: Int, number: String): String {
        var n: String = number
        var lastChar: String = ""
        var lastDigit: Int = 0
        var baseResult: Double = 0.0
        var i: Int = 0

        for (x in 1..(n.length)) {
            lastChar = n.takeLast(1)
            n = n.dropLast(1)

            when (lastChar) {
                "A" -> lastChar = "10"
                "B" -> lastChar = "11"
                "C" -> lastChar = "12"
                "D" -> lastChar = "13"
                "E" -> lastChar = "14"
                "F" -> lastChar = "15"
            }

            lastDigit = lastChar.toInt()
            baseResult += (lastDigit * base.toDouble().pow(i.toDouble()))
            i += 1
        }

        return baseResult.toInt().toString()
    }
}






