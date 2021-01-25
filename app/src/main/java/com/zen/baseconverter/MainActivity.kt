package com.zen.baseconverter

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.animate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_binary.*


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
         *
         * tvDecimal.animate().apply {
                duration = 1000
                alpha(0.5f)
                translationXBy(200f)
            }

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

                (view as TextView).apply {
                    setTextColor(Color.WHITE)
                }

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

                        clearAllValues()


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

                        clearAllValues()

                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, binaryFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    "Octal" -> {
                        Toast.makeText(this@MainActivity, "Cool! Its Octal", Toast.LENGTH_LONG)
                            .show()

                        clearAllValues()

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

                        clearAllValues()

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

    fun clearAllValues () {
        etNumber.text = ""
        tvDecimal.text = ""
        tvBinary.text = ""
        tvOctal.text = ""
        tvHexadecimal.text = ""
    }


}






