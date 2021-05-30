package iamutkarshtiwari.github.io.ananas.editimage;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**Root Project: Ananas
 * This class is created by Puskal For saving bitmap , returing path and also getting bitmap from path
 */
public class MyBitmapHelper {

    public static String BITMAP_IMAGE_DIR="beta_puskal_dir_751";
    public static String BITMAP_IMAGE_NAME="img_puskal_edt_1m2.jpg";

    public static String saveBitmapToInternal(Bitmap bitmap, Context context) {
        ContextWrapper contextWrapper = new ContextWrapper(context);
        File directory = contextWrapper.getDir(BITMAP_IMAGE_DIR, Context.MODE_PRIVATE);
        File file = new File(directory, BITMAP_IMAGE_NAME);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
        }
        finally {
            try {
                fos.close();
            } catch (Exception e) {

            }
        }
        return  directory.getAbsolutePath();

    }

    public static Bitmap getBitmapFromPath(String filePath) {
        File f=new File(filePath,BITMAP_IMAGE_NAME);
        Bitmap bitMap;
        try {
            bitMap = BitmapFactory.decodeStream(new FileInputStream(f));

            return bitMap;

        } catch (Exception e) {
            return null;
        }
    }
}
