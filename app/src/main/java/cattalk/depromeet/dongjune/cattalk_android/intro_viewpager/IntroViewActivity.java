package cattalk.depromeet.dongjune.cattalk_android.intro_viewpager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cattalk.depromeet.dongjune.cattalk_android.chatting.MainActivity;
import cattalk.depromeet.dongjune.cattalk_android.R;
import cattalk.depromeet.dongjune.cattalk_android.databinding.ActivityIntroViewBinding;
import cattalk.depromeet.dongjune.cattalk_android.network.dao.ApiUtils;
import cattalk.depromeet.dongjune.cattalk_android.network.service.ChattingService;
import cattalk.depromeet.dongjune.cattalk_android.network.vo.ChattingVo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IntroViewActivity extends AppCompatActivity {

    ActivityIntroViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro_view);
        //saveFirstCheck();

        IntroViewAdapter adapter = new IntroViewAdapter(getApplicationContext(), getLayoutInflater());
        binding.introViewpager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.introViewpager, true);

        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroViewActivity.this, MainActivity.class);
                startActivity(intent);
                IntroViewActivity.this.finish();
            }
        });

    }



    private void saveFirstCheck() {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("first_check", true);
    }
}
