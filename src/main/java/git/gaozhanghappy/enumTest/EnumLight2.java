package git.gaozhanghappy.enumTest;/**
 * Created by thinkpad on 2019/9/4.
 */

/**
 * @author gaozhang
 * @ 2019/9/4 9:03
 */

public enum EnumLight2 {
    // 利用构造函数传参
    RED (1), GREEN (3), YELLOW (2);


    // 定义私有变量
    private int Code ;

    // 构造函数，枚举类型只能为私有


    EnumLight2(int code) {
        Code = code;
    }
}
