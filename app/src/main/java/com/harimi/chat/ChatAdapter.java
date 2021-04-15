package com.harimi.chat;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ItemChat> list=new ArrayList<>();


    public ChatAdapter(ArrayList<ItemChat> chatList){
        list=chatList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(viewType== Code.ViewType.CENTER_CONTENT){
            view=inflater.inflate(R.layout.recycer_chat_center,parent,false);
            return new CenterViewHolder(view);
        }else if(viewType == Code.ViewType.LEFT_CONTENT){
            view=inflater.inflate(R.layout.recycler_chat_your_item,parent,false);
            return new LeftViewHolder(view);
        }else{
            view=inflater.inflate(R.layout.recycler_chat_my_item,parent,false);
            return new RightViewHolder(view);
        }

    }

    // 실제 각 뷰 홀더에 데이터를 연결해주는 함수
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CenterViewHolder){
            ((CenterViewHolder)holder).textView.setText(list.get(position).getContent());
        }else if(holder instanceof LeftViewHolder){
           ((LeftViewHolder) holder).tv_nickname.setText(list.get(position).getNickname());
           ((LeftViewHolder) holder).tv_content.setText(list.get(position).getContent());
           ((LeftViewHolder) holder).tv_date.setText(list.get(position).getDate());
//           ((LeftViewHolder) holder).iv_profile.setImageURI(Uri.parse(list.get(position).getProfile()));
        }else{
            ((RightViewHolder)holder).tv_content.setText(list.get(position).getContent());
            ((RightViewHolder)holder).tv_date.setText(list.get(position).getDate());
        }
    }

    //리사이클러뷰안에서 들어갈 뷰 홀더의 개수
    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }


    // ViewType 때문에 오버라이딩(구별하기 위해서)
    @Override
    public int getItemViewType(int position) {
        return list.get(position).getViewType();
    }

    //리사이클러뷰에 들어갈 뷰홀더 그리고 그 뷰홀더에 들어갈 아이템들을 셋팅
    public class CenterViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public CenterViewHolder(View itemView){
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.item_chat_center);
        }
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_content;
        TextView tv_date;
        TextView tv_nickname;

        public LeftViewHolder(View itemView){
            super(itemView);
            iv_profile=(ImageView) itemView.findViewById(R.id.your_item_iv_profile);
            tv_nickname=(TextView) itemView.findViewById(R.id.your_item_tv_nickname);
            tv_content=(TextView) itemView.findViewById(R.id.tv_your_chatitem_message);
            tv_date=(TextView) itemView.findViewById(R.id.your_item_tv_time);
        }
    }

    public class RightViewHolder extends RecyclerView.ViewHolder {
        TextView tv_content;
        TextView tv_date;

        public RightViewHolder(View itemView){
            super(itemView);
            tv_content=(TextView) itemView.findViewById(R.id.tv_chat_myitem_contents);
            tv_date=(TextView) itemView.findViewById(R.id.my_item_tv_time);
        }
    }

}
