package com.asemi.ailab.agent_seminar;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by wataru on 17/02/19.
 */

public class PlayerFlagment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Bundle bundle = getArguments();
    ArrayList<StrategyCard> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // 先ほどのレイアウトをここでViewとして作成します
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    // Viewが生成し終わった時に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_strategy);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add(new StrategyCard(Strategy.COUNTERACT, Color.BLACK));
        list.add(new StrategyCard(Strategy.COUNTERACT, Color.BLUE));
        list.add(new StrategyCard(Strategy.COUNTERACT, Color.RED));
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    protected void addItem(StrategyCard strategyCard) {
        list.add(strategyCard);
        adapter.notifyItemInserted(0);
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {
    ArrayList<StrategyCard> list;
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ItemViewHolder(View v){
            super(v);
            imageView = (ImageView)v.findViewById(R.id.img_elem);
        }
    }
    public MyAdapter(ArrayList<StrategyCard> strategyCards){
        this.list = strategyCards;
    }
    @Override public ItemViewHolder onCreateViewHolder( ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()) .inflate(R.layout.list_strategy, parent, false);
        return new ItemViewHolder(v);
    }
    @Override public void onBindViewHolder(ItemViewHolder holder, int position) {
        final StrategyCard data;
        data = list.get(position);
        holder.imageView.setImageResource(R.drawable.detective);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                removeFromDataset(data);
            }
        });
    }
    @Override public int getItemCount() {
        return list.size();
    }
    protected void removeFromDataset(StrategyCard data){
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).equals(data)){
                list.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }
}