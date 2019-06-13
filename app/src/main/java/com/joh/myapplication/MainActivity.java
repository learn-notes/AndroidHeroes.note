package com.joh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Android群英传读书笔记
 *
 * @author : Joh Liu
 * @date : 2019/6/13 10:23
 */
public class MainActivity extends AppCompatActivity {

    Button btnSvg;
    Button btnSysInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSvg = findViewById(R.id.btn_svg);
        btnSysInfo = findViewById(R.id.btn_sys_info);

        btnSvg.setOnClickListener(clickListener);
        btnSysInfo.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_svg:
                    //矢量动画
                    startActivity(new Intent(getApplicationContext(), SvgAnimationActivity.class));
                    break;
                case R.id.btn_sys_info:
                    //系统信息
                    startActivity(new Intent(getApplicationContext(), SystemInfoActivity.class));
                    break;
                default:
                    break;
            }
        }
    };

}
