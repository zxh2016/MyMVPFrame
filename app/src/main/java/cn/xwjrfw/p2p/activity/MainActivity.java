package cn.xwjrfw.p2p.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.xwjrfw.p2p.R;
import cn.xwjrfw.p2p.base.BaseActivity;
import cn.xwjrfw.p2p.fragment.FirstFragment;
import cn.xwjrfw.p2p.fragment.SecondFragment;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class MainActivity extends BaseActivity {

    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> fragmentList;
    private FragmentManager fragmentManager;

    @Override
    protected void init() {
        fragmentList = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
    }

    @Override
    protected void defaultData() {
        setBottomNavigationBar();
        setFragmentList();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fragment_enter_alpha, R.anim.fragment_exit_alpha)
                .replace(R.id.frame_layout, fragmentList.get(0))
                .commit();
    }


    @Override
    protected void setListener() {

        /**设置底部导航栏监听*/
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int i) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.fragment_enter_alpha, R.anim.fragment_exit_alpha)
                        .replace(R.id.frame_layout, fragmentList.get(i))
                        .commit();
            }

            @Override
            public void onTabUnselected(int i) {

            }

            @Override
            public void onTabReselected(int i) {

            }
        });
    }

    /**
     * 设置底部导航栏样式
     */
    @SuppressWarnings("deprecation")
    private void setBottomNavigationBar() {
        bottomNavigationBar
                .setMode(MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .addItem(new BottomNavigationItem(R.mipmap.ic_add_selected, "first")
                        .setActiveColor(Color.BLUE)
                        .setInActiveColor(Color.GRAY)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap.ic_add_normal)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_customer_selected, "second")
                        .setActiveColor(Color.BLUE)
                        .setInActiveColor(Color.GRAY)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap.ic_customer_normal)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_my_selected, "third")
                        .setActiveColor(Color.BLUE)
                        .setInActiveColor(Color.GRAY)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap.ic_my_noramal)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_order_selected, "fourth")
                        .setActiveColor(Color.BLUE)
                        .setInActiveColor(Color.GRAY)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap.ic_order_normal)))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    /**
     * 添加fragment
     */
    private void setFragmentList() {
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
    }

}
