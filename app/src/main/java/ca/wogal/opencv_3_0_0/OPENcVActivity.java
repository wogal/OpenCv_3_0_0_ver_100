package ca.wogal.opencv_3_0_0;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class OPENcVActivity extends AppCompatActivity {

    private static final int MY_CAMERA_REQUEST_CODE = 100;
    // var's
    private static String TAG = "wogals_debug";
    public int test_ans = 0;
    private Mat mat1, mat2, mat3;
    private int test;
    private CameraBridgeViewBase cameraBridgeViewBase;
    private BaseLoaderCallback baseLoaderCallback;
    private int mCameraId = 0; //add this one
    private int m_FramCount = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_openc_v );
        test = 0x69;
        m_FramCount = 0;
        //   this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView( R.layout.activity_main );

        Log.i( TAG, "Hi Wogal heck" );


        if (checkSelfPermission( Manifest.permission.CAMERA )
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions( new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE );
        }

        //     testFunction();
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        //    this.requestWindowFeature( Window.FEATURE_NO_TITLE );


        if (!true) {
            VideoCapture cap = new VideoCapture();
            cap.open( 0 );
            if (!cap.isOpened()) {
                Toast.makeText( this, "No Cam", Toast.LENGTH_LONG ).show();
            } else {
                cameraBridgeViewBase = findViewById( R.id.myCameraView );
                // cam code
                cameraBridgeViewBase.setVisibility( SurfaceView.VISIBLE );
                //      cameraBridgeViewBase.setCvCameraViewListener( this );
            }
        }


        Log.i( TAG, "Hi Wogal" );
        Log.i( TAG, "Hi Wogal 1" );
        Log.i( TAG, "Hi Wogal 2" );
        Log.i( TAG, "Hi Wogal 3" );
        Log.i( TAG, "Hi Wogal 5" );
        Log.i( TAG, "Hi Wogal 4" );

        test++;
    }


}
