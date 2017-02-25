package com.asemi.ailab.agent_seminar;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
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
    ImageButton dealedAgent1, dealedAgent2;
    ImageButton[] agentCPUs;

    ArrayList<StrategyCard> hands, possession;
    FlagmentListener flagmentListener;
    ListMode mode = ListMode.HANDS;

    Observer observer;
    Agent[] agents;
    AllDeck allDeck;
    Movement movement;



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
        getActivity().findViewById(R.id.statusCPU).setVisibility(View.INVISIBLE);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_strategy);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //observer = flagmentListener.getObserver();
        allDeck = flagmentListener.getAllDeck();
        side = (ImageButton) getActivity().findViewById(R.id.btn_side);
        agent = (ImageButton) getActivity().findViewById(R.id.btn_agent);

        agents = flagmentListener.dealTwoAgents(allDeck);
        dealedAgent1 = (ImageButton) getActivity().findViewById(R.id.btn1);
        dealedAgent1.setImageResource(flagmentListener.getAgentViewID(agents[0]));
        dealedAgent1.setOnClickListener(this);
        dealedAgent2 = (ImageButton) getActivity().findViewById(R.id.btn2);
        dealedAgent2.setImageResource(flagmentListener.getAgentViewID(agents[1]));
        dealedAgent2.setOnClickListener(this);

        agentCPUs = new ImageButton[8];
        for(int i=0; i<8; i++){
            agentCPUs[i] = (ImageButton) getActivity().findViewById(flagmentListener.getCPUImageButtonID(i+1));
            agentCPUs[i].setOnClickListener(this);
        }

        btn_hand = (Button) getActivity().findViewById(R.id.btn_hands);
        btn_hand.setOnClickListener(this);
        btn_possess = (Button) getActivity().findViewById(R.id.btn_possession);
        btn_possess.setOnClickListener(this);
        btn_hand.setEnabled(false);
        btn_possess.setEnabled(false);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_hands:
                btn_hand.setEnabled(false);
                btn_possess.setEnabled(true);
                observer.player.mode = ListMode.HANDS;
                adapter = new MyAdapter(flagmentListener, hands, observer);
                recyclerView.setAdapter(adapter);

                break;
            case R.id.btn_possession:
                btn_hand.setEnabled(true);
                btn_possess.setEnabled(false);
                observer.player.mode = ListMode.POSSESSION;
                possession = observer.player.possession;
                adapter = new MyAdapter(flagmentListener, possession, observer);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_agent:
                break;
            /*  */
            case R.id.btn1:
                makeFirstCondition(agents[0]);
                break;
            case R.id.btn2:
                makeFirstCondition(agents[1]);
                break;

            case R.id.btn_cpu1agent:
                if(observer.playerCPU.get(0).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(0).agent.open) {
                        agentCPUs[0].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(0).agent.open = false;
                    } else {
                        agentCPUs[0].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(0).agent));
                        observer.playerCPU.get(0).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu2agent:
                if(observer.playerCPU.get(1).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(1).agent.open) {
                        agentCPUs[1].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(1).agent.open = false;
                    } else {
                        agentCPUs[1].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(1).agent));
                        observer.playerCPU.get(1).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu3agent:
                if(observer.playerCPU.get(2).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(2).agent.open) {
                        agentCPUs[2].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(2).agent.open = false;
                    } else {
                        agentCPUs[2].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(2).agent));
                        observer.playerCPU.get(2).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu4agent:
                if(observer.playerCPU.get(3).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(3).agent.open) {
                        agentCPUs[3].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(3).agent.open = false;
                    } else {
                        agentCPUs[3].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(3).agent));
                        observer.playerCPU.get(3).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu5agent:
                if(observer.playerCPU.get(4).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(4).agent.open) {
                        agentCPUs[4].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(4).agent.open = false;
                    } else {
                        agentCPUs[4].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(4).agent));
                        observer.playerCPU.get(4).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu6agent:
                if(observer.playerCPU.get(5).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(5).agent.open) {
                        agentCPUs[5].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(5).agent.open = false;
                    } else {
                        agentCPUs[5].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(5).agent));
                        observer.playerCPU.get(5).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu7agent:
                if(observer.playerCPU.get(6).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(6).agent.open) {
                        agentCPUs[6].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(6).agent.open = false;
                    } else {
                        agentCPUs[6].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(6).agent));
                        observer.playerCPU.get(6).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu8agent:
                if(observer.playerCPU.get(7).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerCPU.get(7).agent.open) {
                        agentCPUs[7].setImageResource(R.drawable.agentback);
                        observer.playerCPU.get(7).agent.open = false;
                    } else {
                        agentCPUs[7].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(7).agent));
                        observer.playerCPU.get(7).agent.open = true;
                    }
                }
                break;
        }
    }

    public void makeFirstCondition(Agent selectAgent){
        /* UIにおける自分の情報を用意 */
        dealedAgent1.setVisibility(View.INVISIBLE);
        dealedAgent2.setVisibility(View.INVISIBLE);
        observer = flagmentListener.setFirstDeal(allDeck, selectAgent);
        side.setImageResource(flagmentListener.getSideViewID(observer.player.side));
        agent.setImageResource(flagmentListener.getAgentViewID(selectAgent));
        hands = observer.player.hands;
        btn_hand.setEnabled(false);
        btn_possess.setEnabled(true);
        adapter = new MyAdapter(flagmentListener, hands, observer);
        recyclerView.setAdapter(adapter);
        /* CPUのエージェント等を用意 */
        getActivity().findViewById(R.id.statusCPU).setVisibility(View.VISIBLE);
        for(int i = 0; i<observer.playerCPU.size(); i++) {
            if (observer.playerCPU.get(i).agent.agentAttribute != AgentAttribute.SECRET) {
                agentCPUs[i].setImageResource(flagmentListener.getAgentViewID(observer.playerCPU.get(i).agent));
            } else {
                agentCPUs[i].setImageResource(R.drawable.agentback);
            }
        }

    }



    @Override
    public void onAttach(Context context){
        super.onAttach(context);
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

    /* フェイズ管理     *
     *                  */

    public void startPhase(Observer observer){
        observer.confirmAbility();
        observer.phase = Phase.FILL;
    }

    public void fillPhase(Observer observer){
        observer.confirmAbility();
        movement = new Movement();
        movement.Draw(observer.playerCPU.get(observer.turn), observer.playerCPU.get(observer.turn).draw_num, observer.deck);
        observer.phase = Phase.STRATEGY;
    }

    public void strategyPhase(Observer observer){
        observer.confirmAbility();
        if(observer.playerCPU.get(observer.turn).playable){

        }else{

        }
        observer.phase = Phase.SEND;
    }

    public void sendPhase(Observer observer){
        observer.confirmAbility();
        if(observer.messageNum > 1){
            //observer.sendedCard =
        }else{

        }
        observer.phase = Phase.FINISH;
    }

    public void finishPhase(Observer observer){
        observer.confirmAbility();
        observer.nextTurn(observer.otamo);
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    public interface FlagmentListener{
        public AllDeck getAllDeck();
        public Agent[] dealTwoAgents(AllDeck allDeck);
        public Observer setFirstDeal(AllDeck allDeck, Agent agent);
        public int getAgentViewID(Agent agent);
        public int getStrategyViewID(StrategyCard strategyCard);
        public int getSideViewID(Side side);
        public int getCPUImageButtonID(int num);
        // public void onClickList(int index, ListMode mode);
        // public void onClickAgentButton();
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
    @Override public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
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