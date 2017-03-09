package cn.xwjrfw.p2p.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

/**
 * Fragment基类
 */

public abstract class BaseFragment extends Fragment {

    protected View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        try {
            view = init(inflater);
        } catch (Exception e) {
            e.printStackTrace();
        }

        findView();

        defaultData();

        setListener();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    /**
     * 设置视图初始化
     */
    protected abstract View init(LayoutInflater inflater) throws Exception;

    /** 绑定控件*/
    protected abstract void findView();

    /**设置默认值*/
    protected abstract void defaultData();

    /** 绑定监听事件*/
    protected abstract void setListener();

}