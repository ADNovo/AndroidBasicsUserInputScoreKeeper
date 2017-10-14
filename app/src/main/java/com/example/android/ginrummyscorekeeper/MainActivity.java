package com.example.android.ginrummyscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.id;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    Player playerA = new Player(R.id.player_a_score, R.id.player_a_deadwood);
    Player playerB = new Player(R.id.player_b_score, R.id.player_b_deadwood);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void display(Metric metric) {
        TextView metricView = (TextView) findViewById(metric.getId());
        metricView.setText(String.valueOf(metric.getValue()));
    }

    public void reset(View view){
        playerA.getDeadwood().setValue(0);
        playerB.getDeadwood().setValue(0);
        playerA.getScore().setValue(0);
        playerB.getScore().setValue(0);

        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
        display(playerA.getScore());
        display(playerB.getScore());
    }

    public void incrementDeadwoodOfPlayerA(View view){
        playerA.getDeadwood().change(1);
        display(playerA.getDeadwood());
    }

    public void incrementDeadwoodOfPlayerB(View view){
        playerB.getDeadwood().change(1);
        display(playerB.getDeadwood());
    }

    public void decrementDeadwoodOfPlayerA(View view){
        playerA.getDeadwood().change(-1);
        display(playerA.getDeadwood());
    }

    public void decrementDeadwoodOfPlayerB(View view){
        playerB.getDeadwood().change(-1);
        display(playerB.getDeadwood());
    }

    public void knockOfPlayerA(View view){
        playerA.knock(playerB);
        display(playerA.getScore());
        display(playerB.getScore());
        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
    }

    public void knockOfPlayerB(View view){
        playerB.knock(playerA);
        display(playerA.getScore());
        display(playerB.getScore());
        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
    }

    public void ginOfPlayerA(View view){
        playerA.gin(playerB);
        display(playerA.getScore());
        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
    }

    public void ginOfPlayerB(View view){
        playerB.gin(playerA);
        display(playerB.getScore());
        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
    }

    public void bigGinOfPlayerA(View view){
        playerA.bigGin(playerB);
        display(playerA.getScore());
        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
    }

    public void bigGinOfPlayerB(View view){
        playerB.bigGin(playerA);
        display(playerB.getScore());
        display(playerA.getDeadwood());
        display(playerB.getDeadwood());
    }
}