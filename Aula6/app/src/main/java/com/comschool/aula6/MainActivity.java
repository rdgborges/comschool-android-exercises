package com.comschool.aula6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;
    private EditText nameEditText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.name_text_view);
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        button = (Button) findViewById(R.id.add_button);

        updateNameTextView();

    }

    // Armazena nome nas SharedPreferences
    public void addButtonClicked(View view) {
        final String name = nameEditText.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aula 6 ComSchool");
        builder.setMessage("Você deseja salvar o nome " + name + " nas preferências?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                int idadeInt;

                try {
                    String idade = nameEditText.getText().toString();
                    idadeInt = Integer.parseInt(idade);

                } catch(NumberFormatException e) {
                    idadeInt = 0;
                }

                editor.putString("nameKey", name);
                editor.putInt("age", idadeInt);

                editor.commit();

                updateNameTextView();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void removeButtonClicked(View view) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.remove("nameKey");

        editor.commit();

        updateNameTextView();

        nameEditText.setText("");
    }

    private void updateNameTextView() {
        // Checa se há nome salvo
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String name = prefs.getString("nameKey", "");

        if (name.isEmpty()) {
            nameTextView.setText(getString(R.string.no_name));
        } else {
            nameTextView.setText("O nome cadastrado é " + name);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Clicou nas Configurações!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Sobre");
                builder.setMessage("Esse aplicativo foi desenvolvido durante a aula 6 do curso de Android da ComSchool.");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
