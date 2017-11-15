package cattalk.depromeet.dongjune.cattalk_android.chatting;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cattalk.depromeet.dongjune.cattalk_android.R;
import cattalk.depromeet.dongjune.cattalk_android.network.vo.ChattingVo;


/**
 * Created by bogyeongkim on 2017. 11. 12..
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<ChattingVo> mItems;
    private int itemLayout;
    Context context;

    public ChatAdapter(Context context, List<ChattingVo> items, int itemLayout) {
        this.context = context;
        mItems = items;
        this.itemLayout = itemLayout;
    }


    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, null, false);
        RecyclerView.LayoutParams lp =new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {

        if (mItems.get(position).getMsg() == null) {//내가 보낸거
            holder.text1.setVisibility(View.INVISIBLE);
            holder.text2.setVisibility(View.VISIBLE);
            holder.text2.setText(mItems.get(position).getResponse());
            Log.d("asdfasdfrr", "Asdfasdff");
        } else {//심심이가 보낸거
            holder.text1.setVisibility(View.VISIBLE);
            holder.text2.setVisibility(View.INVISIBLE);
            holder.text1.setText(mItems.get(position).getResponse());
        }
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text1, text2;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.message_text1);
            text2 = (TextView) itemView.findViewById(R.id.message_text2);
        }

    }
}

