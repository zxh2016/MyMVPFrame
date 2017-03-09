package cn.xwjrfw.p2p.contract;

import cn.xwjrfw.p2p.base.BasePresenter;
import cn.xwjrfw.p2p.base.BaseView;

/**
 * Created by Administrator on 2017/3/7.
 */

public interface LoginContract {

    interface Presenter extends BasePresenter {
        void login(String userName);
    }

    interface View extends BaseView<Presenter> {
        void loginSuccess();

        void loginFail();
    }
}
