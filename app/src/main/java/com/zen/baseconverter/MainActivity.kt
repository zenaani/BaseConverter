package com.zen.baseconverter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zen.baseconverter.NumberFormatter.binaryToDecimal
import com.zen.baseconverter.NumberFormatter.decimalToAny
import com.zen.baseconverter.NumberFormatter.hexToDecimal
import com.zen.baseconverter.NumberFormatter.octalToDecimal
import com.zen.baseconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val DECIMAL = "Decimal"
        const val BINARY = "Binary"
        const val OCTAL = "Octal"
        const val HEXADECIMAL = "Hexadecimal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /***
        Update Code compatible for negative numbers
        1s - 2s complement
        Take binary as a string. Strip(1..4) -> change to hex -> change to deccimal
         ***/

        //Logical Error in Decimal to Hexadecimal Conversion - Fixed
        //Binary Diff Value when > 10.000 - Fixed
        //HexToDecimal - Add ABCDEF

        binding.spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                toast("You selected ${adapterView?.getItemAtPosition(position).toString()}")
                when (adapterView?.getItemAtPosition(position).toString()) {
                    DECIMAL -> {
                        toast("Shit! You got the decimal logic brah!")
                        binding.btnConvert.setOnClickListener { printResult(DECIMAL) }
                    }
                    BINARY -> {
                        toast("Hell Yeah! You made it to binary")
                        binding.btnConvert.setOnClickListener { printResult(BINARY) }

                    }
                    OCTAL -> {
                        toast("Cool! Its Octal")
                        binding.btnConvert.setOnClickListener { printResult(OCTAL) }

                    }
                    HEXADECIMAL -> {
                        toast("Finally you did it!!!!! Dens Keli")
                        binding.btnConvert.setOnClickListener { printResult(HEXADECIMAL) }

                    }
                    else -> {
                        toast("I guess no one's gonna see this")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    fun printResult(callerType: String) {
        val number = binding.etNumber.text.toString().toInt()
        when (callerType) {
            DECIMAL -> {
                binding.apply {
                    tvDecimal.text = number.toString()
                    tvBinary.text = decimalToAny(number, 2)
                    tvOctal.text = decimalToAny(number, 8)
                    tvHexadecimal.text = decimalToAny(number, 16)
                }
            }
            BINARY -> {
                binding.apply {
                    val decimalResult = binaryToDecimal(number)
                    tvDecimal.text = decimalResult.toString()
                    tvBinary.text = number.toString()
                    tvOctal.text = decimalToAny(decimalResult, 8)
                    tvHexadecimal.text = decimalToAny(decimalResult, 16)
                }
            }
            OCTAL -> {
                binding.apply {
                    val decimalResult = octalToDecimal(number)
                    tvDecimal.text = decimalResult.toString()
                    tvBinary.text = decimalToAny(decimalResult, 2)
                    tvOctal.text = decimalToAny(decimalResult, 8)
                    tvHexadecimal.text = decimalToAny(decimalResult, 16)
                }
            }
            HEXADECIMAL -> {
                binding.apply {
                    val decimalResult = hexToDecimal(number)
                    tvHexadecimal.text = decimalResult.toString()
                    tvBinary.text = decimalToAny(decimalResult, 2)
                    tvOctal.text = decimalToAny(decimalResult, 8)
                    tvHexadecimal.text = decimalToAny(decimalResult, 16)
                }
            }
        }
    }
}

fun Context.toast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

