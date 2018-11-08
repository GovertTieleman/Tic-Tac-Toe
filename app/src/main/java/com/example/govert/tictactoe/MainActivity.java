package com.example.govert.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
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
        Log.d("Row: ", String.valueOf(row));
        Log.d("column", String.valueOf(column));

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
//        check won
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
