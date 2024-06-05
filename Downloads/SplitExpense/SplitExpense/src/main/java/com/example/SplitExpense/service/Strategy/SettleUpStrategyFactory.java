package com.example.SplitExpense.service.Strategy;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(){
        return new HeapBasedSettleUpStrategy();
    }
}
