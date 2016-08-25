package my.edu.tarc.fragment.Database;

import android.media.Image;

/**
 * Created by Eric Yam on 8/20/2016.
 */
public class BihuaData {
    private String id;
    private String zhuci;
    private String detail;
    private String pinbi;
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPinbi() {
        return pinbi;
    }

    public void setPinbi(String pinbi) {
        this.pinbi = pinbi;
    }

    public String getZhuci() {
        return zhuci;
    }

    public void setZhuci(String zhuci) {
        this.zhuci = zhuci;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
