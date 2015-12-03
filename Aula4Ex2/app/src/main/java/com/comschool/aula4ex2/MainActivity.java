package com.comschool.aula4ex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mPokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(getString(R.string.choose_your_pokemon));

        mPokemonList = (ListView) findViewById(R.id.pokemon_list);

        ArrayList<String> pokemons = new ArrayList<>();
        pokemons.add("Charmander");
        pokemons.add("Squirtle");
        pokemons.add("Bulbasaur");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pokemons);

        mPokemonList.setAdapter(listAdapter);

        mPokemonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PokemonActivity.class);
                intent.putExtra("position", position);

                startActivity(intent);
            }
        });

    }
}
