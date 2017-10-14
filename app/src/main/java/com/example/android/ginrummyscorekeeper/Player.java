package com.example.android.ginrummyscorekeeper;
import java.util.Stack;

public class Player {
    private Metric score;
    private Stack scoreHistory;
    private Metric deadwood;
    final int bonusGin = 20;
    final int bonusBigGin = 25;
    final int bonusKnock = 12;

    Player(int scoreId, int deadwoodId){
        score = new Metric(scoreId);
        scoreHistory = new Stack();
        scoreHistory.push(score.getValue());
        deadwood = new Metric(deadwoodId);
    }

    public Metric getDeadwood(){
        return deadwood;
    }

    public Metric getScore(){
        return score;
    }

    private void addPoints(int points, Player opponent){
        score.change(points);
        scoreHistory.push(score.getValue());
        this.deadwood.setValue(0);
        opponent.getDeadwood().setValue(0);
    }

    public void knock(Player opponent){
        if(this.deadwood.getValue() < opponent.getDeadwood().getValue()){
            int handPoints = opponent.getDeadwood().getValue() - this.deadwood.getValue();
            this.addPoints(handPoints, opponent);
        }
        else {
            int handPoints = bonusKnock + this.deadwood.getValue() - opponent.getDeadwood().getValue();
            opponent.addPoints(handPoints,this);
        }
    }

    public void gin(Player opponent){
        int handPoints = opponent.getDeadwood().getValue() + bonusGin;
        this.addPoints(handPoints,opponent);
    }

    public void bigGin(Player opponent){
        int handPoints = opponent.getDeadwood().getValue() + bonusBigGin;
        this.addPoints(handPoints,opponent);
    }
}

