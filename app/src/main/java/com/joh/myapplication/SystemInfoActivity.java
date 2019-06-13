package com.joh.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * 获取系统信息
 *
 * @author : Joh Liu
 * @date : 2019/6/13 10:04
 */
public class SystemInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);

        TextView text = findViewById(R.id.text);

        /**
         * 获取Android 系统信息
         */
        //主板
        String board = Build.BOARD;
        //Android系统定制商
        String brand = Build.BRAND;
        //CPU指令集
        String[] abis = Build.SUPPORTED_ABIS;
        //设备参数
        String device = Build.DEVICE;
        //显示屏参数
        String display = Build.DISPLAY;
        //唯一编号
        String fingerprint = Build.FINGERPRINT;
        //硬件制造商
        String manufacturer = Build.MANUFACTURER;
        //硬件名
        String handware = Build.HARDWARE;
        //手机产品名
        String product = Build.PRODUCT;
        //修订版本列表
        String id = Build.ID;
        //版本
        String model = Build.MODEL;
        //标签名
        String tags = Build.TAGS;
        //Builder类型
        String type = Build.TYPE;
        //当前开发代号
        String codeName = Build.VERSION.CODENAME;
        //源码控制版本号
        String incremental = Build.VERSION.INCREMENTAL;
        //Android版本
        String release = Build.VERSION.RELEASE;
        //SDK版本号
        int sdkInt = Build.VERSION.SDK_INT;
        //host
        String host = Build.HOST;
        //user
        String user = Build.USER;
        //时间
        long time = Build.TIME;


        //OS版本
        String osVersion = getSysProperty("os.version");
        //OS名称
        String osName = getSysProperty("os.name");
        //OS架构
        String osarch = getSysProperty("os.arch");


        text.setText("主板：" + board + "\n"
                + "系统定制商：" + brand + "\n"
                + "CPU指令集：" + abis + "\n"
                + "设备参数：" + device + "\n"
                + "显示屏参数：" + display + "\n"
                + "唯一编号：" + fingerprint + "\n"
                + "硬件制造商：" + manufacturer + "\n"
                + "硬件名：" + handware + "\n"
                + "手机产品名：" + product + "\n"
                + "修订版本列表：" + id + "\n"
                + "版本：" + model + "\n"
                + "标签名：" + tags + "\n"
                + "Builder类型：" + type + "\n"
                + "当前开发代号：" + codeName + "\n"
                + "源码控制版本号：" + incremental + "\n"
                + "Android版本：" + release + "\n"
                + "SDK版本号：" + sdkInt + "\n"
                + "host：" + host + "\n"
                + "user：" + user + "\n"
                + "时间：" + time + "\n"
                + "OS版本：" + osVersion + "\n"
                + "OS名称：" + osName + "\n"
                + "OS架构：" + osarch + "\n"


        );
    }

    /**
     * 获取system信息
     */
    private String getSysProperty(String os) {
        return System.getProperty(os);
    }
}
