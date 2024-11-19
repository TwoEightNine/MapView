package ovh.plrapps.mapview.core

import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * The tile provider is user-provided to the MapView. It must be supplied as part of the configuration
 * of the MapView.
 *
 * The MapView leverages bitmap pooling to reduce the pressure on the garbage collector. However,
 * there's no tile caching by default - this is an implementation detail of the supplied
 * [TileProvider].
 *
 * If [getTileBitmap] returns null, the tile is simply ignored by the tile processing machinery.
 */
fun interface TileProvider {
    fun getTileBitmap(row: Int, col: Int, zoomLvl: Int, options: BitmapFactory.Options?): Bitmap?
}