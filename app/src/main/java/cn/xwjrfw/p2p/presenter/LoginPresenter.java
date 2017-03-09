package cn.xwjrfw.p2p.presenter;

import android.text.TextUtils;

import cn.xwjrfw.p2p.contract.LoginContract;

/**
 * Created by Administrator on 2017/3/7.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(String userName) {
        if (!TextUtils.isEmpty(userName)) {
            view.loginSuccess();
        } else {
            view.loginFail();
        }
    }
}
