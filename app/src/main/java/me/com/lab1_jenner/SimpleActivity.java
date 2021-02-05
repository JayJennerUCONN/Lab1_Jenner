package me.com.lab1_jenner;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import android.util.Log;
import android.widget.Button;

public class SimpleActivity extends AppCompatActivity {
    private final String s_create = "ON_CREATE";
    private final String s_start = "ON_START";
    private final String s_resume = "ON_RESUME";
    private final String s_pause = "ON_PAUSE";
    private final String s_stop = "ON_STOP";
    private final String s_destroy = "ON_DESTROY";
    private final String s_button = "BUTTON_PRESSED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(s_create, "started onCreate: Non-existant -> Stopped");
        setContentView(R.layout.activity_simple);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button destroy_button = findViewById(R.id.destroy_button);
        destroy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(s_button,"pressed DestroyApp: invoke finish()");
                finish();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        }
    @Override
    public void onStart() {
        super.onStart();
        Log.i(s_start," Stopped -> Paused");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(s_resume," Paused -> Resumed");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i(s_pause," Resumed -> Paused");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i(s_stop," Paused -> Stopped");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(s_destroy," Stopped -> Non-existant");
    }
}