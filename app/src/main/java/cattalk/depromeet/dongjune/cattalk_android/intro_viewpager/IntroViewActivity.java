package cattalk.depromeet.dongjune.cattalk_android.intro_viewpager;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cattalk.depromeet.dongjune.cattalk_android.R;
import cattalk.depromeet.dongjune.cattalk_android.databinding.ActivityIntroViewBinding;

public class IntroViewActivity extends AppCompatActivity {

    ActivityIntroViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro_view);
        IntroViewAdapter adapter = new IntroViewAdapter(getApplicationContext(), getLayoutInflater());
        binding.introViewpager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.introViewpager, true);


    }
}
