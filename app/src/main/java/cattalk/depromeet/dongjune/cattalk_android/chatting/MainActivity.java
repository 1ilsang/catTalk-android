package cattalk.depromeet.dongjune.cattalk_android.chatting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cattalk.depromeet.dongjune.cattalk_android.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<RecyclerItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        addData();
    }

    public void addData(){
        items = new ArrayList<>();

        for(int i=0;i<30;i++) {
            items.add(new RecyclerItem("test", R.mipmap.ic_launcher));
        }

        recyclerView.setAdapter(new ChatAdapter(MainActivity.this, items, R.layout.activity_chat));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
