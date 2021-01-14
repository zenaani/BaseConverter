package com.zen.baseconverter

import kotlin.math.pow

/**
 * Created By Sumit Sharma on 05-01-2021
 **/

object NumberFormatter {

    /**
     * Decimal to any base Converter
     * Used Long here max values generate results. Update code in else tag
    */

    @JvmStatic
    fun decimalToBase(number: String, base: Int): String {
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

    /**
     * Any base to Decimal Converter
     * Used a combination of string and long. Thus Negative numbers doesn't work here i guess, should create a new algorithm after gaining extra knowledge
     */

    @JvmStatic
    fun baseToDecimal (base: Int, number: String): String {
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



    //UnUsed Code
    /**
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


    /**
     * Binary to Decimal Converter
    */
    @JvmStatic
    fun binaryToDecimal(number: Int): Int {
    var n: Int = number
    var decimalNumber = 0.0
    var i = 0
    var lastDigit: Int

    while (n > 0) {
    lastDigit = n % 10
    decimalNumber += (lastDigit * Math.pow(2.toDouble(), i.toDouble()))
    n /= 10
    i += 1
    }

    return decimalNumber.toInt()
    }

    //Convert Decimal System To Other Base System
    @JvmStatic
    fun decimalToAny(number: Int, base: Int): String {
    var n = number
    var baseResult = ""
    var remString: String
    var i = 1

    while (n != 0) {
    remString = (n % base).toString()

    if (base >= 10) {
    when (remString) {
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

    //Convert Other Base System to Decimal System
    @JvmStatic
    fun anyToDecimal(number: Int, base: Int): String {
    var n: Int = number
    var baseResult = 0.0
    var i = 0
    var lastDigit: Int

    while (n > 0) {
    lastDigit = n % 10
    baseResult += (lastDigit * Math.pow(base.toDouble(), i.toDouble()))
    n /= 10
    i += 1
    }

    return baseResult.toString()
    }

     **/
}