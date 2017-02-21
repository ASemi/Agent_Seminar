package com.asemi.ailab.agent_seminar;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by wataru on 17/02/19.
 */

public class PlayerFlagment extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Button btn_hand, btn_possess;
    ImageButton side, agent;

    ArrayList<StrategyCard> hands, possession;
    FlagmentListener flagmentListener;
    ListMode mode = ListMode.HANDS;

    Observer observer;


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

        observer = flagmentListener.getObserver();
        side = (ImageButton) getActivity().findViewById(R.id.btn_side);
        agent = (ImageButton) getActivity().findViewById(flagmentListener.getAgentViewID(observer.player.agent));

        hands = observer.player.hands;
        adapter = new MyAdapter(flagmentListener, hands, observer);
        recyclerView.setAdapter(adapter);

        btn_hand = (Button) getActivity().findViewById(R.id.btn_hands);
        btn_hand.setOnClickListener(this);
        btn_possess = (Button) getActivity().findViewById(R.id.btn_possession);
        btn_possess.setOnClickListener(this);
        btn_possess.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_hands:
                btn_hand.setVisibility(View.INVISIBLE);
                btn_possess.setVisibility(View.VISIBLE);
                observer.player.mode = ListMode.HANDS;

                break;
            case R.id.btn_possession:
                btn_hand.setVisibility(View.VISIBLE);
                btn_possess.setVisibility(View.INVISIBLE);
                observer.player.mode = ListMode.POSSESSION;
                break;
            case R.id.btn_agent:
                break;
        }
    }



    @Override
    public void onAttach(Context context){
        if(context instanceof FlagmentListener){
            flagmentListener = (FlagmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // 画面からFragmentが離れたあとに処理が呼ばれることを避けるためにNullで初期化しておく
        flagmentListener = null;
    }

    protected void addItem(StrategyCard strategyCard) {
        hands.add(strategyCard);
        adapter.notifyItemInserted(0);
    }

    public interface FlagmentListener{
        public Observer getObserver();
        public int getAgentViewID(Agent agent);
        public int getStrategyViewID(StrategyCard strategyCard);
        //public void onClickList(int index, ListMode mode);
        //public void onClickAgentButton();
    }

}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {
    PlayerFlagment.FlagmentListener flagmentListener;

    ArrayList<StrategyCard> list;
    Observer observer;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ItemViewHolder(View v){
            super(v);
            imageView = (ImageView)v.findViewById(R.id.img_elem);
        }
    }
    public MyAdapter(PlayerFlagment.FlagmentListener flagmentListener, ArrayList<StrategyCard> strategyCards, Observer observer){
        this.flagmentListener = flagmentListener;
        this.list = strategyCards;
        this.observer = observer;
    }
    @Override public ItemViewHolder onCreateViewHolder( ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()) .inflate(R.layout.list_strategy, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final StrategyCard data;
        final int index = position;

        data = list.get(position);
        holder.imageView.setImageResource(flagmentListener.getStrategyViewID(data));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(observer.player.mode == ListMode.HANDS) {
                    removeFromDataset(data);
                }
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
                switch (observer.player.mode){
                    case HANDS:
                        observer.player.hands.remove(data);
                        break;
                    case POSSESSION:
                        observer.player.possession.remove(data);
                        break;
                }
                notifyItemRemoved(i);
                break;
            }
        }
    }

}