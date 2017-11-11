package cattalk.depromeet.dongjune.cattalk_android.network.dao;

import cattalk.depromeet.dongjune.cattalk_android.network.controller.RetrofitClient;
import cattalk.depromeet.dongjune.cattalk_android.network.service.ChattingService;

/**
 * Created by dongjune on 2017-11-11.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://52.79.83.113:3000";

    public static ChattingService getSosService() {
        return RetrofitClient.getClient(BASE_URL).create(ChattingService.class);
    }

}
