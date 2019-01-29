package allinone.rull.frt.fortrouletteallinone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder>  {

    private ArrayList<ChallengeItem> items = new ArrayList<ChallengeItem>();
    private static final String TAG = "MY LOG ADAPTER ";
    private int width;
    Context context;

    public ChallengeAdapter(int width) {
        super();
        this.width = width;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder");
        final int pos = position;
        final ChallengeItem item = items.get(position);

//        holder.imageName1.setImageResource(item.getImageName1());
//        holder.imageName2.setImageResource(item.getImageName2());

        Glide.with(holder.itemView.getContext()).load(item.getImageName1())
                .thumbnail(0.5f)
                .into(holder.imageName1);
//
//        Glide.with(holder.itemView.getContext()).load(item.getTextName())
//                .thumbnail(0.5f)
//                .into(holder.textName);
                holder.textName.setText(item.getTextName());
    }

    @NonNull
    @Override
    public ChallengeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_challenge, parent, false);

        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
        lp.height = width;
        view.setLayoutParams(lp);

        return new ChallengeAdapter.ViewHolder(view);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageName1;
        TextView textName;


        public ViewHolder(View itemView) {
            super(itemView);
            imageName1 =(ImageView) itemView.findViewById(R.id.imageName);
            textName =(TextView) itemView.findViewById(R.id.textName);
        }

        public void bind(ChallengeItem allConstructionItem) {
            Log.d(TAG, "bind");
            imageName1.setImageResource(allConstructionItem.getImageName1());
            textName.setText(allConstructionItem.getTextName());
        }
    }

    public  void addMessage(ChallengeItem item) {
        Log.d(TAG, "addMessage");
        items.add(item);
        notifyItemChanged(items.size() - 1);
    }

}