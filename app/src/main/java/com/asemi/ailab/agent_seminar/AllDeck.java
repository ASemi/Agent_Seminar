package com.asemi.ailab.agent_seminar;

import java.util.LinkedList;
import java.util.Collections;

/**
 * Created by wataru on 17/02/17.
 */

public class AllDeck {
    LinkedList<StrategyCard> strategyDeck = new LinkedList<StrategyCard>();
    LinkedList<Agent> agentDeck = new LinkedList<>();
    LinkedList<Side> sideDeck = new LinkedList<>();

    public AllDeck() {
        prepareStrategyDeck();
        prepareAgentDeck();
        prepareSideDeck();
    }

    public void prepareStrategyDeck(){
        for (Strategy strategy : Strategy.values()) {
            switch (strategy) {
                case TRANSFER:    // 転送
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case TRAP:        // 誤導
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case COUNTERACT:  // 阻止
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case LOCKON:      // 捕捉
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 4; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case DISTRIBUTE:  // 分配
                    strategyDeck.addFirst(new StrategyCard(strategy, Color.RED));
                    strategyDeck.addFirst(new StrategyCard(strategy, Color.BLUE));
                    break;
                case DELETE:      // 削除
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 2; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case DECODE:      // 解読
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 2; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case PROVEDRAW:       // 証明（２枚ドロー）
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 2; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case PROVEDUMP:       // 証明（１枚捨て）
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 2; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case INTERCEPT:   // 奪取
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            strategyDeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                default:
                    System.err.println();
                    break;
            }
        }
        Collections.shuffle(strategyDeck);
    }

    public void prepareAgentDeck(){
        for(AgentName agentName : AgentName.values()){
            agentDeck.add(new Agent(agentName));
        }
        Collections.shuffle(agentDeck);
    }

    public void prepareSideDeck(){
        for(Side side : Side.values()){
            for(int i=0; i<3; i++){
                sideDeck.addFirst(side);
            }
        }
        Collections.shuffle(sideDeck);
    }




}
