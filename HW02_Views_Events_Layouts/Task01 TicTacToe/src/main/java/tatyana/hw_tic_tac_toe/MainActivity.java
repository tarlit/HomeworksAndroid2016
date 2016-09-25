package tatyana.hw_tic_tac_toe;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);

        turn = 1;

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.b1) {
            processClick(b1);
        }
        if (view.getId() == R.id.b2) {
            processClick(b2);
        }
        if (view.getId() == R.id.b3) {
            processClick(b3);
        }
        if (view.getId() == R.id.b4) {
            processClick(b4);
        }
        if (view.getId() == R.id.b5) {
            processClick(b5);
        }
        if (view.getId() == R.id.b6) {
            processClick(b6);
        }
        if (view.getId() == R.id.b7) {
            processClick(b7);
        }
        if (view.getId() == R.id.b8) {
            processClick(b8);
        }
        if (view.getId() == R.id.b9) {
            processClick(b9);
        }
    }

    public void processClick(Button clickedBtn) {

        if(clickedBtn.getText().toString().equals("")) {

            if (turn == 1) {
                turn = 2;
                clickedBtn.setText("X");
            } else if (turn == 2) {
                turn = 1;
                clickedBtn.setText("O");
            }
        }

        endGame();
    }

    private void endGame() {
        String c11, c12, c13, c21, c22, c23, c31, c32, c33;
        boolean end = false;

        c11 = b1.getText().toString();
        c12 = b2.getText().toString();
        c13 = b3.getText().toString();
        c21 = b4.getText().toString();
        c22 = b5.getText().toString();
        c23 = b6.getText().toString();
        c31 = b7.getText().toString();
        c32 = b8.getText().toString();
        c33 = b9.getText().toString();

        if (c11.equals(c12) && c11.equals(c13) && c11.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c21.equals(c22) && c21.equals(c23) && c21.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c31.equals(c32) && c31.equals(c33) && c31.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c11.equals(c21) && c11.equals(c31) && c11.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c12.equals(c22) && c12.equals(c32) && c12.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c13.equals(c23) && c13.equals(c33) && c13.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c11.equals(c22) && c11.equals(c33) && c11.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c13.equals(c22) && c13.equals(c31) && c13.equals("X")) {
            Toast.makeText(MainActivity.this, "WINNER: Player X", Toast.LENGTH_SHORT).show();
            end = true;
        }

        if (c11.equals(c12) && c11.equals(c13) && c11.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c21.equals(c22) && c21.equals(c23) && c21.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c31.equals(c32) && c31.equals(c33) && c31.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c11.equals(c21) && c11.equals(c31) && c11.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c12.equals(c22) && c12.equals(c32) && c12.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c13.equals(c23) && c13.equals(c33) && c13.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c11.equals(c22) && c11.equals(c33) && c11.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }
        if (c13.equals(c22) && c13.equals(c31) && c13.equals("O")) {
            Toast.makeText(MainActivity.this, "WINNER: Player O", Toast.LENGTH_SHORT).show();
            end = true;
        }

        if ((c11.contains("O") || c11.contains("X")) && (c12.contains("O") || c12.contains("X")) && (c13.contains("O") || c13.contains("X")) &&
                (c21.contains("O") || c21.contains("X")) && (c22.contains("O") || c22.contains("X")) && (c23.contains("O") || c23.contains("X")) &&
                (c31.contains("O") || c31.contains("X")) && (c32.contains("O") || c32.contains("X")) && (c33.contains("O") || c33.contains("X")) &&
                !end) {
            Toast.makeText(MainActivity.this, "NO WINNER!", Toast.LENGTH_SHORT).show();
            end = true;
        }

        if (end) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Play Again!", Toast.LENGTH_SHORT).show();

                    turn = 1;
                    b1.setText("");
                    b2.setText("");
                    b3.setText("");
                    b4.setText("");
                    b5.setText("");
                    b6.setText("");
                    b7.setText("");
                    b8.setText("");
                    b9.setText("");
                }
            }, 2000);
        }
    }
}
