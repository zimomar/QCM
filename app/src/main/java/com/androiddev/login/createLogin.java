package com.androiddev.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createLogin extends Activity {
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_login);
        final Button validerButton = (Button)
                findViewById(R.id.connect);
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si un des deux champs est vide, alors on affiche
                //l'erreurs
                final EditText login = (EditText)
                        findViewById(R.id.user_email);
                final EditText pass = (EditText)
                        findViewById(R.id.user_password);
                final String loginTxt = login.getText().toString();
                final String passTxt = pass.getText().toString();
                if (loginTxt.equals("") || passTxt.equals("")) {
                    Toast.makeText(createLogin.this,
                            R.string.email_or_password_empty,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // On déclare le pattern que l’on doit vérifier
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                // On déclare un matcher, qui comparera le pattern avec
                //la
                // string passée en argument
                Matcher m = p.matcher(loginTxt);
                // Si l’adresse mail saisie ne correspond au format
                //d’une
                // adresse mail on un affiche un message à l'utilisateur
                if (!m.matches()) {
                    // Toast est une classe fournie par le SDK Android
// pour afficher les messages (indications) à
                    //l'intention de
                    // l'utilisateur. Ces messages ne possédent pas
                    //d'interaction avec l'utilisateur
                    // Le premier argument représente le contexte, puis
// le message et à la fin la durée d'affichage du Toast (constante

                    // LENGTH_SHORT ou LENGTH_LONG). Sans oublier
                    //d'appeler la méthode
                    //show pour afficher le Toast
                    Toast.makeText(createLogin.this,
                            R.string.email_format_error,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passTxt.length() < 8) {
                    Toast.makeText(createLogin.this,
                            R.string.pass_format_error,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                finish();
            }
        });
    }

    @Override
    public void finish() {
        // Prepare data intent
        EditText loginDisplay = (EditText)
                findViewById(R.id.user_email);
        EditText passwordDisplay = (EditText)
                findViewById(R.id.user_password);
        String loginTxt = loginDisplay.getText().toString();
        String passTxt = passwordDisplay.getText().toString();
        Intent data = new Intent();
        data.putExtra("user_login", loginTxt);
        data.putExtra("user_password", passTxt);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }
}