package com.example.mpapp.database.models;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ProductoDao {

    @Query("SELECT * FROM producto WHERE descripcion = :descripcion LIMIT 1")
    Producto findProductoByDescripcion(String descripcion);

    @Query("SELECT * FROM producto WHERE sku = :sku LIMIT 1")
    Producto findProductoBySku(String sku);

    @Query("SELECT * FROM producto WHERE skuProveedor = :skuProveedor LIMIT 1")
    Producto findProductoBySkuProveedor(String skuProveedor);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Producto producto);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Producto... productos);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Producto producto);

    @Query("DELETE FROM producto")
    void deleteAll();

    @Query("SELECT * FROM producto ORDER BY descripcion ASC")
    LiveData<List<Producto>> getAllProductos();

}
