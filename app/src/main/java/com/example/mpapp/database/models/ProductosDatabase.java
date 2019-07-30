package com.example.mpapp.database.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Producto.class, ProductoAlmacen.class}, version = 1)
public abstract class ProductosDatabase extends RoomDatabase {

    private static ProductosDatabase INSTANCE;
    private static final String DB_NAME = "productos.db";

    //public abstract ProductoDao getProductoDao();
    //public abstract ProductoAlmacenDao getProductoAlmacenDao();

    private static ProductosDatabase productoDB;

   public static ProductosDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductosDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductosDatabase.class, DB_NAME)
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public void clearDb() {

    }

    public abstract ProductoDao productoDao();
    public abstract ProductoAlmacenDao productoAlmacenDao();



}
