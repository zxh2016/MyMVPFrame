package cn.xwjrfw.p2p.contract;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import cn.xwjrfw.p2p.base.BasePresenter;
import cn.xwjrfw.p2p.base.BaseView;

/**
 * Created by Administrator on 2017/3/9.
 */

public interface JSNativeContract {
    interface Presenter extends BasePresenter {
        void js2native();

        void native2js(BridgeWebView bridgeWebView);

        void registerMethod(BridgeWebView bridgeWebView);

        void initJSBridge(BridgeWebView bridgeWebView);
    }

    interface View extends BaseView<Presenter> {
        void js2nativeSuccess(String data, CallBackFunction function);

        void native2jsSuccess(String data);
    }
}
