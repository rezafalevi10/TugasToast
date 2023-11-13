package com.example.tugastoast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySatu extends AppCompatActivity {
    Button button_toast, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_toast = (Button) findViewById(R.id.button_toast);
        button4 = (Button) findViewById(R.id.button4);

        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Buka = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Buka);
            }
        });
    }
}
