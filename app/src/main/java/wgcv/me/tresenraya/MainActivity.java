package wgcv.me.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nombre1, nombre2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jugar(View view){

        nombre1 = (EditText) findViewById(R.id.et_nombre1);
        nombre2 = (EditText) findViewById(R.id.et_nombre2);
if(!(nombre1.getText().toString().equalsIgnoreCase("")||nombre2.getText().toString().equalsIgnoreCase(""))){



        Intent jugar = new Intent(getApplicationContext(), Jugar.class);
        jugar.putExtra("nombre1",nombre1.getText().toString());
        jugar.putExtra("nombre2",nombre2.getText().toString());
        startActivity(jugar);
}
    }
}
