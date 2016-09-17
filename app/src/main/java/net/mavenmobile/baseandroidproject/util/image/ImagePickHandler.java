package net.mavenmobile.baseandroidproject.util.image;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Eric Cardova on 14-Jun-16.
 */
public class ImagePickHandler {
    static String TAG = "ImagePickHandler";

    public static void handleCameraResult(ImageView imageView) {

    }

    public static Uri getPhotoUri(Context context) {
        File photo = null;
        try {
            // place where to store camera taken picture
            photo = createTemporaryFile("picture", ".jpg");
            photo.delete();
            return Uri.fromFile(photo);
        } catch (Exception e) {
            Log.v(TAG, "Can't create file to take picture!");
            Toast.makeText(context, "Please check SD card! Image shot is impossible!", Toast.LENGTH_LONG).show();
        }

        return null;
    }

    private static File createTemporaryFile(String part, String ext) throws Exception {
        File tempDir = Environment.getExternalStorageDirectory();
        tempDir = new File(tempDir.getAbsolutePath() + "/.temp/");
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
        return File.createTempFile(part, ext, tempDir);
    }
}
