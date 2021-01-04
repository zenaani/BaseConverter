package com.zen.baseconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /***
            Update Code compatible for negative numbers
            1s - 2s complement
         ***/

        //Logical Error in Decimal to Hexadecimal Conversion - Fixed
        //Binary Diff Value when > 10.000

        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()

                if (adapterView?.getItemAtPosition(position).toString() == "Decimal") {
                    Toast.makeText(this@MainActivity, "Shit! You got the decimal logic brah!", Toast.LENGTH_LONG).show()

                    btnConvert.setOnClickListener {
                        val number = etNumber.text.toString().toInt()

                        val decimalResult = number
                        tvDecimal.text = decimalResult.toString()

                        val binaryResult = decimalToBinary(number)
                        tvBinary.text = binaryResult.toString()

                        val octalResult = decimalToOctal(number)
                        tvOctal.text = octalResult.toString()

                        val hexResult = decimalToHex(number)
                        tvHexadecimal.text = hexResult
                    }

                } else if (adapterView?.getItemAtPosition(position).toString() == "Binary") {
                    Toast.makeText(this@MainActivity, "Hell Yeah! You made it to binary", Toast.LENGTH_LONG).show()

                    btnConvert.setOnClickListener {
                        val number = etNumber.text.toString().toInt()

                        val decimalResult = binaryToDecimal(number)
                        tvDecimal.text = decimalResult.toString()

                        val binaryResult = number
                        tvBinary.text = binaryResult.toString()

                        val octalResult = decimalToOctal(decimalResult)
                        tvOctal.text = octalResult.toString()

                        val hexResult = decimalToHex(decimalResult)
                        tvHexadecimal.text = hexResult.toString()
                    }

                } else if (adapterView?.getItemAtPosition(position).toString() == "Octal") {
                    Toast.makeText(this@MainActivity, "Cool! Its Octal", Toast.LENGTH_LONG).show()

                    btnConvert.setOnClickListener {
                        val number = etNumber.text.toString().toInt()

                        val decimalResult = octalToDecimal(number)
                        tvDecimal.text = decimalResult.toString()

                        val binaryResult = decimalToBinary(decimalResult)
                        tvBinary.text = binaryResult.toString()

                        val octalResult = decimalToOctal(decimalResult)
                        tvOctal.text = octalResult.toString()

                        val hexResult = decimalToHex(decimalResult)
                        tvHexadecimal.text = hexResult.toString()
                    }

                } else if (adapterView?.getItemAtPosition(position).toString() == "Hexadecimal") {
                    Toast.makeText(this@MainActivity, "Finally you did it!!!!! Dens Keli", Toast.LENGTH_LONG).show()

                    btnConvert.setOnClickListener {
                        val number = etNumber.text.toString().toInt()

                        val decimalResult = hexToDecimal(number)
                        tvHexadecimal.text = decimalResult.toString()

                        val binaryResult = decimalToBinary(decimalResult)
                        tvBinary.text = binaryResult.toString()

                        val octalResult = decimalToOctal(decimalResult)
                        tvOctal.text = octalResult.toString()

                        val hexResult = decimalToHex(decimalResult)
                        tvHexadecimal.text = hexResult.toString()
                    }

                } else {
                    Toast.makeText(this@MainActivity, "I guess no one's gonna see this", Toast.LENGTH_LONG).show()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        /***

        btnConvert.setOnClickListener {
            val number = etNumber.text.toString().toInt()

            val decimal = number
            tvDecimal.text = decimal.toString()

            val binaryResult = decimalToBinary(number)
            tvBinary.text = binaryResult.toString()

            val octalResult = decimalToOctal(number)
            tvOctal.text = octalResult.toString()

            val hexResult = decimalToHex(number)
            tvHexadecimal.text = hexResult
        }

        ***/

    }

    }

    //Convert Decimal System To Other Base System

    private fun decimalToBinary(number: Int): Long {
        var n = number
        var binaryNumber: Long = 0
        var remainder: Int
        var i: Int = 1

        while (n != 0) {
            remainder = n % 2
            n /= 2
            binaryNumber += (remainder * i).toLong()
            i *= 10
        }

        return binaryNumber
    }


    private fun decimalToOctal(number: Int): Long {
        var n = number
        var octalNumber: Long = 0
        var remainder: Int
        var i: Int = 1

        while (n != 0) {
            remainder = n % 8
            n /= 8
            octalNumber += (remainder * i).toLong()
            i *= 10
        }

        return octalNumber
    }

    private fun decimalToHex(number: Int): String {
        var n = number
        var hexNumber: String = ""
        var remString: String = ""
        var i: Int = 0

        while (n !=0) {
            remString = (n % 16).toString()

            when (remString) {
                "10" -> remString = "A"
                "11" -> remString = "B"
                "12" -> remString = "C"
                "13" -> remString = "D"
                "14" -> remString = "E"
                "15" -> remString = "F"
            }

            n /= 16
            hexNumber += remString
            i *= 10
        }

        return hexNumber.reversed()
    }


    //Convert Other Base System to Decimal System

    private fun binaryToDecimal(number: Int): Int {
        var n: Int = number
        var decimalNumber: Double = 0.0
        var i: Int = 0
        var lastDigit: Int = 0

        while (n > 0) {
            lastDigit = n % 10
            decimalNumber += (lastDigit * Math.pow(2.toDouble() , i.toDouble()) )
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
            decimalNumber += (lastDigit * Math.pow(8.toDouble(), i.toDouble()))
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
            decimalNumber += (lastDigit * Math.pow(16.toDouble(), i.toDouble()))
            n /= 10
            i += 1
        }

        return decimalNumber.toInt()
    }

