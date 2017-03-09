package cn.xwjrfw.p2p.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.xwjr.utilcode.utils.LogUtils;

import cn.xwjrfw.p2p.R;
import cn.xwjrfw.p2p.activity.SecondActivity;
import cn.xwjrfw.p2p.base.BaseFragment;
import cn.xwjrfw.p2p.contract.LoginContract;
import cn.xwjrfw.p2p.presenter.LoginPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment implements LoginContract.View {
    private LoginPresenter loginPresenter;
    private EditText editText;

    @Override
    protected View init(LayoutInflater inflater) throws Exception {
        loginPresenter = new LoginPresenter(this);
        return View.inflate(getActivity(), R.layout.fragment_first, null);
    }

    @Override
    protected void findView() {
        editText = (EditText) view.findViewById(R.id.editText_userName);
        view.findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SecondActivity.class));
            }
        });


        view.findViewById(R.id.button_test_mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginPresenter.login(editText.getText().toString());
            }
        });
    }

    @Override
    protected void defaultData() {

    }

    @Override
    protected void setListener() {

    }


    @Override
    public void loginSuccess() {
        LogUtils.i("登录成功");
    }

    @Override
    public void loginFail() {
        LogUtils.i("登录失败");
    }
}
