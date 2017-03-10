package cn.xwjrfw.p2p.presenter;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import cn.xwjrfw.p2p.contract.JSNativeContract;

/**
 * Created by Administrator on 2017/3/9.
 */

public class JSNativePresenter implements JSNativeContract.Presenter {

    private JSNativeContract.View view;

    public JSNativePresenter(JSNativeContract.View view) {
        this.view = view;
    }

    @Override
    public void js2native() {
    }

    @Override
    public void native2js(BridgeWebView bridgeWebView) {
        bridgeWebView.callHandler("setName", "324", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                view.native2jsSuccess(data);
            }
        });
    }

    @Override
    public void registerMethod(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                view.js2nativeSuccess(data, function);
            }
        });
    }

    @Override
    public void initJSBridge(BridgeWebView bridgeWebView) {
        bridgeWebView.loadUrl("file:///android_asset/demo.html");
    }
}
