package com.example.lifecycle_logging

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class SimpleContentProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        log("SimpleContentProvider", "onCreate")
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? = null

    override fun getType(uri: Uri): String? = null

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int = 0

}
