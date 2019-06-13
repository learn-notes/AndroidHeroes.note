package com.joh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.joh.myapplication.draw.DrawActivity;
import com.joh.myapplication.svg.SvgAnimationActivity;
import com.joh.myapplication.system.SystemInfoActivity;

/**
 * Android群英传读书笔记
 *
 * @author : Joh Liu
 * @date : 2019/6/13 10:23
 */
public class MainActivity extends AppCompatActivity {

    Button btnDraw;
    Button btnSvg;
    Button btnSysInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDraw = findViewById(R.id.btn_draw);
        btnSvg = findViewById(R.id.btn_svg);
        btnSysInfo = findViewById(R.id.btn_sys_info);

        btnDraw.setOnClickListener(clickListener);
        btnSvg.setOnClickListener(clickListener);
        btnSysInfo.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_draw:
                    //绘图处理
                    startActivity(new Intent(getApplicationContext(), DrawActivity.class));
                    break;
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
