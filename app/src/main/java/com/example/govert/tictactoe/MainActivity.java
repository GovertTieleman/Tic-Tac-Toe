package com.example.govert.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Game game;
    private String s1, s2, s3, s4, s5, s6, s7, s8, s9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save button states
        s1 = ((Button) findViewById(R.id.button1)).getText().toString();
        outState.putString("b1", s1);
        s2 = ((Button) findViewById(R.id.button2)).getText().toString();
        outState.putString("b2", s2);
        s3 = ((Button) findViewById(R.id.button3)).getText().toString();
        outState.putString("b3", s3);
        s4 = ((Button) findViewById(R.id.button4)).getText().toString();
        outState.putString("b4", s4);
        s5 = ((Button) findViewById(R.id.button5)).getText().toString();
        outState.putString("b5", s5);
        s6 = ((Button) findViewById(R.id.button6)).getText().toString();
        outState.putString("b6", s6);
        s7 = ((Button) findViewById(R.id.button7)).getText().toString();
        outState.putString("b7", s7);
        s8 = ((Button) findViewById(R.id.button8)).getText().toString();
        outState.putString("b8", s8);
        s9 = ((Button) findViewById(R.id.button9)).getText().toString();
        outState.putString("b9", s9);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // load button states
        s1 = savedInstanceState.getString("b1");
        ((Button) findViewById(R.id.button1)).setText(s1);
        s2 = savedInstanceState.getString("b2");
        ((Button) findViewById(R.id.button2)).setText(s2);
        s3 = savedInstanceState.getString("b3");
        ((Button) findViewById(R.id.button3)).setText(s3);
        s4 = savedInstanceState.getString("b4");
        ((Button) findViewById(R.id.button4)).setText(s4);
        s5 = savedInstanceState.getString("b5");
        ((Button) findViewById(R.id.button5)).setText(s5);
        s6 = savedInstanceState.getString("b6");
        ((Button) findViewById(R.id.button6)).setText(s6);
        s7 = savedInstanceState.getString("b7");
        ((Button) findViewById(R.id.button7)).setText(s7);
        s8 = savedInstanceState.getString("b8");
        ((Button) findViewById(R.id.button8)).setText(s8);
        s9 = savedInstanceState.getString("b9");
        ((Button) findViewById(R.id.button9)).setText(s9);
    }

    public void tileClicked(View view) {
        // get id and declare row and column variables
        int id = view.getId();
        int row = 0;
        int column = 0;
        // find the row and column that correspond to the id
        switch(id) {
            case R.id.button1:
                row = 0;
                column = 0;
                break;
            case R.id.button2:
                row = 0;
                column = 1;
                break;
            case R.id.button3:
                row = 0;
                column = 2;
                break;
            case R.id.button4:
                row = 1;
                column = 0;
                break;
            case R.id.button5:
                row = 1;
                column = 1;
                break;
            case R.id.button6:
                row = 1;
                column = 2;
                break;
            case R.id.button7:
                row = 2;
                column = 0;
                break;
            case R.id.button8:
                row = 2;
                column = 1;
                break;
            case R.id.button9:
                row = 2;
                column = 2;
                break;
        }

        // update playing field if valid command
        TileState state = game.choose(row, column);
        switch(state) {
            case CROSS:
                ((Button) view).setText("X");
                break;
            case CIRCLE:
                ((Button) view).setText("O");
                break;
            case INVALID:
                Toast.makeText(MainActivity.this,"Invalid move!",
                        Toast.LENGTH_LONG).show();
                break;
        }
        // check won
        GameState gameState = game.won();
        if(gameState.equals(GameState.PLAYER_ONE_WIN)) {
            Toast.makeText(MainActivity.this,"Player 1 wins!",
                    Toast.LENGTH_LONG).show();
            resetBoard();
            game = new Game();
        }
        else if(gameState.equals(GameState.PLAYER_TWO_WIN)){
            Toast.makeText(MainActivity.this,"Player 2 wins!",
                    Toast.LENGTH_LONG).show();
            resetBoard();
            game = new Game();
        }
        else if(gameState.equals(GameState.DRAW)) {
            Toast.makeText(MainActivity.this,"Draw!",
                    Toast.LENGTH_LONG).show();
            resetBoard();
            game = new Game();
        }
    }

    public void resetClicked(View view) {
        resetBoard();
        game = new Game();
    }

    private void resetBoard() {
        ((Button) findViewById(R.id.button1)).setText("");
        ((Button) findViewById(R.id.button2)).setText("");
        ((Button) findViewById(R.id.button3)).setText("");
        ((Button) findViewById(R.id.button4)).setText("");
        ((Button) findViewById(R.id.button5)).setText("");
        ((Button) findViewById(R.id.button6)).setText("");
        ((Button) findViewById(R.id.button7)).setText("");
        ((Button) findViewById(R.id.button8)).setText("");
        ((Button) findViewById(R.id.button9)).setText("");
    }
}
