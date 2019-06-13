# 读书笔记之Android群英传

标签（空格分隔）： 读书笔记

---

书的确是一本好书。不过书的写作背景是Android5.0发布的时候，所以有些知识我们现在实际开发过程中已经很少用到，故只对一部分知识点做记录。

###  绘图机制与处理技巧
书籍第六章节的内容，现在市面上的Android书籍很少对Android的绘图和图像处理相关知识做详细介绍，故详细记录。

##### 1 单位转换
	绘图前首先需要了解图像各单位间的转换，即dp2px，px2dp，sp2px，px2sp

```java
public class DisplayUtils {

    /**
     * dp转px
     *
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     *
     * @param pxValue
     * @return
     */
    public static int px2dp(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
}
```

##### 2 图片处理
对图片处理可以从三个角度：色调、饱和度、亮度 处理。Android提供的方法：
```java
ColorMatrix hueMatrix = new ColorMatrix();
        //色调（红绿蓝）
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        //饱和度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        //亮度
        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);
```

###  矢量动画
矢量动画主要通过<path>标签来规定图形轨迹
(M x,y) 坐标位置点
(L x,y)  画直线到指定位置
(H x) 画水平线到x坐标
(V y) 画垂直线到y坐标
(A rx,ry,xrotation,flag1,flag2,x,y) 弧线

```
    <!--画一条红色直线-->
    <path
        android:name="l_line1"
        android:pathData="
                        M 20,20
                        L 50,20 80,20"
        android:strokeWidth="5"
        android:strokeColor="@android:color/holo_red_dark"
        android:strokeLineCap="round" />
```

###  获取系统信息
```
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

	/**
     * 获取system信息
     */
    private String getSysProperty(String os) {
        return System.getProperty(os);
    }
```
