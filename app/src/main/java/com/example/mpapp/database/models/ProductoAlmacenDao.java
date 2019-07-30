package com.example.mpapp.database.models;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ProductoAlmacenDao {

    @Query("SELECT * FROM productoAlmacen WHERE sku = :sku LIMIT 1")
    ProductoAlmacen findProductoAlmacenBySku(int sku);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(ProductoAlmacen productoAlmacen);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ProductoAlmacen... productosAlmacen);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(ProductoAlmacen productoAlmacen);

    @Query("DELETE FROM productoAlmacen")
    void deleteAll();

    @Query("SELECT * FROM productoAlmacen ORDER BY sku ASC")
    LiveData<List<ProductoAlmacen>> getAllProductosAlmacen();

}
