package cz.uhk.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int countA = 0;
    private int countB = 0;
    private final int MAX_ADD = 1000;
    private TextView textViewA;
    private TextView textViewB;
    private EditText editTextA;
    private EditText editTextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        initAButtons();
        initBButtons();
        initAddButtons();
        initReset();
    }

    private void initComponents() {
        textViewA = (TextView) findViewById(R.id.counterA);
        textViewB = (TextView) findViewById(R.id.counterB);
        editTextA = (EditText) findViewById(R.id.inputPointsA);
        editTextB = (EditText) findViewById(R.id.inputPointsB);
    }

    private void initAButtons() {
        Button buttonA3 = (Button) findViewById(R.id.buttonA3);
        buttonA3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addToTeamA(3);
            }
        });

        Button buttonA2 = (Button) findViewById(R.id.buttonA2);
        buttonA2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addToTeamA(2);
            }
        });

        Button buttonA1 = (Button) findViewById(R.id.buttonA1);
        buttonA1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addToTeamA(1);
            }
        });
    }

    private void addToTeamA(int points) {
        countA += points;
        textViewA.setText(Integer.toString(countA));
    }

    private void initBButtons() {
        Button buttonB3 = (Button) findViewById(R.id.buttonB3);
        buttonB3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addToTeamB(3);
            }
        });

        Button buttonB2 = (Button) findViewById(R.id.buttonB2);
        buttonB2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addToTeamB(2);
            }
        });

        Button buttonB1 = (Button) findViewById(R.id.buttonB1);
        buttonB1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addToTeamB(1);
            }
        });
    }

    private void addToTeamB(int points) {
        countB += points;
        textViewB.setText(Integer.toString(countB));
    }

    private void initAddButtons() {
        Button addA = (Button) findViewById(R.id.addA);
        addA.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String value = editTextA.getText().toString();
                addToTeamA(checkInsertedValue(value));
                editTextA.setText("");
            }
        });
        Button addB = (Button) findViewById(R.id.addB);
        addB.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String value = editTextB.getText().toString();
                addToTeamB(checkInsertedValue(value));
                editTextB.setText("");
            }
        });
    }

    private int checkInsertedValue(String value) {
        if ("".equals(value)) {
            Toast.makeText(MainActivity.this, "You have to insert some number!",
                    Toast.LENGTH_LONG).show();
            return 0;
        } else {
            int val = Integer.parseInt(value);
            if (val > MAX_ADD) {
                Toast.makeText(MainActivity.this, "Insert less than " + MAX_ADD + "!",
                        Toast.LENGTH_LONG).show();
                return 0;
            } else if (countA > Integer.MAX_VALUE - val) {
                Toast.makeText(MainActivity.this, "Cannot add anymore points!",
                        Toast.LENGTH_LONG).show();
                return 0;
            } else {
                return val;
            }
        }
    }

    private void initReset() {
        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void reset() {
        countA = 0;
        addToTeamA(0);
        countB = 0;
        addToTeamB(0);
    }
}
