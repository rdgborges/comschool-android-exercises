package com.comschool.aula4ex2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView pokemonImageView = (ImageView) findViewById(R.id.pokemon_image_view);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", 0);

        Drawable pokemonImage;

        if (position == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pokemonImage = getResources().getDrawable(R.drawable.charmander, getTheme());
            } else {
                pokemonImage = getResources().getDrawable(R.drawable.charmander);
            }
        } else if (position == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pokemonImage = getResources().getDrawable(R.drawable.squirtle, getTheme());
            } else {
                pokemonImage = getResources().getDrawable(R.drawable.squirtle);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pokemonImage = getResources().getDrawable(R.drawable.bulbasaur, getTheme());
            } else {
                pokemonImage = getResources().getDrawable(R.drawable.bulbasaur);
            }
        }

        pokemonImageView.setImageDrawable(pokemonImage);
    }
}
