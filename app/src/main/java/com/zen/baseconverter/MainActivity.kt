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

        val decimalFragment = DecimalFragment()
        val binaryFragment = BinaryFragment()

        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()

                when (adapterView?.getItemAtPosition(position).toString()) {

                    "Decimal" -> {
                        Toast.makeText(this@MainActivity, "Shit! You got the decimal logic brah!", Toast.LENGTH_LONG).show()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, decimalFragment)
                            addToBackStack(null)
                            commit()
                        }

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            tvDecimal.text = number

                            val binaryResult = NumberFormatter.decimalToBase(number, 2)
                            tvBinary.text = binaryResult

                            val octalResult = NumberFormatter.decimalToBase(number, 8)
                            tvOctal.text = octalResult

                            val hexResult = NumberFormatter.decimalToBase(number, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Binary" -> {
                        Toast.makeText(this@MainActivity, "Hell Yeah! You made it to binary", Toast.LENGTH_LONG).show()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, binaryFragment)
                            addToBackStack(null)
                            commit()
                        }

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            val decimalResult = NumberFormatter.baseToDecimal(2, number)
                            tvDecimal.text = decimalResult

                            tvBinary.text = number

                            val octalResult = NumberFormatter.decimalToBase(decimalResult, 8)
                            tvOctal.text = octalResult

                            val hexResult = NumberFormatter.decimalToBase(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Octal" -> {
                        Toast.makeText(this@MainActivity, "Cool! Its Octal", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            val decimalResult = NumberFormatter.baseToDecimal(8, number)
                            tvDecimal.text = decimalResult

                            val binaryResult = NumberFormatter.decimalToBase(decimalResult, 2)
                            tvBinary.text = binaryResult

                            tvOctal.text = number

                            val hexResult = NumberFormatter.decimalToBase(decimalResult, 16)
                            tvHexadecimal.text = hexResult
                        }

                    }
                    "Hexadecimal" -> {
                        Toast.makeText(this@MainActivity, "Finally you did it!!!!! Dens Keli", Toast.LENGTH_LONG).show()

                        btnConvert.setOnClickListener {
                            val number = etNumber.text.toString()

                            val decimalResult = NumberFormatter.baseToDecimal(16, number)
                            tvDecimal.text = decimalResult

                            val binaryResult = NumberFormatter.decimalToBase(decimalResult, 2)
                            tvBinary.text = binaryResult

                            val octalResult = NumberFormatter.decimalToBase(decimalResult, 8)
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
    }

    /**
    private fun clear () {
        etNumber.text = ""
    }
    **/
}






