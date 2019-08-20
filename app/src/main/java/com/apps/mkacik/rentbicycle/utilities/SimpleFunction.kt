package com.apps.mkacik.rentbicycle.utilities

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


object SimpleFunction {

    private fun getDateDiff(date1: Date, date2: Date, timeUnit: TimeUnit): Long {
        val diffInMillis = date2.time - date1.time
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS)
    }


    private fun getSecondsLeft(fromDate: String, toDate: String): Long { // dateFormat = "yyyy-MM-dd-HH-mm-SS"
        if (fromDate.isEmpty() || toDate.isEmpty()) return -1

        var DateSplit = fromDate.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val startMonth = Integer.parseInt(DateSplit[1]) - 1 // if month is november  then subtract by 1
        val startYear = Integer.parseInt(DateSplit[0])
        val startDay = Integer.parseInt(DateSplit[2])
        val startHour = Integer.parseInt(DateSplit[3])
        val startMinute = Integer.parseInt(DateSplit[4])
        val startSecond = Integer.parseInt(DateSplit[5])

        DateSplit = toDate.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val endMonth = Integer.parseInt(DateSplit[1]) - 1 // if month is november  then subtract by 1
        val endYear = Integer.parseInt(DateSplit[0])
        val endDay = Integer.parseInt(DateSplit[2])
        val endHour = Integer.parseInt(DateSplit[3])
        val endMinute = Integer.parseInt(DateSplit[4])
        val endSecond = Integer.parseInt(DateSplit[5])

        val now = Calendar.getInstance()
        now.set(startYear, startMonth, startDay, startHour, startMinute, startSecond)


        val end = Calendar.getInstance()
        end.set(endYear, endMonth, endDay, endHour, endMinute, endSecond)


        val time = getDateDiff(now.time, end.time, TimeUnit.SECONDS)
        return if (time != 0L)
            time
        else
            -1
    }


    /**
     * Simple function to return current system date
     * @return String in format YYYY-MM-dd-HH-mm-ss
     */
    fun getCurrentDate(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.GERMAN)
        val cal = Calendar.getInstance()

        return formatter.format(cal.time)
    }

    /**
     * Test function for calculate rent price
     * 1 hour = 10 sec
     */
    fun testCalculatePriceFromDate(fromDate: String, priceForHour: Float): Float {
        val currentDate = getCurrentDate()
        val secondsLeft: Float = getSecondsLeft(fromDate, currentDate).toFloat()
        return (secondsLeft * (priceForHour / 10))
    }

}