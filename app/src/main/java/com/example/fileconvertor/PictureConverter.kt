package com.example.fileconvertor

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class PictureConverter {

    fun convertPicture(startPath: String) {
        val startFile = File(startPath)

        val inputBitmap =
            BitmapFactory.decodeFile(startFile.absolutePath, BitmapFactory.Options())

        val endPath = "${startFile.parent}/${startFile.nameWithoutExtension}_converted.png"
        val endFile = File(endPath)

        val outputStream: OutputStream = FileOutputStream(endFile)
        inputBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        outputStream.flush()
        outputStream.close()


    }

}