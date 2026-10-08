package com.thailandgabilet.app;
import android.app.Activity; import android.os.Bundle; import android.widget.ImageView; import android.graphics.Bitmap; import android.graphics.BitmapFactory; import java.io.InputStream; import java.net.URL;
public class MainActivity extends Activity { @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
    final ImageView imageView = new ImageView(this);
    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    setContentView(imageView);

    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                InputStream is = new URL("https://i.postimg.cc/mD8N0Q2B/gorilla.jpg").openStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(is);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
}
}
