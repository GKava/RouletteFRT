package allinone.rull.frt.fortrouletteallinone;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
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
    private int rarityColor;

    public ChallengeAdapter() {
        super();


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

        if (item.getRarityColor() == 1){
            holder.cardView.setBackground(ContextCompat.getDrawable(holder.cardView.getContext(), R.drawable.background_epic));
        }else if (item.getRarityColor() == 2){
            holder.cardView.setBackground(ContextCompat.getDrawable(holder.cardView.getContext(), R.drawable.background_legendary));
        }else if (item.getRarityColor() == 3){
            holder.cardView.setBackground(ContextCompat.getDrawable(holder.cardView.getContext(), R.drawable.background_rarity));
        }else if (item.getRarityColor() == 4){
            holder.cardView.setBackground(ContextCompat.getDrawable(holder.cardView.getContext(), R.drawable.background_different));
        }

        Glide.with(holder.itemView.getContext()).load(item.getImageName1())
                .thumbnail(0.5f)
                .into(holder.imageName1);

                 holder.textName.setText(item.getTextName());




    }

    @NonNull
    @Override
    public ChallengeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_challenge, parent, false);

        return new ChallengeAdapter.ViewHolder(view);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageName1;
        TextView textName;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            imageName1 = itemView.findViewById(R.id.imageName);
            textName = itemView.findViewById(R.id.textName);
            cardView = itemView.findViewById(R.id.cardView);
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
