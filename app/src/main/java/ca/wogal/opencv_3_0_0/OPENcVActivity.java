package ca.wogal.opencv_3_0_0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.core.Mat;

public class OPENcVActivity extends AppCompatActivity  implements CameraBridgeViewBase.CvCameraViewListener2{

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
    private CameraBridgeViewBase mOpenCvCameraView;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_openc_v );
        test = 0x69;
        m_FramCount = 0;
        //   this.requestWindowFeature( Window.FEATURE_NO_TITLE );
      //  requestWindowFeature( Window.FEATURE_NO_TITLE );
       // getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
      //          WindowManager.LayoutParams.FLAG_FULLSCREEN );
        Log.i(TAG, "called onCreate");
        super.onCreate(savedInstanceState);
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_openc_v);
        mOpenCvCameraView =  findViewById(R.id.HelloOpenCvView);
        mOpenCvCameraView.setVisibility( SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
        Toast.makeText( this, "Im In  OpenCv", Toast.LENGTH_LONG ).show();
        Log.i( TAG, "Hi Wogal heck" );
        // ***************************************************
       /* if (checkSelfPermission( Manifest.permission.CAMERA )
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions( new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE );
            Toast.makeText( this, "I Have Camera Permission ", Toast.LENGTH_LONG ).show();
        }*/






    }

    // overides

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i(TAG, "OpenCV loaded successfully");
                    mOpenCvCameraView.enableView();
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

    @Override
    public void onPause()
    {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }
    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }
    public void onCameraViewStarted(int width, int height) {
    }
    public void onCameraViewStopped() {
    }

    /**
     * This method is invoked when delivery of the frame needs to be done.
     * The returned values - is a modified frame which needs to be displayed on the screen.
     * TODO: pass the parameters specifying the format of the frame (BPP, YUV or RGB and etc)
     *
     * @param inputFrame
     */
    @Override
    public Mat onCameraFrame (CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return null;
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
        return inputFrame.rgba();
    }



}
