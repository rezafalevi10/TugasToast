## **Repositori ini dibuat untuk memenuhi penilaian tengah semester matakuliah pemrograman mobile**  
 Nama  : Mochammad Reza Falevi  
 Nim   : 312210156  
 Kelas : TI.22.B1  
 Mata Kuliah : Pemrograman Mobile  
**Tugas : Membuat tombol yang setiap diklik dapat bertambah angkanya, namun dengan urutan angka fibonacci, lalu lengkapi dengan fitur toast**  
berikut adalah link video aplikasi yang di jalankan (dijalankan pada device menggunakan usb debugging) : [tonton video](https://youtu.be/dRIQgm6WEvU?si=0C3RgLFh_h0zzvij) 
<br>
Source Code:  
* activity_main.Xml (dibuat dengan design pada android studio):
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/kuning"
    >
    <Button
        android:id="@+id/buttonToast"
        android:layout_width="408dp"
        android:layout_height="wrap_content"
        android:text="Tampilkan Toast"
        android:textAlignment="center"
        android:textStyle="bold"
        android:textColor="@color/white"
        android:backgroundTint="@color/Merah"/>

    <LinearLayout
        android:id="@+id/linear"
        android:layout_width="match_parent"
        android:layout_height="400dp"
        android:layout_below="@id/buttonToast"
        android:background="#eeeeee"
        android:gravity="center"
        android:orientation="vertical"
        android:paddingLeft="20dp"
        android:paddingRight="20dp"
        android:backgroundTint="@color/kuning">

        <TextView
            android:id="@+id/textNama"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="0dp"
            android:layout_marginBottom="20dp"
            android:backgroundTint="@color/Merah"
            android:text="REZA BUDGET 312210156"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textCount"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Tombol Hitung diklik sebanyak : 0"
            android:textAlignment="center"
            android:textSize="20sp" />

        <TextView
            android:id="@+id/textCountFibo"
            android:layout_width="375dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="0dp"
            android:layout_marginBottom="-70dp"
            android:text="0"
            android:textAlignment="center"
            android:textColor="#000000"
            android:textSize="180sp"
            android:backgroundTint="@color/kuning"/>

    </LinearLayout>

    <Button
        android:id="@+id/buttonCount"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/linear"
        android:layout_marginStart="1dp"
        android:layout_marginLeft="1dp"
        android:layout_marginTop="3dp"
        android:text="HITUNG"
        android:textAlignment="center"
        android:textStyle="bold" />

    <Button
        android:id="@+id/buttonReset"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/buttonCount"
        android:layout_marginStart="1dp"
        android:layout_marginLeft="1dp"
        android:layout_marginTop="3dp"
        android:text="RESET"
        android:textStyle="bold" />

    <LinearLayout
        android:id="@+id/numberLayout"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_below="@+id/buttonReset"
        android:layout_alignBottom="@+id/buttonMax"
        android:layout_marginTop="-3dp"
        android:layout_marginBottom="1dp"
        android:orientation="horizontal" />

    <Button
        android:id="@+id/buttonMax"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="200dp"
        android:layout_marginTop="550dp"
        android:text="SET MAXIMUM" />

    <EditText
        android:id="@+id/maxNumber"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:layout_marginTop="550dp"
        android:autoText="false"
        android:inputType="numberDecimal"
        android:freezesText="false"
        android:ems="10"
        android:text="0"/>


</RelativeLayout>
```

* MainActivity.java

 ```
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

```
* AndroidManifeast.xml
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.App1"
        tools:targetApi="34">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
* color.xml
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="biru">#0000ff</color>

    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="kuning">#FFFF00</color>
    <color name="hijau">#00ff00</color>
    <color name="merah">#ff0006</color>

</resources>
```

## Ini layoutnya

![Screenshot (![Screenshot (59)](https://github.com/rezafalevi10/TugasToast/assets/116948407/864d2d58-ae4b-445c-8892-853baf62d268)
)


## Dan ini hasilnya
![Screenshot] (![Screenshot (60)](https://github.com/rezafalevi10/TugasToast/assets/116948407/48d36ded-d54d-4a84-8536-a80123269e9d)
)
