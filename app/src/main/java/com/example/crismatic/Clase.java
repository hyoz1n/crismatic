package com.example.crismatic;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crismatic.database.AdminSQLiteOpenHelper;

public class Clase extends AppCompatActivity {

    private EditText code, produc, cant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase);

        code = findViewById(R.id.code);
        produc = findViewById(R.id.produc);
        cant = findViewById(R.id.cant);
    }
    public void guardarProducto(View view){
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "crisformatic", null, 1);
    SQLiteDatabase db = admin.getWritableDatabase();

    String codigo = code.getText().toString();
    String producto = produc.getText().toString();
    String cantidad = cant.getText().toString();

    if(!codigo.isEmpty() && !producto.isEmpty() && !cantidad.isEmpty())
    {
    ContentValues cont = new ContentValues();
    cont.put("codigo", codigo);
    cont.put("producto", producto);
    cont.put("cantidad", cantidad);

    db.insert("producto", null, cont);
    Clean();
    db.close();
    Toast.makeText(getBaseContext(), "Has guardado el producto!", Toast.LENGTH_SHORT).show();

    }else{
        Toast.makeText(getBaseContext(), "Tiene campos vacios por favor verifique", Toast.LENGTH_SHORT).show();
    }

    }
    public void mostrarProducto(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "crisformatic", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        if(!codigo.isEmpty())
        {
        Cursor file = db.rawQuery("SELECT producto, cantidad FROM producto WHERE codigo="+codigo, null);
        if(file.moveToFirst()){
        produc.setText(file.getString(0));
        cant.setText(file.getString(1));
        }
        }else
            {
            Toast.makeText(getBaseContext(), "El codigo esta vacio", Toast.LENGTH_SHORT).show();
        }
    }
    public void eliminarProducto(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "crisformatic", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){
            db.delete("producto","codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Se ha elimiinado correctamente"+ codigo, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(),"El codigo no debe venir vacio", Toast.LENGTH_SHORT).show();

        }
    }
    public void actualizarProducto(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "crisformatic", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String producto = produc.getText().toString();
        String cantidad = cant.getText().toString();
        if(!codigo.isEmpty() && !producto.isEmpty() && !cantidad.isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("producto", producto);
            cont.put("cantidad", cantidad);

            db.update("producto", cont, "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has Actualizado!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(), "Campos vacios por favor rellenar", Toast.LENGTH_SHORT).show();
        }
    }
    public void Clean()
    {
        code.setText("");
        produc.setText("");
        cant.setText("");
    }
}