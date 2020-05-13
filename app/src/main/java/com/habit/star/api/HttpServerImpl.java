package com.habit.star.api;

import com.habit.star.api.rx.RxResultHelper;
import com.habit.star.pojo.po.DeviceBO;
import com.habit.star.pojo.po.DeviceLinkBO;
import com.habit.star.pojo.po.UserBO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

public class HttpServerImpl {

    private static HttpService service;

    /**
     * 获取代理对象
     *
     * @return
     */
    public static HttpService getService() {
        if (service == null)
            service = ApiManager.getInstance().configRetrofit(HttpService.class, HttpService.URL);
        return service;
    }


    /**
     * 登录
     */
    public static Observable<UserBO> login(String phone, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);
        return getService().passwordLogin(params).compose(RxResultHelper.httpRusult());
    }

    /**
     * 注册接口
     */
    public static Observable<String> regiest(String phone, String password, String code, String isBuy) {
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);
        params.put("code", code);
        params.put("isBuy", isBuy);
        return getService().regiest(params).compose(RxResultHelper.httpRusult());
    }


    /**
     * 发送验证码
     */
    public static Observable<String> sendCode(String phone, int type) {
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("type", type);
        return getService().sendCode(params).compose(RxResultHelper.httpRusult());
    }


    /**
     * 忘记密码时验证手机号
     */
    public static Observable<String> verifyPhone(String phone, String code) {
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("code", code);
        return getService().verifyPhone(params).compose(RxResultHelper.httpRusult());
    }

    /**
     * 忘记密码
     */
    public static Observable<String> forgetPassword(String phone, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);
        return getService().forgetPassword(params).compose(RxResultHelper.httpRusult());
    }


    /**
     * token 快捷登录
     */
    public static Observable<UserBO> tokenLogin() {
        return getService().tokenLogin().compose(RxResultHelper.httpRusult());
    }


    /**
     * 获取我的设备列表
     */
    public static Observable<List<DeviceBO>> getDeviceList() {
        return getService().getDeviceList().compose(RxResultHelper.httpRusult());
    }


    /**
     * 删除设备
     */
    public static Observable<String> delDevice(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return getService().delDevice(params).compose(RxResultHelper.httpRusult());
    }


    /**
     * 保存设备
     */
    public static Observable<String> saveDevices(int id, String name, String macAddress) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("macAddress", macAddress);
        return getService().saveDevices(params).compose(RxResultHelper.httpRusult());
    }

    /**
     * 获取用户信息
     */
    public static Observable<UserBO> getUserInfo() {
        return getService().getUserInfo().compose(RxResultHelper.httpRusult());
    }

    /**
     * 查询当前连接的设备
     */
    public static Observable<DeviceBO> getLinkDevice() {
        return getService().getLinkDevice().compose(RxResultHelper.httpRusult());
    }

    /**
     * 查询设备数量
     */
    public static Observable<DeviceLinkBO> getDeviceData() {
        return getService().getDeviceData().compose(RxResultHelper.httpRusult());
    }

}
