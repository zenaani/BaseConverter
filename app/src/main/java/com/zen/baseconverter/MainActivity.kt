package com.zen.baseconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_binary.*
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
        val octalFragment = OctalFragment()
        val hexFragment = HexFragment()

        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()

                when (adapterView?.getItemAtPosition(position).toString()) {

                    "Decimal" -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Shit! You got the decimal logic brah!",
                            Toast.LENGTH_LONG
                        ).show()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, decimalFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    "Binary" -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Hell Yeah! You made it to binary",
                            Toast.LENGTH_LONG
                        ).show()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, binaryFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    "Octal" -> {
                        Toast.makeText(this@MainActivity, "Cool! Its Octal", Toast.LENGTH_LONG)
                            .show()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, octalFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    "Hexadecimal" -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Finally you did it!!!!! Dens Keli",
                            Toast.LENGTH_LONG
                        ).show()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, hexFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    else -> {
                        Toast.makeText(
                            this@MainActivity,
                            "I guess no one's gonna see this",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Do Nothing
            }
        }
    }
}






