package com.asemi.ailab.agent_seminar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;


public class GachaFlagment extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Button btn_b4, btn_m1, btn_m2;
    Button btn_gachaall, btn_gachab4, btn_gacham1, btn_gacham2;

    //ArrayList<Map<Agent, Boolean>> map;
    ArrayList<StrategyCard> hands, possession;
    FlagmentListener flagmentListener;
    ListMode mode = ListMode.HANDS;

    Gacha m1gacha, m2gacha, b4gacha, allgacha;
    GachaList gachaList;
    ArrayList<AgentName> alllist= new ArrayList<>();
    ArrayList<AgentName> b4list = new ArrayList<>();
    ArrayList<AgentName> m1list = new ArrayList<>();
    ArrayList<AgentName> m2list = new ArrayList<>();

    Dialog dialog;
    ImageView iv;
    AgentName gachaAgent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // 先ほどのレイアウトをここでViewとして作成します
        return inflater.inflate(R.layout.fragment_gacha, container, false);
    }

    // Viewが生成し終わった時に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // getActivity().findViewById(R.id.statusCPU).setVisibility(View.INVISIBLE);
        /* ガチャで出たエージェントのリスト */
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_cards);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        /* ガチャの */
        gachaList = new GachaList();
        for(AgentName agentName : AgentName.values()){
            alllist.add(agentName);
            switch (agentName.grade) {
                case Y15:
                    m2list.add(agentName);
                    break;
                case Y16:
                    m1list.add(agentName);
                    break;
                case Y17:
                    b4list.add(agentName);
                    break;
            }
        }
        allgacha = new Gacha(alllist);
        b4gacha = new Gacha(b4list);
        m1gacha = new Gacha(m1list);
        m2gacha = new Gacha(m2list);

/*
        Collections.shuffle(m2list);
        Collections.shuffle(m1list);
        Collections.shuffle(b4list);
*/

        btn_b4 = (Button) getActivity().findViewById(R.id.btn_b4);
        btn_b4.setOnClickListener(this);
        btn_m1 = (Button) getActivity().findViewById(R.id.btn_m1);
        btn_m1.setOnClickListener(this);
        btn_m2 = (Button) getActivity().findViewById(R.id.btn_m2);
        btn_m2.setOnClickListener(this);

        btn_gachaall = (Button) getActivity().findViewById(R.id.btn_gachaall);
        btn_gachaall.setOnClickListener(this);
        btn_gachab4 = (Button) getActivity().findViewById(R.id.btn_gachab4);
        btn_gachab4.setOnClickListener(this);
        btn_gacham1 = (Button) getActivity().findViewById(R.id.btn_gacham1);
        btn_gacham1.setOnClickListener(this);
        btn_gacham2 = (Button) getActivity().findViewById(R.id.btn_gacham2);
        btn_gacham2.setOnClickListener(this);

        btn_b4.setEnabled(true);
        btn_m1.setEnabled(true);
        btn_m2.setEnabled(true);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_b4:
                btn_b4.setEnabled(false);
                btn_m1.setEnabled(true);
                btn_m2.setEnabled(true);
                adapter = new MyAdapter_Gacha(flagmentListener, b4list, gachaList);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_m1:
                btn_b4.setEnabled(true);
                btn_m1.setEnabled(false);
                btn_m2.setEnabled(true);
                adapter = new MyAdapter_Gacha(flagmentListener, m1list, gachaList);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_m2:
                btn_b4.setEnabled(true);
                btn_m1.setEnabled(true);
                btn_m2.setEnabled(false);
                adapter = new MyAdapter_Gacha(flagmentListener, m2list, gachaList);
                recyclerView.setAdapter(adapter);
                break;

            case R.id.btn_gachaall:
                gachaAgent = allgacha.playGacha();
                gachaList.gachaMap.put(gachaAgent, true);
                showDialog(flagmentListener.getAgentViewID(gachaAgent, true));
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_gachab4:
                gachaAgent = b4gacha.playGacha();
                gachaList.gachaMap.put(gachaAgent, true);
                showDialog(flagmentListener.getAgentViewID(gachaAgent, true));
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_gacham1:
                gachaAgent = m1gacha.playGacha();
                gachaList.gachaMap.put(gachaAgent, true);
                showDialog(flagmentListener.getAgentViewID(gachaAgent, true));
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_gacham2:
                gachaAgent = m2gacha.playGacha();
                gachaList.gachaMap.put(gachaAgent, true);
                showDialog(flagmentListener.getAgentViewID(gachaAgent, true));
                recyclerView.setAdapter(adapter);
                break;

        }
    }

    public void showDialog(int id){
        iv = new ImageView(getActivity());
        iv.setImageResource(id);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setAdjustViewBounds(true);
        dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(iv);

        dialog.show();
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



    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    public interface FlagmentListener{
        public int getAgentViewID(AgentName agentName, boolean already);
    }

}

class MyAdapter_Gacha extends RecyclerView.Adapter<MyAdapter_Gacha.ItemViewHolder> {
    GachaFlagment.FlagmentListener flagmentListener;
    GachaList gachaList;

    ArrayList<AgentName> list;
    Observer observer;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ItemViewHolder(View v){
            super(v);
            imageView = (ImageView)v.findViewById(R.id.img_elem);
        }
    }
    public MyAdapter_Gacha(GachaFlagment.FlagmentListener flagmentListener, ArrayList<AgentName> agents, GachaList gachaList){
        this.flagmentListener = flagmentListener;
        this.list = agents;
        this.gachaList = gachaList;
        this.observer = observer;
    }
    @Override public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()) .inflate(R.layout.list_strategy, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final AgentName agent;
        final int index = position;

        agent = list.get(position);
        holder.imageView.setImageResource(flagmentListener.getAgentViewID(agent, gachaList.gachaMap.get(agent)));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                /*if(observer.player.mode == ListMode.HANDS) {
                    removeFromDataset(agent);
                }*/
            }
        });
    }

    @Override public int getItemCount() {
        return list.size();
    }

    protected void removeFromDataset(AgentName data){
        /*for(int i = 0; i< list.size(); i++){
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
        }*/
    }

}