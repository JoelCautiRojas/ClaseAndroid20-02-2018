package com.example.pc_b_013.ejemplologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText user = findViewById(R.id.editText);
        final EditText pass = findViewById(R.id.editText2);
        Button iniciar = findViewById(R.id.button);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncHttpClient clienteWeb = new AsyncHttpClient();
                RequestParams parametros = new RequestParams();
                parametros.put("usuario",user.getText().toString());
                parametros.put("clave",pass.getText().toString());
                String direccion = "http://www.programadoresperuanos.com/test_app/login.php";
                clienteWeb.post(getApplicationContext(), direccion, parametros, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(statusCode == 200)
                        {
                            String respuesta = new String(responseBody);
                            if(respuesta.equals("correcto"))
                            {
                                Intent ventana2 = new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(ventana2);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrectos."+respuesta,Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Estatus desconocido",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(),"No se pudo conectar al servidor.",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
