package com.crt.vhr.bean;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/1/29 19:47
 */
public class Meta {
    private Boolean keepAlive;

    private Boolean requireAuth;

    @Override
    public String toString() {
        return "Meta{" +
                "keepAlive=" + keepAlive +
                ", requireAuth=" + requireAuth +
                '}';
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
