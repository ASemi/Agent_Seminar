package com.asemi.ailab.agent_seminar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by wataru on 17/02/19.
 */

public class PlayerFlagment extends Fragment implements View.OnClickListener, PhaseController, MovementFunc{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Button btn_hand, btn_possess, btn_next;
    ImageButton side, agent;
    ImageButton dealedAgent1, dealedAgent2;
    ImageButton[] agentCPUs;

    ArrayList<StrategyCard> hands, possession;
    FlagmentListener flagmentListener;
    ListMode mode = ListMode.HANDS;

    Dialog dialog;
    ImageView iv;

    TextView phasetxt;

    Observer observer;
    Agent[] agents;
    AllDeck allDeck;



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
        side.setOnClickListener(this);
        agent = (ImageButton) getActivity().findViewById(R.id.btn_agent);
        agent.setOnClickListener(this);

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
        btn_next = (Button) getActivity().findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        btn_hand.setEnabled(false);
        btn_possess.setEnabled(false);
        btn_next.setEnabled(false);
        phasetxt = (TextView) getActivity().findViewById(R.id.txt_phase);
        phasetxt.setText(Phase.START.toString());
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {

            // 手札ボタン
            case R.id.btn_hands:
                btn_hand.setEnabled(false);
                btn_possess.setEnabled(true);
                observer.player.mode = ListMode.HANDS;
                adapter = new MyAdapter(flagmentListener, hands, observer);
                recyclerView.setAdapter(adapter);

                break;

            // 保有ボタン
            case R.id.btn_possession:
                btn_hand.setEnabled(true);
                btn_possess.setEnabled(false);
                observer.player.mode = ListMode.POSSESSION;
                possession = observer.player.possession;
                adapter = new MyAdapter(flagmentListener, possession, observer);
                recyclerView.setAdapter(adapter);
                break;

            case R.id.btn_next:
                btn_next.setEnabled(false);
                observer.phase = Phase.SEND;
                sendPhase(observer);
                break;

            case R.id.btn_agent:
                iv = new ImageView(getActivity());
                iv.setImageResource(flagmentListener.getAgentViewID(observer.player.agent));
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                iv.setAdjustViewBounds(true);
                dialog = new Dialog(getActivity());
                dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(iv);
                dialog.show();
                break;
            case R.id.btn_side:
                Intent intent = new Intent(getActivity(), ActivityGacha.class);
                startActivity(intent);

            /*  */
            case R.id.btn1:
                makeFirstCondition(agents[0]);
                startPhase(observer);
                break;
            case R.id.btn2:
                makeFirstCondition(agents[1]);
                startPhase(observer);
                break;

            /* デバッグ用（リリース時・ダイアログ実装時に削除予定） */
            case R.id.btn_cpu1agent:
                if(observer.playerList.get(0).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(0).agent.open) {
                        agentCPUs[0].setImageResource(R.drawable.agentback);
                        observer.playerList.get(0).agent.open = false;
                    } else {
                        agentCPUs[0].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(0).agent));
                        observer.playerList.get(0).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu2agent:
                if(observer.playerList.get(1).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(1).agent.open) {
                        agentCPUs[1].setImageResource(R.drawable.agentback);
                        observer.playerList.get(1).agent.open = false;
                    } else {
                        agentCPUs[1].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(1).agent));
                        observer.playerList.get(1).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu3agent:
                if(observer.playerList.get(2).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(2).agent.open) {
                        agentCPUs[2].setImageResource(R.drawable.agentback);
                        observer.playerList.get(2).agent.open = false;
                    } else {
                        agentCPUs[2].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(2).agent));
                        observer.playerList.get(2).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu4agent:
                if(observer.playerList.get(3).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(3).agent.open) {
                        agentCPUs[3].setImageResource(R.drawable.agentback);
                        observer.playerList.get(3).agent.open = false;
                    } else {
                        agentCPUs[3].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(3).agent));
                        observer.playerList.get(3).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu5agent:
                if(observer.playerList.get(4).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(4).agent.open) {
                        agentCPUs[4].setImageResource(R.drawable.agentback);
                        observer.playerList.get(4).agent.open = false;
                    } else {
                        agentCPUs[4].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(4).agent));
                        observer.playerList.get(4).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu6agent:
                if(observer.playerList.get(5).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(5).agent.open) {
                        agentCPUs[5].setImageResource(R.drawable.agentback);
                        observer.playerList.get(5).agent.open = false;
                    } else {
                        agentCPUs[5].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(5).agent));
                        observer.playerList.get(5).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu7agent:
                if(observer.playerList.get(6).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(6).agent.open) {
                        agentCPUs[6].setImageResource(R.drawable.agentback);
                        observer.playerList.get(6).agent.open = false;
                    } else {
                        agentCPUs[6].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(6).agent));
                        observer.playerList.get(6).agent.open = true;
                    }
                }
                break;
            case R.id.btn_cpu8agent:
                if(observer.playerList.get(7).agent.agentAttribute != AgentAttribute.NOMAL) {
                    if (observer.playerList.get(7).agent.open) {
                        agentCPUs[7].setImageResource(R.drawable.agentback);
                        observer.playerList.get(7).agent.open = false;
                    } else {
                        agentCPUs[7].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(7).agent));
                        observer.playerList.get(7).agent.open = true;
                    }
                }
                break;
        }
    }

    public void showDialog(int id){
        iv = new ImageView(getActivity());
        iv.setImageResource(flagmentListener.getAgentViewID(observer.player.agent));
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setAdjustViewBounds(true);
        dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(iv);

        dialog.show();
    }

    public void makeFirstCondition(Agent selectAgent){
        /* UIにおける自分の情報を用意 */
        dealedAgent1.setVisibility(View.INVISIBLE);
        dealedAgent2.setVisibility(View.INVISIBLE);
        observer = flagmentListener.setFirstDeal(allDeck, selectAgent);
        prepareView(observer);
        side.setImageResource(flagmentListener.getSideViewID(observer.player.side));
        agent.setImageResource(flagmentListener.getAgentViewID(selectAgent));
        hands = observer.player.hands;
        btn_hand.setEnabled(false);
        btn_possess.setEnabled(true);
        adapter = new MyAdapter(flagmentListener, hands, observer);
        recyclerView.setAdapter(adapter);
        /* CPUのエージェント等を用意 */
        getActivity().findViewById(R.id.statusCPU).setVisibility(View.VISIBLE);
        for(int i = 0; i<observer.playerList.size()-1; i++) {
            if (observer.playerList.get(i).agent.agentAttribute != AgentAttribute.SECRET) {
                agentCPUs[i].setImageResource(flagmentListener.getAgentViewID(observer.playerList.get(i).agent));
            } else {
                agentCPUs[i].setImageResource(R.drawable.agentback);
            }
        }

    }

    public void prepareView(Observer observer){
        for(int i=0; i<observer.playerList.size()-1; i++){
            for(int j=1; j<=10; j++){
                observer.playerList.get(i).possessView[j-1] = (ImageView) getActivity().findViewById(getResources().getIdentifier("table_cpu"+(i+1)+"possesseion"+j, "id", getActivity().getPackageName()));
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

    protected void addItem(/*StrategyCard strategyCard*/) {
        //hands.add(strategyCard);
        adapter.notifyDataSetChanged();
    }



    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    public void setPhasetxt(Phase phase){
        phasetxt.setText(phase.toString());
    }

    @Override
    public void startPhase(Observer observer){
        //observer.confirmAbility();
        setPhasetxt(observer.phase);
        observer.phase = Phase.FILL;
        fillPhase(observer);
    }

    @Override
    public void fillPhase(Observer observer){
        //observer.confirmAbility();
        Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
        addItem();
        observer.phase = Phase.STRATEGY;
        setPhasetxt(observer.phase);
        btn_next.setEnabled(true);

    }
    @Override
    public void strategyPhase(Observer observer){
        setPhasetxt(observer.phase);
    }
    @Override
    public void sendPhase(Observer observer){
        setPhasetxt(observer.phase);

    }
    @Override
    public void finishPhase(Observer observer){

    }


    /*
    public void startPhase(Observer observer){
        observer.confirmAbility();
        observer.phase = Phase.FILL;
        fillPhase(observer);
    }

    public void fillPhase(Observer observer){
        observer.confirmAbility();
        movement = new Movement();
        movement.Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
        observer.phase = Phase.STRATEGY;
        strategyPhase(observer);
    }

    public void strategyPhase(Observer observer){
        observer.confirmAbility();
        if(observer.playerList.get(observer.turn).playable){

        }else{

        }
        observer.phase = Phase.SEND;
        sendPhase(observer);
    }

    public void sendPhase(Observer observer){
        observer.confirmAbility();
        if(observer.messageNum > 1){
            //observer.sendedCard =
        }else{

        }
        observer.phase = Phase.FINISH;
        finishPhase(observer);
    }

    public void finishPhase(Observer observer){
        observer.confirmAbility();
        observer.nextTurn(observer.otamo);
        startPhase(observer);
    }
*/



    /* MovementFunc 実装 */
    @Override
    public void Draw(Player player, int num, AllDeck deck) {
        for(int i=0; i<num; i++) {
            player.hands.add(deck.strategyDeck.getFirst());
            deck.strategyDeck.removeFirst();
        }
    }

    @Override
    public void Possession(Player possessPlayer, ArrayList<StrategyCard> possessCards) {
        for (int i = 0; i < possessCards.size(); i++) {
            possessPlayer.possession.add(possessCards.get(i));
        }
    }

    @Override
    public void Dump(Player dumpPlayer, ArrayList<StrategyCard> dumpCards) {
        for(int i=0; i<dumpCards.size(); i++){
            dumpPlayer.hands.remove(dumpCards);
        }
    }

    @Override
    public void LockOn(Player player) {
        player.lockon = Lockon.LOCKON;
    }

    @Override
    public void Lost(Player player) {
        player.lockon = Lockon.LOST;
    }

    @Override
    public void Decode(Player player, ArrayList<StrategyCard> turnedCard) {

    }

    @Override
    public void Shuffle(AllDeck deck) {
        Collections.shuffle(deck.strategyDeck);
    }

    @Override
    public void PutOnTheDeck(ArrayList<StrategyCard> strategyCards, AllDeck deck) {
        for(int i=0;i<strategyCards.size();i++){
            deck.strategyDeck.addFirst(strategyCards.get(i));
        }
    }

    @Override
    public void Delete(Player deletePlayer, ArrayList<StrategyCard> deletedCards) {
        deletePlayer.possession.remove(deletedCards);
    }

    @Override
    public void Steal(Player player, Player enemy, ArrayList<StrategyCard> stealedCards) {
        enemy.hands.remove(stealedCards);
        player.hands.addAll(stealedCards);
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
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        final StrategyCard data;
        final int index = position;

        data = list.get(position);
        holder.imageView.setImageResource(flagmentListener.getStrategyViewID(data));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(observer.player.mode == ListMode.HANDS) {
                    switch (observer.phase) {
                        /* 諜略フェイズ中に手札を選択した場合 */
                        case STRATEGY:
                            break;
                        case SEND:
                            observer.sendedCard = data;
                            if(data.sendMethod == SendMethod.RELEASE)   observer.sendedCardState = true;
                            else    observer.sendedCardState = false;

                            for(int i=1; i<observer.playerList.size(); i++){
                                int tmp = observer.turn+i;
                                if(tmp>=observer.playerList.size()){
                                    if(selectPossess(observer.playerList.get(tmp-observer.playerList.size()), data)) break;
                                }else{
                                    if(selectPossess(observer.playerList.get(tmp), data)) break;
                                }
                            }
                            observer.playerList.get(observer.turn).possession.add(data);
                            //notifyItemInserted(0);
                            removeFromDataset(data);
                            break;


                    }
                    //removeFromDataset(data);
                }
            }
        });
    }

    public boolean selectPossess(Player player, StrategyCard strategyCard){

        switch (strategyCard.color) {
            case RED:
                player.possessView[player.possession.size()].setBackgroundColor(android.graphics.Color.parseColor("#ff0000"));
                player.possession.add(strategyCard);
                break;
            case BLUE:
                player.possessView[player.possession.size()].setBackgroundColor(android.graphics.Color.parseColor("#0000ff"));
                player.possession.add(strategyCard);
                break;
            case BLACK:
                player.possessView[player.possession.size()].setBackgroundColor(android.graphics.Color.parseColor("#000000"));
                player.possession.add(strategyCard);
                break;
        }

        return false;
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