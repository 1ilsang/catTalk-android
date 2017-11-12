package cattalk.depromeet.dongjune.cattalk_android.chatting;

/**
 * Created by bogyeongkim on 2017. 11. 12..
 */

public class RecyclerItem {
    private String msg;
    private int image;

    public RecyclerItem(String msg, int image){
        this.msg = msg;
        this.image = image;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
