package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private EditText A;
    private EditText B;
    private EditText C;
    private Button bt;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.Answer);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);

        bt = findViewById(R.id.button);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        double a, b, c;
        a = Double.parseDouble(A.getText().toString());
        b = Double.parseDouble(B.getText().toString());
        c = Double.parseDouble(C.getText().toString());
        tv.setText(square_equastion(a, b, c));
        Log.d("f", "" + a);
        Log.d("f", "" + b);
        Log.d("f", "" + c);
    }

    @SuppressLint("DefaultLocale")
    private String square_equastion(double a, double b, double c) {
        double Dis = Math.pow(b, 2) - 4 * a * c;

        if (Dis > 0) {
            double x1 = (-b + Math.sqrt(Dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(Dis)) / (2 * a);
            return String.format("X1 = %f; X2 = %f", x1, x2);
        } else if (Dis == 0) {
            double x = -b / (2 * a);
            return "X = " + x;
        } else {
            return "Нет решений";
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("val", counter);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        int counter = bundle.getInt("val");

    }
}