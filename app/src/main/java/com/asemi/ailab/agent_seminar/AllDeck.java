package com.asemi.ailab.agent_seminar;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Collections;

/**
 * Created by wataru on 17/02/17.
 */

public class AllDeck {
    LinkedList<StrategyCard> alldeck = new LinkedList<StrategyCard>();

    public AllDeck() {
        for (Strategy strategy : Strategy.values()) {
            switch (strategy) {
                case TRANSFER:    // 転送
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case TRAP:        // 誤導
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case COUNTERACT:  // 阻止
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case LOCKON:      // 捕捉
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 4; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case DISTRIBUTE:  // 分配
                    alldeck.addFirst(new StrategyCard(strategy, Color.RED));
                    alldeck.addFirst(new StrategyCard(strategy, Color.BLUE));
                    break;
                case DELETE:      // 削除
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 2; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case DECODE:      // 解読
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 2; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case PROVE:       // 証明
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 4; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                case INTERCEPT:   // 奪取
                    for (Color color : Color.values()) {
                        for (int i = 0; i < 3; i++) {
                            alldeck.addFirst(new StrategyCard(strategy, color));
                        }
                    }
                    break;
                default:
                    System.err.println();
                    break;
            }
        }

        Collections.shuffle(alldeck);
    }


}
