package io.github.smnpo.common.restful;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-07 19:49
 **/
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -3032015199552656978L;

    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code = 0;
        this.data = data;
    }

    private Result(Code code) {
        if (code == null) {
            return;
        }
        this.code = code.getCode();
        this.msg = code.getMsg();
    }


    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result(data);
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(Code code) {
        return new Result(code);
    }
}
