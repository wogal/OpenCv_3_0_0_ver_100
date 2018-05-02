package ca.wogal.opencv_3_0_0;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

    // var's
    private static String TAG = "wogals_debug";

    // Used to load the 'native-lib' library on application startup.
 //   static {
  //      System.loadLibrary( "native-lib" );
 //   }


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //     testFunction();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView( R.layout.activity_main );

        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
        //    this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        }

    @Override
    protected void onPause () {
        super.onPause();

    }

    @Override
    protected void onResume () {
        //    Core.fl
        super.onResume();
            }

    @Override
    protected void onDestroy () {
        super.onDestroy();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI ();




}
