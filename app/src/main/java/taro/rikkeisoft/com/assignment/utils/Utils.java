package taro.rikkeisoft.com.assignment.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.GravityCompat;
import android.util.LruCache;

import java.text.SimpleDateFormat;
import java.util.List;

import taro.rikkeisoft.com.assignment.model.Note;

/**
 * Created by VjrutNAT on 10/16/2017.
 */

public class Utils {

    public static android.support.v4.util.LruCache<String, Bitmap> BITMAP_CACHE = new android.support.v4.util.LruCache(4194304);
    public static android.support.v4.util.LruCache<String, Bitmap> BITMAP_LARGE_CACHE = new android.support.v4.util.LruCache(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
    public static List<Note> cacheNote;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
    public static SimpleDateFormat fullDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat normalDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    public static SimpleDateFormat pictureNameDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public static SimpleDateFormat shortDateFormat = new SimpleDateFormat("dd/MM HH:mm");

    public static Bitmap getScaleBitmap(String mCurrentPhotoPath, int width, int height) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int scaleFactor = Math.min(bmOptions.outWidth / width, bmOptions.outHeight / height);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;
        return BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
    }
}
