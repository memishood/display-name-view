package com.emrememis.displaynameview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.emrememis.library.DisplayNameView;

/**
 * @author emre.memis.49@gmail.com
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayNameView displayNameView = findViewById(R.id.display_name_view);
        // start the animation
        displayNameView.startAnim();
        // stop the animation
        displayNameView.stopAnim();
    }
}