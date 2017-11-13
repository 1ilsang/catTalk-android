package cattalk.depromeet.dongjune.cattalk_android.chatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        holder.text.setText(mItems.get(position).getResponse());
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.message_text);
        }

    }
}

