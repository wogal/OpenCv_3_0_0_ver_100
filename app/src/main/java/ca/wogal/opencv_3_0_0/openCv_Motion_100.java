package ca.wogal.opencv_3_0_0;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.InstallCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;


public class openCv_Motion_100 extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    // var's
    private static String TAG = "wogals_debug";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary( "native-lib" );
    }

    public int test_ans = 0;
    private Mat mat1, mat2, mat3;
    private int test;
    private CameraBridgeViewBase cameraBridgeViewBase;
    private BaseLoaderCallback baseLoaderCallback;
    private int mCameraId = 0; //add this one
    private int m_FramCount = 0;
    private boolean test_bool_force_return;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        test = 0x69;
        m_FramCount = 0;
        //   this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView( R.layout.open_cv_layout );

        Log.i( TAG, "Hi Wogal heck" );


        if (checkSelfPermission( Manifest.permission.CAMERA )
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions( new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE );
        }

        //     testFunction();
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        //    this.requestWindowFeature( Window.FEATURE_NO_TITLE );


        if (true) {
            cameraBridgeViewBase = findViewById( R.id.myCameraView );
            // cam code
            cameraBridgeViewBase.setVisibility( SurfaceView.VISIBLE );
            cameraBridgeViewBase.setCvCameraViewListener( this );

            baseLoaderCallback = new BaseLoaderCallback( this ) {

                @Override
                public void onManagerConnected (int status) {

                    switch (status) {
                        case BaseLoaderCallback.SUCCESS: {

                            openCv_Motion_100.Opencv_100 aa;

                            test_class.test( 11 );


                            //    ca.wogal.opencv_3_0_0.openCv_Motion_100.Opencv_100.
                            swapCamera();
                            cameraBridgeViewBase.enableView();
                            break;
                        }
                        default:
                            super.onManagerConnected( status );
                    }
                }

                @Override
                public void onPackageInstall (int operation, InstallCallbackInterface callback) {
                    super.onPackageInstall( operation, callback );
                }
            };

        }

        Log.i( TAG, "Hi Wogal" );
        Log.i( TAG, "Hi Wogal 1" );
        Log.i( TAG, "Hi Wogal 2" );
        Log.i( TAG, "Hi Wogal 3" );
        Log.i( TAG, "Hi Wogal 5" );
        Log.i( TAG, "Hi Wogal 4" );

        test++;

    }


    @Override
    public void onRequestPermissionsResult (int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult( requestCode, permissions, grantResults );
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText( this, "camera permission granted", Toast.LENGTH_LONG ).show();
            } else {
                Toast.makeText( this, "camera permission denied", Toast.LENGTH_LONG ).show();
            }
        }
    }


    @Override
    protected void onPause () {
        super.onPause();
        if (cameraBridgeViewBase != null) {
            cameraBridgeViewBase.disableView();
        }
    }

    @Override
    protected void onResume () {

        //    Core.fl


        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Toast.makeText( this, "**  OpenCv NOT Working ,,,**", Toast.LENGTH_LONG ).show();
        } else {
            baseLoaderCallback.onManagerConnected( BaseLoaderCallback.SUCCESS );
        }


    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        if (cameraBridgeViewBase != null) {
            cameraBridgeViewBase.disableView();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI ();

    /**
     * This method is invoked when camera preview has started. After this method is invoked
     * the frames will start to be delivered to client via the onCameraFrame() callback.
     *
     * @param width  -  the width of the frames that will be delivered
     * @param height - the height of the frames that will be delivered
     */
    @Override
    public void onCameraViewStarted (int width, int height) {
        mat1 = new Mat( width, height, CvType.CV_8UC4 );
        mat2 = new Mat( width, height, CvType.CV_8UC4 );
        mat3 = new Mat( width, height, CvType.CV_8UC4 );
    }

    /**
     * This method is invoked when camera preview has been stopped for some reason.
     * No frames will be delivered via onCameraFrame() callback after this method is called.
     */
    @Override
    public void onCameraViewStopped () {
        mat1.release();
        mat2.release();
        mat3.release();
    }

    /**
     * This method is invoked when delivery of the frame needs to be done.
     * The returned values - is a modified frame which needs to be displayed on the screen.
     * TODO: pass the parameters specifying the format of the frame (BPP, YUV or RGB and etc)
     * ++
     *
     * @param inputFrame
     */
    @Override
    public Mat onCameraFrame (CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        // inc frame count
        m_FramCount++;
        mat1 = inputFrame.rgba();
        String str1;
        Scalar debugColor;

        debugColor = new Scalar( 0, 0, 255 );
        Rect rect = new Rect( 10, 10, 500, 500 );// = Rect();
        test_bool_force_return = true;
        str1 = "";

        if (test_bool_force_return == true) {
            if (true && m_FramCount > 100) {
                try {
                    Imgproc.cvtColor( mat1, mat1, Imgproc.COLOR_BGR2GRAY );
                    str1 = " " + m_FramCount;
                } catch (Exception ee) {

                    str1 = ee.getMessage();
                    str1 += " Error ";
                }
            }
        }

        Imgproc.rectangle( mat1, new Point( rect.x, rect.y ), new Point( rect.x + rect.width, rect.y + rect.height ), debugColor, 5 );

        debugColor = new Scalar( 100, 200, 150 );
        rect = new Rect( 100, 100, 300, 300 );// = Rect();

        Imgproc.circle( mat1, new Point( 1000, 250 ), 250, debugColor, 10, 8, 0 );


        str1 = String.format( "Window Width %d Height %d   ", mat1.width(), mat1.height() );

        Imgproc.putText( mat1, str1, new Point( 2, 600 ), 1, 1, new Scalar( 0, 0, 255 ) );


        return mat1;
    }

    private void testFunction () {


        if (!true) {
            VideoCapture cap = new VideoCapture();
            cap.open( 0 );
            if (!cap.isOpened()) {
                Toast.makeText( this, "No Cam", Toast.LENGTH_LONG ).show();
            }
        } else {
        }
    }

    private void swapCamera () {
        mCameraId = mCameraId ^ 1; //bitwise not operation to flip 1 to 0 and vice versa
        cameraBridgeViewBase.disableView();
        cameraBridgeViewBase.setCameraIndex( mCameraId );
        cameraBridgeViewBase.enableView();
    }


    public static class Opencv_100 {
        public int test_funcyion (int a) {
            return (a + 10);
        }
    }
}
