package cattalk.depromeet.dongjune.cattalk_android.chatting;

import android.content.Context;
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
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cattalk.depromeet.dongjune.cattalk_android.R;
import cattalk.depromeet.dongjune.cattalk_android.databinding.ActivityMainBinding;
import cattalk.depromeet.dongjune.cattalk_android.network.dao.ApiUtils;
import cattalk.depromeet.dongjune.cattalk_android.network.service.ChattingService;
import cattalk.depromeet.dongjune.cattalk_android.network.vo.ChattingVo;
import cattalk.depromeet.dongjune.cattalk_android.network.vo.TransVo;
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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

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
                if (setTransLate) {
                    transMessage(message);
                } else {
                    sendMessage(message);
                }
                Log.d("message", message);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

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

    private void sendMessage(String messgae) {
        service = ApiUtils.getSosService();
        service.getAnswers(messgae).enqueue(new Callback<ChattingVo>() {
            @Override
            public void onResponse(Call<ChattingVo> call, Response<ChattingVo> response) {
                if (response.isSuccessful()) {
                    Log.d("send", "sendddd");
                    Log.d(String.valueOf(response.body().getResponse()), "Success");
                    ChattingVo vo = new ChattingVo();
                    vo.setResponse(response.body().getResponse());
                    vo.setMsg(response.body().getMsg());
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

    private void transMessage(String messgae) {
        service = ApiUtils.getSosService();

        service.getTrans(messgae).enqueue(new Callback<TransVo>() {
            @Override
            public void onResponse(Call<TransVo> call, Response<TransVo> response) {
                if (response.isSuccessful()) {
                    Log.d(String.valueOf(response.body().getTranslatedText()), "Success");
                    ChattingVo vo = new ChattingVo();
                    vo.setResponse(response.body().getTranslatedText());
                    vo.setMsg(response.body().getSrcLangType());
                    items.add(vo);
                    adapter.notifyDataSetChanged();
                    Log.d("trans", response.body().getTranslatedText());
                } else {
                    int statusCode = response.code();
                    Log.d(statusCode + "", "Success but");

                }
            }

            @Override
            public void onFailure(Call<TransVo> call, Throwable t) {
                Log.d("MainActivity", "fail");
            }

        });

    }
}
