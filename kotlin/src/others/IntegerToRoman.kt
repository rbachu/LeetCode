/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Matthew Lee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/*
 * https://leetcode.com/problems/integer-to-roman/
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I            1
 * V            5
 * X            10
 * L            50
 * C            100
 * D            500
 * M            1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 *
 * There are six instances where subtraction is used:
 * 1. I can be placed before V (5) and X (10) to make 4 and 9.
 * 2. X can be placed before L (50) and C (100) to make 40 and 90.
 * 3. C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

package others

class IntegerToRoman {
    private fun roman(num: Int): String {
        return when(num) {
            1    -> "I"
            4    -> "IV"
            5    -> "V"
            9    -> "IX"
            10   -> "X"
            40   -> "XL"
            50   -> "L"
            90   -> "XC"
            100  -> "C"
            400  -> "CD"
            500  -> "D"
            900  -> "CM"
            1000 -> "M"
            else -> ""
        }
    }

    fun intToRoman(num: Int): String {
        var input = num
        var roman = roman(input)
        if (roman.isNotEmpty()) {
            return roman
        }

        while (input - 1000 >= 0) {
            input -= 1000
            roman += roman(1000)
        }

        if (input - 900 >= 0) {
            input -= 900
            roman += roman(900)
        }

        if (input - 500 >= 0) {
            input -= 500
            roman += roman(500)
        }

        if (input - 400 >= 0) {
            input -= 400
            roman += roman(400)
        }

        while (input - 100 >= 0) {
            input -= 100
            roman += roman(100)
        }

        if (input - 90 >= 0) {
            input -= 90
            roman += roman(90)
        }

        if (input - 50 >= 0) {
            input -= 50
            roman += roman(50)
        }

        if (input - 40 >= 0) {
            input -= 40
            roman += roman(40)
        }

        while (input - 10 >= 0) {
            input -= 10
            roman += roman(10)
        }

        if (input - 9 >= 0) {
            input -= 9
            roman += roman(9)
        }

        if (input - 5 >= 0) {
            input -= 5
            roman += roman(5)
        }

        if (input - 4 >= 0) {
            input -= 4
            roman += roman(4)
        }

        while (input - 1 >= 0) {
            input -= 1
            roman += roman(1)
        }

        return roman
    }
}
