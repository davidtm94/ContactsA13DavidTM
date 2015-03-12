package com.example.david.contactsa13davidtm;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class ContactsA13DavidTM extends Activity {
    ClaseBBDD clasebd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_a13_david_tm);
        clasebd=new ClaseBBDD(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts_a13_david_tm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void gardarContacto(View v){
        // Gets the data repository in write mode
        SQLiteDatabase db = clasebd.getWritableDatabase();
        EditText edNome=(EditText) findViewById(R.id.edNome);
        EditText edTelefono=(EditText) findViewById(R.id.edTelefono);

        // cREAMOS UN MAPA DE VALORES
        ContentValues values = new ContentValues();
        values.put(clasebd.CAMPO_NOME, edNome.getText().toString());
        values.put(clasebd.CAMPO_NUMERO, edTelefono.getText().toString());
        db.insert(ClaseBBDD.NOME_TABLA, null,values);
        Toast toast=Toast.makeText(this, "Contacto insertado", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void consultarAxenda(View v){
        SQLiteDatabase db = clasebd.getReadableDatabase();
        String[] projection = {
                clasebd.CAMPO_NOME,
                clasebd.CAMPO_NUMERO
        };
        String sortOrder =
                clasebd.CAMPO_NOME + " DESC";
        Cursor c=db.query(clasebd.NOME_TABLA,projection,null,null,null,null,sortOrder);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1 );
        c.moveToFirst();
        arrayAdapter.add(c.getString(0));
        arrayAdapter.add(c.getString(1));
        while(c.moveToNext()) {
            arrayAdapter.add(c.getString(0));
            arrayAdapter.add(c.getString(1));
        }
        ListView lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(arrayAdapter);

    }
}
