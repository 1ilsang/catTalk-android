package cattalk.depromeet.dongjune.cattalk_android.network.vo;

/**
 * Created by dongjune on 2017-11-12.
 */

public class ChattingVo {
    private String response;
    private String msg;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ChattingVo{" +
                "response='" + response + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
