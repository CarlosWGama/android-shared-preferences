package br.com.carloswgama.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        TextView textView = findViewById(R.id.tv_exibir_login);

        SharedPreferences preferences = getSharedPreferences("app",MODE_PRIVATE);
        textView.setText(preferences.getString("login", ""));
    }


    public void deslogar(View v) {
        SharedPreferences.Editor editor = getSharedPreferences(
                "app",
                MODE_PRIVATE)
                .edit();
        editor.remove("login");
        editor.apply();
        finish();
    }
}
