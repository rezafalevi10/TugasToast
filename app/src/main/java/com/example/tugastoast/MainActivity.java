package com.example.tugastoast;

import android.annotation.SuppressLint;
import android.support.v4.app.RemoteActionCompatParcelizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugastoast.R;

public class MainActivity extends AppCompatActivity {
    public int count = 0;
    public int countFibo = 0;
    public int maxFibo = 0;
    public TextView showCount;
    public TextView showCountFibo;
    public TextView showMaxFibo;
    public EditText maxNumber;
    public Button buttonToast;
    public Button buttonCount;
    public Button buttonReset;
    public Toast toastA;
    public Button buttonmax;
    public int[] warna;
    public LinearLayout layout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_activity);
        buttonToast = (Button) findViewById(R.id.buttonToast);
        buttonCount = (Button) findViewById(R.id.buttonCount);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        showCount = (TextView) findViewById(R.id.textCount);
        showCountFibo = (TextView) findViewById(R.id.textCountFibo);
        buttonmax = (Button) findViewById(R.id.buttonMax);
        maxNumber = (EditText) findViewById(R.id.maxNumber);
        layout = (LinearLayout) findViewById(R.id.linear);


        buttonmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNumber = maxNumber.getText().toString();
                maxFibo = Integer.parseInt(getNumber);
                showMaxFibo.setText(getNumber);
                if (toastA !=null) {toastA.cancel(); }
                toastA = Toast.makeText(getApplicationContext(), "Angka Maximum fibonacci diubah menjadi " + getNumber,Toast.LENGTH_SHORT);
                toastA.show();
            }
        });


        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toastA != null) {
                    toastA.cancel();
                }
                toastA = Toast.makeText(getApplicationContext(), "Angka Fibonacci : " + countFibo, Toast.LENGTH_SHORT);
                toastA.show();
            }
        });

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(view);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(view);
            }
        });


    }

    protected void calculate(View view) {

        count++;
        countFibo = calculateFibo(count);
        showCount.setText("Tombol Hitung diklik sebanyak : " + Integer.toString(count));
        showCountFibo.setText(Integer.toString(countFibo));
        if (count % 2 == 0) {
            if (toastA != null) toastA.cancel();
            toastA = Toast.makeText(getApplicationContext(), "Tombol hitung diklik : " + count + " Kali", Toast.LENGTH_SHORT);
            toastA.show();
            showCountFibo.setTextColor(Color.RED);
        } else {
            showCountFibo.setTextColor(Color.BLUE);
            }
    }

    protected int calculateFibo(int n) {
        if (n <= 1) return n;
        int prev, current, next;
        prev = 0;
        current = 1;
        for (int i = 2; i <= n; i++) {
            next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    protected void reset(View view) {
        count = 0;
        countFibo = 0;
        showCount.setText("Tombol Hitung diklik sebanyak : " + Integer.toString(count));
        showCountFibo.setText(Integer.toString(countFibo));
        layout.setBackgroundColor(Color.GREEN);
    }
}
