package com.bryan.swapi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaConsulta(View view){

        String url = "https://swapi.dev/api/films/";

        EditText txtID = findViewById(R.id.txtID);
        url += txtID.getText().toString();

        TextView titulo = findViewById(R.id.titulo);
        TextView diretor = findViewById(R.id.diretor);

        new DataGetter(titulo, diretor).execute(url);

    }
}