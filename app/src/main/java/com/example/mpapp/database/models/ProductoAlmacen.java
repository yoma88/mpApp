package com.example.mpapp.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "productoAlmacen",
        foreignKeys = @ForeignKey(entity = Producto.class,
                parentColumns = "sku",
                childColumns = "sku",
                onDelete = ForeignKey.CASCADE),
        indices = {@Index("sku")})
public class ProductoAlmacen {

    @PrimaryKey(autoGenerate = false)
     @ColumnInfo(name = "sku")
    @NonNull
    private String SKU;

    @ColumnInfo(name = "cantidadProveedor")
    private int CantidadProveedor;

    @ColumnInfo(name = "cantidadEstandar")
    private int CantidadEstandar;

    @ColumnInfo(name = "cantidadAlternativa")
    private int CantidadAlternativa;

    @ColumnInfo(name = "fecha")
    @NonNull
    private Date Fecha;

    @ColumnInfo(name = "solicitar")
    private boolean Solicitar;

    @ColumnInfo(name = "cantidadSolicitada")
    private int CantidadSolicitada;

    public ProductoAlmacen(@NonNull String SKU, int CantidadProveedor, int CantidadEstandar, int CantidadAlternativa, Date Fecha, boolean Solicitar, int CantidadSolicitada) {

        this.SKU = SKU;
        this.CantidadProveedor = CantidadProveedor;
        this.CantidadEstandar = CantidadEstandar;
        this.CantidadAlternativa = CantidadAlternativa;
        this.Fecha = Fecha;
        this.Solicitar = Solicitar;
        this.CantidadSolicitada = CantidadSolicitada;
    }

    public ProductoAlmacen() {
    }

}
