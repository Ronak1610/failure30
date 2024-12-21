package com.example.failure30.core

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import com.example.failure30.domain.model.Response
import com.example.failure30.domain.model.Response.Failure
import com.example.failure30.domain.model.Response.Success


const val TAG = "AppTag"
const val BOOK_TABLE = "book_table"
fun printError(e: Exception) = Log.e(TAG, "${e.message}")


fun showToastMessage(
    context: Context,
    resourceId: Int
) = makeText(context, context.resources.getString(resourceId), LENGTH_LONG).show()


suspend fun <T> launchCatching(block: suspend () -> T) = try {
    Success(block())
} catch (e: Exception) {
    Failure(e)
}