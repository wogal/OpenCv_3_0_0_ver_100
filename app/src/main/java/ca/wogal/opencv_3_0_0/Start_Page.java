package ca.wogal.opencv_3_0_0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Start_Page extends AppCompatActivity implements View.OnClickListener {
    private Button mButOpenCv;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start__page );
        mButOpenCv = findViewById( R.id.But_OpenCvPage );
        mButOpenCv.setOnClickListener( this );


    }

    @Override
    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.But_OpenCvPage: {
                Toast.makeText( this, "Got Req oPenCv Click", Toast.LENGTH_LONG ).show();
                Intent intent = new Intent( Start_Page.this, MainActivity_100.class );
                startActivity( intent );
                break;
            }
        }
    }
}
