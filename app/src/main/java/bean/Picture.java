package bean;

import org.litepal.crud.LitePalSupport;

public class Picture extends LitePalSupport{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImageBt() {
        return imageBt;
    }

    public void setImageBt(byte[] imageBt) {
        this.imageBt = imageBt;
    }

    private byte[] imageBt;
}
