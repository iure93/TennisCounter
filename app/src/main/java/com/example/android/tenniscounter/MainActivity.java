package com.example.android.tenniscounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counterPointA = 0;
    int counterPointB = 0;
    int gameA = 0;
    int gameB = 0;
    int setA = 0;
    int setB = 0;
    int pointA;
    int pointB;
    TextView displayCurrentPointA;
    TextView displayCurrentPointB;
    TextView displayGameA;
    TextView displayGameB;
    TextView displaySetA;
    TextView displaySetB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView currentGameScoreBTextView = (TextView) findViewById(R.id.current_game_score_b);
        TextView currentGameScoreATextView = (TextView) findViewById(R.id.current_game_score_a);
        TextView gameScoreATextView = (TextView) findViewById(R.id.game_score_a);
        TextView gameScoreBTextView = (TextView) findViewById(R.id.game_score_b);
        TextView setScoreATextView = (TextView) findViewById(R.id.set_score_a);
        TextView setScoreBTextView = (TextView) findViewById(R.id.set_score_b);
        displayCurrentPointA = currentGameScoreATextView;
        displayCurrentPointB = currentGameScoreBTextView;
        displayGameA = gameScoreATextView;
        displayGameB = gameScoreBTextView;
        displaySetA = setScoreATextView;
        displaySetB = setScoreBTextView;

        if (savedInstanceState != null) {
            pointA = savedInstanceState.getInt("pointA");
            pointB = savedInstanceState.getInt("pointB");
            counterPointA = savedInstanceState.getInt("counterPointA");
            counterPointB = savedInstanceState.getInt("counterPointB");
            gameA = savedInstanceState.getInt("gameA");
            gameB = savedInstanceState.getInt("gameB");
            setA = savedInstanceState.getInt("setA");
            setB = savedInstanceState.getInt("setB");
        }
        //refresh text point a and b
        if (pointA == 1 || pointA == 3) {
            displayCurrentPointA.setText("Game");
        } else if (pointA == 2) {
            displayCurrentPointA.setText("Adv");
        } else {
            displayCurrentPointA.setText(String.valueOf(pointA));
        }
        if (pointB == 1 || pointB == 3) {
            displayCurrentPointB.setText("Game");
        } else if (pointB == 2) {
            displayCurrentPointB.setText("Adv");
        } else {
            displayCurrentPointB.setText(String.valueOf(pointB));
        }
        //refresh text game di a
        displayGameA.setText(String.valueOf(gameA));
        //refresh text game di b
        displayGameB.setText(String.valueOf(gameB));
        //refresh text set di a
        displaySetA.setText(String.valueOf(setA));
        //refresh text set di b
        displaySetB.setText(String.valueOf(setB));
    }

    //save the data
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("pointA", pointA);
        savedInstanceState.putInt("pointB", pointB);
        savedInstanceState.putInt("counterPointA", counterPointA);
        savedInstanceState.putInt("counterPointB", counterPointB);
        savedInstanceState.putInt("gameA", gameA);
        savedInstanceState.putInt("gameB", gameB);
        savedInstanceState.putInt("setA", setA);
        savedInstanceState.putInt("setB", setB);
        super.onSaveInstanceState(savedInstanceState);
    }


    //add point A

    public void add_point_a(View view) {
        counterPointA += 1;

        if (counterPointA == 1) {
            pointA = 15;
            displayCurrentPointA.setText(String.valueOf(pointA));
        } else if (counterPointA == 2) {
            pointA = 30;
            displayCurrentPointA.setText(String.valueOf(pointA));
        } else if (counterPointA == 3) {
            pointA = 40;
            displayCurrentPointA.setText(String.valueOf(pointA));
        } else if (counterPointA == 4 && counterPointB != 3 && counterPointB != 4) {
            pointA = 1;
            displayCurrentPointA.setText("Game");
            counterPointA = 10;
            counterPointB = 10;
        } else if (counterPointA == 4 && counterPointB == 3) {
            pointA = 2;
            displayCurrentPointA.setText("Adv");
        } else if (counterPointA == 5 && counterPointB == 3) {
            pointA = 3;
            displayCurrentPointA.setText("Game");
            counterPointB = 10;

        } else if (counterPointA == 4 && counterPointB == 4) {
            pointA = 40;
            pointB = 40;

            displayCurrentPointA.setText(String.valueOf(pointA));
            displayCurrentPointB.setText(String.valueOf(pointB));
            counterPointB = 3;
            counterPointA = 3;
        }


    }

    //reset point A
    public void resetPointA(View view) {
        counterPointA = 0;
        displayCurrentPointA.setText("0");
    }

    //add game A

    public void
    gameA(View view) {
        gameA += 1;

        displayGameA.setText(String.valueOf(gameA));
    }
    //reset Game A

    public void resetGameA(View view) {
        gameA = 0;
        displayGameA.setText("0");
    }
    //add set A

    public void setA(View view) {
        setA += 1;

        displaySetA.setText(String.valueOf(setA));
    }


    //reset set A
    public void resetSetA(View view) {
        setA = 0;
        displaySetA.setText("0");
    }

    //add point b


    public void add_point_b(View view) {
        counterPointB += 1;

        if (counterPointB == 1) {
            pointB = 15;
            displayCurrentPointB.setText(String.valueOf(pointB));
        } else if (counterPointB == 2) {
            pointB = 30;
            displayCurrentPointB.setText(String.valueOf(pointB));
        } else if (counterPointB == 3) {
            pointB = 40;
            displayCurrentPointB.setText(String.valueOf(pointB));
        } else if (counterPointB == 4 && counterPointA != 3 && counterPointA != 4) {
            pointB = 1;
            displayCurrentPointB.setText("Game");
            counterPointA = 10;
            counterPointB = 10;
        } else if (counterPointB == 4 && counterPointA == 3) {
            pointB = 2;
            displayCurrentPointB.setText("Adv");
        } else if (counterPointB == 5 && counterPointA == 3) {
            pointB = 3;
            displayCurrentPointB.setText("Game");
            counterPointA = 10;

        } else if (counterPointB == 4 && counterPointA == 4) {
            pointA = 40;
            pointB = 40;

            displayCurrentPointA.setText(String.valueOf(pointA));
            displayCurrentPointB.setText(String.valueOf(pointB));
            counterPointB = 3;
            counterPointA = 3;
        }


    }

    //reset point b
    public void resetPointB(View view) {
        counterPointB = 0;
        displayCurrentPointB.setText("0");
    }

    //add game b
    public void gameB(View view) {
        gameB += 1;
        displayGameB.setText(String.valueOf(gameB));
    }

    //reset game b
    public void resetGameB(View view) {
        gameB = 0;
        displayGameB.setText("0");
    }

    //add set b
    public void setB(View view) {
        setB += 1;
        displaySetB.setText(String.valueOf(setB));
    }

    //reset set b

    public void resetSetB(View view) {
        setB = 0;
        displaySetB.setText("0");
    }
}
