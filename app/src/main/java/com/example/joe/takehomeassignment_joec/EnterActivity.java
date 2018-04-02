package com.example.joe.takehomeassignment_joec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnterActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference logRef = database.getReference("log");
    private DatabaseReference pokemonRef = database.getReference("pokemon");

    public EditText log ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        Intent intent = getIntent();
        final String date = intent.getStringExtra("KEY_LOG");
        log = (EditText) findViewById(R.id.log_text);
        log.setText(date);

        Button logButton = (Button) findViewById(R.id.log_button);
        logButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                logRef.setValue(log.getText().toString());
            }

        });

        Button pokemonButton = (Button) findViewById(R.id.pokemon_button);
        pokemonButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name_text);
                EditText number = (EditText) findViewById(R.id.number_text);
                CheckBox isCaught = (CheckBox) findViewById(R.id.caught_checkbox);

                String putName = name.getText().toString();
                int putNumber = Integer.valueOf(number.getText().toString());
                boolean putIsCaught = isCaught.isChecked();
                Pokemon person = new Pokemon(putName, putNumber, putIsCaught);
                pokemonRef.push().setValue(person);
            }
        });

    }
}

