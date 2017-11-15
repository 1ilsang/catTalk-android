package cattalk.depromeet.dongjune.cattalk_android.network.vo;

/**
 * Created by dongjunekim on 2017-11-15.
 */

public class TransVo {
    String translatedText;
    String srcLangType;

    @Override
    public String toString() {
        return "TransVo{" +
                "translatedText='" + translatedText + '\'' +
                ", srcLangType='" + srcLangType + '\'' +
                '}';
    }

    public String getSrcLangType() {
        return srcLangType;
    }

    public void setSrcLangType(String srcLangType) {
        this.srcLangType = srcLangType;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
