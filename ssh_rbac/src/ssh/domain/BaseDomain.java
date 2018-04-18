package ssh.domain;

/**
 * 所有domain的父类，封装了所有domain的共同代码
 * Created by liang on 2018/4/4.
 */
public class BaseDomain {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
