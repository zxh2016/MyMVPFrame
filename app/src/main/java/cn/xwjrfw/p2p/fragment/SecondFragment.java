package cn.xwjrfw.p2p.fragment;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import cn.xwjrfw.p2p.R;
import cn.xwjrfw.p2p.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment {


    @Override
    protected View init(LayoutInflater inflater) throws Exception {
        return View.inflate(getActivity(), R.layout.fragment_second, null);
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void defaultData() {

    }

    @Override
    protected void setListener() {

    }

}
