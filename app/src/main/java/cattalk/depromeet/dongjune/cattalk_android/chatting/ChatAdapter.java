package cattalk.depromeet.dongjune.cattalk_android.chatting;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    private int align;
    private boolean message_left = false;
    Context context;

    public ChatAdapter(Context context, List<ChattingVo> items, int itemLayout) {
        this.context = context;
        mItems = items;
        this.itemLayout = itemLayout;
    }


    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        holder.text.setText(mItems.get(position).getResponse());
//        holder.text.setBackground(context.getResources().getDrawable(message_left? R.drawable.chat_white : R.drawable.chat_orange));

        if(mItems.get(position).getResponse() != null){
            holder.text.setBackground(context.getResources().getDrawable(R.drawable.chat_white));
            holder.chatMsgLayout.setGravity(Gravity.LEFT);
//            holder.viewRight.setVisibility(View.GONE);
//            holder.viewLeft.setVisibility(View.GONE);
        } else if(mItems.get(position).getMsg() != null){
            holder.text.setBackground(context.getResources().getDrawable(R.drawable.chat_orange));
            holder.chatMsgLayout.setGravity(Gravity.RIGHT);
//            holder.viewRight.setVisibility(View.GONE);
//            holder.viewLeft.setVisibility(View.GONE);
        }


    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public RelativeLayout chatMsgLayout;
//        View viewRight;
//        View viewLeft;

        public ViewHolder(View itemView) {
            super(itemView);

            chatMsgLayout = (RelativeLayout) itemView.findViewById(R.id.chatMsgLayout);
            text = (TextView) itemView.findViewById(R.id.message_text);
//            viewLeft = (View) itemView.findViewById(R.id.imageviewleft);
//            viewRight = (View) itemView.findViewById(R.id.imageviewright);
        }

    }
}

