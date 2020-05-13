package com.habit.star.ui.mine.presenter;

import com.habit.star.api.HttpResultSubscriber;
import com.habit.star.api.HttpServerImpl;
import com.habit.star.base.RxPresenter;
import com.habit.star.model.http.RetrofitHelper;
import com.habit.star.pojo.po.DeviceBO;
import com.habit.star.pojo.po.DeviceLinkBO;
import com.habit.star.pojo.po.UserBO;
import com.habit.star.ui.mine.contract.MineContract;

import javax.inject.Inject;

/**
 * 创建日期：2018/5/30 11:33
 *
 * @author dongdong
 * @version 1.0
 * @since 文件名称： MineFragment.java
 * 类说明：
 */
public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter {

    RetrofitHelper mRetrofitHelper;

    @Inject
    public MinePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }


    public void getUserInfo() {
        HttpServerImpl.getUserInfo().subscribe(new HttpResultSubscriber<UserBO>() {
            @Override
            public void onSuccess(UserBO userBO) {
                if (mView != null) {
                    mView.getUserInfo(userBO);
                }
            }

            @Override
            public void onFiled(String message) {
                if (mView != null) {
                    mView.showError(message);
                }
            }
        });
    }


    /**
     * 获取当前设备连接
     */
    public void getLinkDevice() {
        HttpServerImpl.getLinkDevice().subscribe(new HttpResultSubscriber<DeviceBO>() {
            @Override
            public void onSuccess(DeviceBO deviceBO) {
                if (mView != null) {
                    mView.getLinkDevice(deviceBO);
                }
            }

            @Override
            public void onFiled(String message) {
                if (mView != null) {
                    mView.showError(message);
                }
            }
        });
    }


    /**
     * 获取设备数量
     */
    public void getDeviceData() {
        HttpServerImpl.getDeviceData().subscribe(new HttpResultSubscriber<DeviceLinkBO>() {
            @Override
            public void onSuccess(DeviceLinkBO s) {
                if (mView != null) {
                    mView.getDeviceData(s);
                }
            }

            @Override
            public void onFiled(String message) {
                if (mView != null) {
                    mView.showError(message);
                }
            }
        });
    }

}