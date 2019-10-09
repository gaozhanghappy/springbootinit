package git.gaozhanghappy.errorCode;/**
 * Created by thinkpad on 2019/9/4.
 */

/**
 * @author gaozhang
 * @ 2019/9/4 9:34
 */

public enum  EnumError implements IError {
    ERROR_PARAMET("001","参数错误"),

    EMPTY_PARAMET("000","参数为空");

    private String code;
    private String message;

    EnumError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Integer code() {
        return null;
    }

    @Override
    public String message() {
        return null;
    }
}
