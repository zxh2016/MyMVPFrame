package cn.xwjrfw.p2p.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.xwjr.utilcode.utils.LogUtils;
import com.xwjr.utilcode.utils.NetworkUtils;

/**
 * 网络状态广播接受器
 * 检测网络状态
 */

public class HasNetReceiver extends BroadcastReceiver {
    private Handler handler;

    public HasNetReceiver(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try {

            Message message = new Message();
            /**没有网络*/
            if (!NetworkUtils.isAvailableByPing()) {
                if (handler != null) {
                    Bundle data = new Bundle();
                    data.putBoolean("hasNet", false);
                    message.setData(data);
                    handler.sendMessage(message);
                }
            } else {
                if (handler != null) {
                    Bundle data = new Bundle();
                    data.putBoolean("hasNet", true);
                    message.setData(data);
                    handler.sendMessage(message);
                }
            }
        } catch (SecurityException e) {
            // TODO: handle exception
            LogUtils.e(e);
        }
    }
}
