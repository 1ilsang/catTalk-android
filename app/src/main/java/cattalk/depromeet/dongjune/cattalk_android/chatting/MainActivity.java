package cattalk.depromeet.dongjune.cattalk_android.chatting;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cattalk.depromeet.dongjune.cattalk_android.R;
import cattalk.depromeet.dongjune.cattalk_android.databinding.ActivityMainBinding;
import cattalk.depromeet.dongjune.cattalk_android.network.dao.ApiUtils;
import cattalk.depromeet.dongjune.cattalk_android.network.service.ChattingService;
import cattalk.depromeet.dongjune.cattalk_android.network.vo.ChattingVo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private List<ChattingVo> items;
    private boolean setTransLate = false;
    private ChattingService service;
    private ChattingVo vo;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        items = new ArrayList<>();
        addData();
        binding.toTransBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (setTransLate) {
                    setTransLate = false;
                    binding.toTransBtn.setBackground(getDrawable(R.drawable.chat_abutton_off));

                } else {
                    setTransLate = true;
                    binding.toTransBtn.setBackground(getDrawable(R.drawable.chat_abutton_on));
                }
            }
        });

        binding.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = binding.chatEdit.getText().toString();
                binding.chatEdit.setText("");
                vo = new ChattingVo();
                vo.setResponse(message);
                Log.d("vovovo.tostrnig", vo.toString());
                items.add(vo);
                adapter.notifyDataSetChanged();
                Log.d("items.toString", items.toString());

                testServerMessage(message);
            }
        });


    }

    public void addData() {
        /*vo = new ChattingVo();
        vo.setResponse("asdf");
        items.add(vo);*/
        adapter = new ChatAdapter(MainActivity.this, items, R.layout.item_recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void testServerMessage(String messgae) {
        service = ApiUtils.getSosService();
        service.getAnswers(messgae).enqueue(new Callback<ChattingVo>() {
            @Override
            public void onResponse(Call<ChattingVo> call, Response<ChattingVo> response) {
                if (response.isSuccessful()) {
                    Log.d(String.valueOf(response.body().getResponse()), "Success");
                    ChattingVo vo = new ChattingVo();
                    vo.setResponse(response.body().getResponse());
                    items.add(vo);
                    adapter.notifyDataSetChanged();
                } else {
                    int statusCode = response.code();
                    Log.d(statusCode + "", "Success but");

                }
            }

            @Override
            public void onFailure(Call<ChattingVo> call, Throwable t) {
                Log.d("MainActivity", "fail");

            }
        });

    }
}
