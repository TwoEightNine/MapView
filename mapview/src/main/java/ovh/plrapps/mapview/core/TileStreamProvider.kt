package ovh.plrapps.mapview.core

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream

/**
 * [InputStream]-base copy of [TileProvider]
 */
fun interface TileStreamProvider : TileProvider {
    fun getTileStream(row: Int, col: Int, zoomLvl: Int): InputStream?

    override fun getTileBitmap(row: Int, col: Int, zoomLvl: Int, options: BitmapFactory.Options?): Bitmap? {
        val i = getTileStream(row, col, zoomLvl)
        return i.use { BitmapFactory.decodeStream(i, null, options) }
    }
}