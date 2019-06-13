package com.joh.myapplication.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.joh.myapplication.R;

/**
 * 绘图处理
 *
 * @author : Joh Liu
 * @date : 2019/6/13 13:11
 */
public class DrawActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;

    ImageView mImageView;
    SeekBar seek1;
    SeekBar seek2;
    SeekBar seek3;

    Bitmap bitmap;
    /**
     * 色调\饱和度\亮度
     */
    private float mHue = -1.42f;
    private float mStauration = 1f;
    private float mLum = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        mImageView = findViewById(R.id.image);
        seek1 = findViewById(R.id.seek1);
        seek2 = findViewById(R.id.seek2);
        seek3 = findViewById(R.id.seek3);

        bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.img);

        seek1.setMax(MAX_VALUE);
        seek1.setProgress(MID_VALUE);
        seek2.setMax(MAX_VALUE);
        seek2.setProgress(MID_VALUE);
        seek3.setMax(MAX_VALUE);
        seek3.setProgress(MID_VALUE);

        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
        seek3.setOnSeekBarChangeListener(this);

        mImageView.setImageBitmap(bitmap);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seek1:
                mHue = (progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                break;
            case R.id.seek2:
                mStauration = progress * 1.0F / MID_VALUE;
                break;
            case R.id.seek3:
                mLum = progress * 1.0F / MID_VALUE;
                break;
            default:
                break;
        }

        Log.e("数据", "mHue=" + mHue + ";mStauration=" + mStauration + ";mLum=" + mLum);
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(
                bitmap, mHue, mStauration, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
