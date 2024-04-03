package com.example.week4_assignment;

import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox check1, check2;
    RadioGroup rGroup1, rGroup2;
    RadioButton[] r = new RadioButton[3];
    ImageView imageView;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        for(int i = 0; i < 3; i++)
            r[i] = (RadioButton) findViewById(R.id.rMem1 + i);

        //체크박스 설정
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check1.setChecked(false);
                    r[0].setText("정국");
                    r[1].setText("지민");
                    r[2].setText("태형");
                    for(int i = 0; i < 3; i++) //라디오버튼 초기화
                        r[i].setChecked(false);
                    flag = 0;
                }
            }
        });

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check2.setChecked(false);
                    r[0].setText("나연");
                    r[1].setText("정연");
                    r[2].setText("사나");
                    for(int i = 0; i < 3; i++) //라디오버튼 초기화
                        r[i].setChecked(false);
                    flag = 1;
                }
            }
        });

        //라디오버튼에 따른 이미지 사이즈 변경
        imageView = (ImageView) findViewById(R.id.imageView);
        rGroup2 = (RadioGroup) findViewById(R.id.rgroup2);
        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rSize1)
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                else if(checkedId == R.id.rSize2) {
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    Matrix matrix = imageView.getImageMatrix();
                    float scale = 2.0f;
                    matrix.setScale(scale, scale);
                    imageView.setImageMatrix(matrix);
                }

                else if(checkedId == R.id.rSize3)
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                else
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
            }
        });

        //라디오버튼에 따른 이미지 변경
        rGroup1 = (RadioGroup) findViewById(R.id.rgroup1);
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rMem1)
                    if(flag == 0) { //트와이스=0, 방탄=1
                        imageView.setImageResource(R.drawable.junguk);
                    }
                    else
                        imageView.setImageResource(R.drawable.nayeon);

                else if(checkedId == R.id.rMem2)
                    if(flag == 0)
                        imageView.setImageResource(R.drawable.jimin);
                    else
                        imageView.setImageResource(R.drawable.jeongyeon);

                else
                    if(flag == 0)
                        imageView.setImageResource(R.drawable.taehyung);
                    else
                        imageView.setImageResource(R.drawable.sana);
            }
        });
    }
}