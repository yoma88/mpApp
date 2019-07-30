package com.example.mpapp.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
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
    @TypeConverters({DateConverter.class})
    private Date Fecha;

    @ColumnInfo(name = "solicitar")
    private boolean Solicitar;

    @NonNull
    public String getSKU() {
        return SKU;
    }

    public void setSKU(@NonNull String SKU) {
        this.SKU = SKU;
    }

    public int getCantidadProveedor() {
        return CantidadProveedor;
    }

    public void setCantidadProveedor(int cantidadProveedor) {
        CantidadProveedor = cantidadProveedor;
    }

    public int getCantidadEstandar() {
        return CantidadEstandar;
    }

    public void setCantidadEstandar(int cantidadEstandar) {
        CantidadEstandar = cantidadEstandar;
    }

    public int getCantidadAlternativa() {
        return CantidadAlternativa;
    }

    public void setCantidadAlternativa(int cantidadAlternativa) {
        CantidadAlternativa = cantidadAlternativa;
    }

    @NonNull
    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(@NonNull Date fecha) {
        Fecha = fecha;
    }

    public boolean isSolicitar() {
        return Solicitar;
    }

    public void setSolicitar(boolean solicitar) {
        Solicitar = solicitar;
    }

    public int getCantidadSolicitada() {
        return CantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        CantidadSolicitada = cantidadSolicitada;
    }

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

    @Ignore
    public ProductoAlmacen() {
    }

}
