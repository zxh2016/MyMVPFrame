package cn.xwjrfw.p2p.activity;

import android.view.View;
import android.widget.Button;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.xwjr.utilcode.utils.ToastUtils;

import cn.xwjrfw.p2p.R;
import cn.xwjrfw.p2p.base.BaseActivity;
import cn.xwjrfw.p2p.contract.JSNativeContract;
import cn.xwjrfw.p2p.presenter.JSNativePresenter;

public class SecondActivity extends BaseActivity implements JSNativeContract.View {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private BridgeWebView bridgeWebView;
    private JSNativePresenter jsNativePresenter;


    @Override
    protected void init() {
        setContentView(R.layout.activity_second);
        jsNativePresenter = new JSNativePresenter(this);
    }

    @Override
    protected void findView() {
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        bridgeWebView = (BridgeWebView) findViewById(R.id.bridgeWebView);
    }

    @Override
    protected void defaultData() {
        jsNativePresenter.initJSBridge(bridgeWebView);
        jsNativePresenter.registerMethod(bridgeWebView);
    }

    @Override
    protected void setListener() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsNativePresenter.native2js(bridgeWebView);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void js2nativeSuccess(String data, CallBackFunction function) {
        ToastUtils.showShortToast(data);
        function.onCallBack("let'seee");
    }

    @Override
    public void native2jsSuccess(String data) {
        ToastUtils.showShortToast(data);

    }
}
