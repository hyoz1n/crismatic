package com.example.crismatic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Clases.Administrador;
import Clases.Insumos;

public class MainActivity extends AppCompatActivity
{
    private EditText usuario, contraseña;
    private TextView msj;
    private Button btn;
    private Administrador admin1 = new Administrador();
    private Insumos insumos = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.idUsuario);
        contraseña = findViewById(R.id.idContraseña);
        msj = findViewById(R.id.tvsesion);
        btn = findViewById(R.id.btn);

    }

    public void Sesion(View view)
    {
        String user = usuario.getText().toString().trim();
        String password = contraseña.getText().toString().trim();

        String userObj = admin1.getUser().toString().trim();
        String passObj = admin1.getPass().toString().trim();

        switch (user)
        {
            case "Cristian":
                if(user.equals(userObj) && password.equals(passObj))
                {
                    //inicio sesión
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                break;
            case " ":
                if(user.equals(" ") && password.equals(" "))
                {
                    msj.setText("Porfavor rellene los campos vacios");
                }
                break;
            default:
                if(!user.equals(userObj) && password.equals(passObj))
                {
                    msj.setText("Porfavor ingrese los campos correctamente");
                }
                break;
        }
    }
    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com//"));
        startActivity(i);
    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.Twitter.com//"));
        startActivity(i);
    }
    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}