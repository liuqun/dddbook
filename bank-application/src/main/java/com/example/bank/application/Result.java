package com.example.bank.application;

public interface Result<T> {

    /**
     * @return 数据
     */
    T getData();

    /**
     * success() 静态方法
     * @return 返回能够代表成功的 Acknowledgement 确认响应
     */
    static Result<Boolean> success() {
        return new Acknowledgement(true);
    }

    /**
     * failure() 静态方法
     * @return 返回能够代表失败的 Acknowledgement 响应
     */
    static Result<Boolean> failure() {
        return new Acknowledgement(false);
    }
}
