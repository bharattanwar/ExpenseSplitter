package com.example.SplitExpense.Strategy;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(){
        return new HeapBasedSettleUpStrategy();
    }
}
