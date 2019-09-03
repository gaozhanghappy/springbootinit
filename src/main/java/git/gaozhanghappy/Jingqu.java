package git.gaozhanghappy;/**
 * Created by thinkpad on 2019/9/3.
 */

/**
 * @author gaozhang
 * @ 2019/9/3 14:27
 */

public enum Jingqu {
    JINGQU1("中山陵"),
    JINGQU2("总统府"),
    JINGQU3("梅园");

    private String jingQu;

    Jingqu(String jingQu) {
        this.jingQu = jingQu;
    }

    public String getJingQu() {
        return jingQu;
    }

    public void setJingQu(String jingQu) {
        this.jingQu = jingQu;
    }
}
