package cn.xwjrfw.p2p.base;

/**
 * Created by zxh
 * Activity基类
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;
import com.xwjr.utilcode.utils.BarUtils;
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarColor();


        init();

        findView();

        defaultData();

        setListener();
    }

    /**
     * 根据不同的Activity修改状态栏颜色
     */
    private void setStatusBarColor() {
        String clazzName = getClass().getSimpleName();
        switch (clazzName){
            case "MainActivity":
                BarUtils.setColor(this, Color.GREEN);
                break;
            case "SecondActivity":
                BarUtils.setColor(this,Color.YELLOW);
                break;
            default:
                break;
        }
    }






    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**设置视图初始化*/
    protected abstract void init();

    /** 绑定控件*/
    protected abstract void findView();

    /**设置默认值*/
    protected abstract void defaultData();

    /** 绑定监听事件*/
    protected abstract void setListener();


}
