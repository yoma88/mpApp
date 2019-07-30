package com.example.mpapp.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.mpapp.R;
import com.example.mpapp.database.models.Producto;
import com.example.mpapp.database.models.ProductoAlmacen;
import com.example.mpapp.database.models.ProductoAlmacenDao;
import com.example.mpapp.database.models.ProductoDao;
import com.example.mpapp.database.models.ProductosDatabase;

public class MainActivity extends AppCompatActivity {

    private Context context;
    EditText skuText;
    Button skuSearchButton;
    LinearLayout infoProveedorSection;
    LinearLayout infoEstandarSection;
    LinearLayout infoAlternativaSection;
    EditText skuProveedorText;
    Button skuProveedorSearchButton;
    TextView productoDescripcionText;
    NumberPicker cantidadProveedorText;
    NumberPicker cantidadEstandarText;
    NumberPicker cantidadAlternativaText;

    TextView unidadProveedorText;
    TextView unidadEstandarText;
    TextView unidadAlternativaText;

    CheckBox solicitarCheckBox;
    NumberPicker cantidadSolicitadaText;
    Button guardarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INSERT DATA TO TEST APP
        ProductoDao productoDao = ProductosDatabase.getDatabase(context).productoDao();
        Producto producto = new Producto("Prod1","1235","1235","1",true,"2",false,"3", true);
        Producto producto1 = new Producto("Prod2","1111","1111","1",true,"2",true,"3", false);

        productoDao.insert(producto);
        productoDao.insert(producto1);
        //-----------------------

        infoProveedorSection = findViewById(R.id.infoProveedorDiv);
        infoEstandarSection = findViewById(R.id.infoEstandarDiv);
        infoAlternativaSection = findViewById(R.id.infoAlternativaDiv);
        skuText = findViewById(R.id.skuText);
        skuProveedorText = findViewById(R.id.skuProvText);
        productoDescripcionText = findViewById(R.id.descripcionText);
        cantidadProveedorText = findViewById(R.id.cantProveedorText);
        cantidadEstandarText = findViewById(R.id.cantEstandarText);
        cantidadAlternativaText = findViewById(R.id.cantAlternativaText);
        unidadProveedorText = findViewById(R.id.unidadProveedorText);
        unidadEstandarText = findViewById(R.id.unidadEstandarText);
        unidadAlternativaText = findViewById(R.id.unidadAlternativaText);
        solicitarCheckBox = findViewById(R.id.solicitarCheckBox);
        cantidadSolicitadaText = findViewById(R.id.cantSolicitadaText);

        skuSearchButton = findViewById(R.id.skuSearchButton);
        skuSearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                ProductoDao productoDao = ProductosDatabase.getDatabase(context).productoDao();
                Producto productoBD = productoDao.findProductoBySku(skuText.getText().toString());

                llenarInformacionProducto(productoBD);
            }
        });

        skuProveedorSearchButton = findViewById(R.id.skuProveedorSearchButton);
        skuProveedorSearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                ProductoDao productoDao = ProductosDatabase.getDatabase(getApplicationContext()).productoDao();
                Producto productoBD = productoDao.findProductoBySkuProveedor(skuProveedorText.getText().toString());

                llenarInformacionProducto(productoBD);
            }
        });

        guardarButton = findViewById(R.id.guardarBtn);
        guardarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                ProductoAlmacenDao productoAlmacenDao = ProductosDatabase.getDatabase(context).productoAlmacenDao();
                productoAlmacenDao.insert(obtenerInformacionProducto());


                Intent myIntent = new Intent(getBaseContext(), ListarActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public ProductoAlmacen obtenerInformacionProducto()
    {
        ProductoAlmacen productoAlmacen = new ProductoAlmacen();
        productoAlmacen.setSKU(skuText.getText().toString());
        productoAlmacen.setCantidadProveedor(cantidadProveedorText.getValue());
        productoAlmacen.setCantidadEstandar(cantidadEstandarText.getValue());
        productoAlmacen.setCantidadProveedor(cantidadAlternativaText.getValue());
        productoAlmacen.setSolicitar(solicitarCheckBox.isChecked());
        productoAlmacen.setCantidadSolicitada(cantidadSolicitadaText.getValue());
        return productoAlmacen;
    }

    public void llenarInformacionProducto(Producto productoBD)
    {
        productoDescripcionText.setText(productoBD.getDescripcion());
        if(productoBD.isUnidadProveedorFlag())
        {
            infoProveedorSection.setVisibility(View.VISIBLE);
            unidadProveedorText.setText(productoBD.getUnidadProveedor());
        }
        else if(productoBD.isUnidadEstandarFlag())
        {
            infoEstandarSection.setVisibility(View.VISIBLE);
            unidadEstandarText.setText(productoBD.getUnidadEstandar());
        }
        else if(productoBD.isUnidadAlternativaFlag())
        {
            infoAlternativaSection.setVisibility(View.VISIBLE);
            unidadAlternativaText.setText(productoBD.getUnidadAlternativa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.registrarOpcion) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
