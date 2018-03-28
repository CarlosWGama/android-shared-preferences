package br.com.carloswgama.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
        String login = preferences.getString("login", "");
        if (!login.equals("")) {
            //Redireciona
            startActivity(new Intent(this, SegundaActivity.class));
        }
    }

    public void logar(View v) {
        EditText campoLogin = findViewById(R.id.et_login);
        String login = campoLogin.getText().toString();

        EditText campoSenha = findViewById(R.id.et_senha);
        String senha = campoSenha.getText().toString();

        if (login.equals("teste@teste.com") && senha.equals("123456")) {
            //Salva o Login
            SharedPreferences.Editor editor = getSharedPreferences("app", MODE_PRIVATE).edit();
            editor.putString("login", login);
            editor.apply();
            //Redireciona
            startActivity(new Intent(this, SegundaActivity.class));
        }
    }
}
