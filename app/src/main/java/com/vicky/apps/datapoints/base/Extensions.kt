package com.vicky.apps.datapoints.base

import android.os.Build
import androidx.annotation.RequiresApi
import com.vicky.apps.datapoints.ui.model.Issue
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun String.formatDate(unstructuredDate: String): String   {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
   // val formatted = current.format(formatter)
    return ""
}

sealed class ResultType
class Success(): ResultType()
class Error(val message: String): ResultType()