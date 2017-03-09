package cn.xwjrfw.p2p.application;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.xwjr.utilcode.utils.AppUtils;
import com.xwjr.utilcode.utils.LogUtils;
import com.xwjr.utilcode.utils.ToastUtils;
import com.xwjr.utilcode.utils.Utils;

import cn.xwjrfw.p2p.R;
import cn.xwjrfw.p2p.broadcast.HasNetReceiver;

/**
 * Created by Administrator on 2017/2/24.
 * app初始化配置
 */

public class MyApplication extends Application {
    /**
     * 判断当前是否有网络
     */
    public static boolean hasNet;


    @Override
    public void onCreate() {
        super.onCreate();
        /**初始化工具类*/
        Utils.init(this);
        /**初始化Log工具类*/
        LogUtils.init(AppUtils.isAppDebug(this), false, 'v', getResources().getString(R.string.xwjr));
        initNet();
    }


    /**
     * 注册网络状态监听广播
     */
    private void initNet() {
        HasNetReceiver receiver = new HasNetReceiver(handler);
        IntentFilter netFilter = new IntentFilter();
        netFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, netFilter);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            Bundle bundle = msg.getData();

            if (bundle != null) {
                boolean isNetConnect = bundle.getBoolean("hasNet");
                if (isNetConnect) {
                    MyApplication.hasNet = true;
                } else {
                    ToastUtils.showShortToast(R.string.error_net_connect);
                    MyApplication.hasNet = false;
                }
            }
        }
    };
}
