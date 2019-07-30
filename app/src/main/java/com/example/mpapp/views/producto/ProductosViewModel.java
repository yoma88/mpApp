package com.example.mpapp.views.producto;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.mpapp.database.models.Producto;
import com.example.mpapp.database.models.ProductoDao;
import com.example.mpapp.database.models.ProductosDatabase;
import java.util.List;

public class ProductosViewModel extends AndroidViewModel{

    private ProductoDao productoDao;
    private LiveData<List<Producto>> productosLiveData;

    public ProductosViewModel(@NonNull Application application) {
        super(application);
        productoDao = ProductosDatabase.getDatabase(application).productoDao();
        productosLiveData = productoDao.getAllProductos();
    }

    public LiveData<List<Producto>> getProductoList() {
        return productosLiveData;
    }

    public void insert(Producto... productos) {
        productoDao.insert(productos);
    }

    public void update(Producto productos) {
        productoDao.update(productos);
    }

    public void deleteAll() {
        productoDao.deleteAll();
    }

}
