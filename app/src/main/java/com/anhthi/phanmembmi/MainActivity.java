package com.anhthi.phanmembmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtChieuCao, edtCanNang;
    Button btnTinhBMI;
    TextView txtBMI, txtChuanDoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        tinhBMI();
    }

    private void tinhBMI() {
        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(edtChieuCao.getText().toString());
                double W = Double.parseDouble(edtCanNang.getText().toString());
                final double BMI = W / Math.pow(H,2);
                txtBMI.setText(BMI + "");

                if(BMI < 18){
                    txtChuanDoan.setText("Người gầy");
                }else if(BMI >= 18 && BMI <= 24.9){
                    txtChuanDoan.setText("Người bình thường");
                }else if(BMI >= 25 && BMI <= 29.9){
                    txtChuanDoan.setText("Người béo phì cấp độ 1");
                }else if(BMI >= 30 && BMI <= 34.9){
                    txtChuanDoan.setText("Người béo phì cấp độ 2");
                }else {
                    txtChuanDoan.setText("Người béo phì cấp độ 3");
                }
            }
        });
    }

    private void addControl() {
        edtHoTen = findViewById(R.id.editTextHoTen);
        edtChieuCao = findViewById(R.id.editTextChieuCao);
        edtCanNang = findViewById(R.id.editTextCanNang);
        btnTinhBMI = findViewById(R.id.buttonTinhBMI);
        txtBMI = findViewById(R.id.textViewBMI);
        txtChuanDoan = findViewById(R.id.textViewChuanDoan);
    }
}
