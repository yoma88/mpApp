package com.example.mpapp.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "producto",
        indices = {@Index(value = "descripcion")})

public class Producto {

    @NonNull
    public String getSKU() {
        return SKU;
    }

    public void setSKU(@NonNull String SKU) {
        this.SKU = SKU;
    }

    public String getSKUProveedor() {
        return SKUProveedor;
    }

    public void setSKUProveedor(String SKUProveedor) {
        this.SKUProveedor = SKUProveedor;
    }

    @NonNull
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(@NonNull String descripcion) {
        Descripcion = descripcion;
    }

    public String getUnidadProveedor() {
        return UnidadProveedor;
    }

    public void setUnidadProveedor(String unidadProveedor) {
        UnidadProveedor = unidadProveedor;
    }

    public boolean isUnidadProveedorFlag() {
        return UnidadProveedorFlag;
    }

    public void setUnidadProveedorFlag(boolean unidadProveedorFlag) {
        UnidadProveedorFlag = unidadProveedorFlag;
    }

    public String getUnidadEstandar() {
        return UnidadEstandar;
    }

    public void setUnidadEstandar(String unidadEstandar) {
        UnidadEstandar = unidadEstandar;
    }

    public boolean isUnidadEstandarFlag() {
        return UnidadEstandarFlag;
    }

    public void setUnidadEstandarFlag(boolean unidadEstandarFlag) {
        UnidadEstandarFlag = unidadEstandarFlag;
    }

    public String getUnidadAlternativa() {
        return UnidadAlternativa;
    }

    public void setUnidadAlternativa(String unidadAlternativa) {
        UnidadAlternativa = unidadAlternativa;
    }

    public boolean isUnidadAlternativaFlag() {
        return UnidadAlternativaFlag;
    }

    public void setUnidadAlternativaFlag(boolean unidadAlternativaFlag) {
        UnidadAlternativaFlag = unidadAlternativaFlag;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "sku")
    @NonNull
    private String SKU;

    @ColumnInfo(name = "skuProveedor")
    private String SKUProveedor;

    @ColumnInfo(name = "descripcion")
    @NonNull
    private String Descripcion;

    @ColumnInfo(name = "unidadProveedor")
    private String UnidadProveedor;

    @ColumnInfo(name = "unidadProveedorFlag")
    private boolean UnidadProveedorFlag;

    @ColumnInfo(name = "unidadEstandar")
    private String UnidadEstandar;

    @ColumnInfo(name = "unidadEstandarFlag")
    private boolean UnidadEstandarFlag;

    @ColumnInfo(name = "unidadAlternativa")
    private String UnidadAlternativa;

    @ColumnInfo(name = "unidadAlternativaFlag")
    private boolean UnidadAlternativaFlag;

    @ColumnInfo(name = "estado")
    private boolean Estado;

    public Producto(@NonNull String Descripcion, String SKU, String SKUProveedor, String UnidadProveedor, boolean UnidadProveedorFlag, String UnidadEstandar, boolean UnidadEstandarFlag, String UnidadAlternativa, boolean UnidadAlternativaFlag)
    {
        this.Descripcion = Descripcion;
        this.SKU = SKU;
        this.SKUProveedor = SKUProveedor;
        this.UnidadProveedor = UnidadProveedor;
        this.UnidadProveedorFlag = UnidadProveedorFlag;
        this.UnidadEstandar = UnidadEstandar;
        this.UnidadEstandarFlag = UnidadEstandarFlag;
        this.UnidadAlternativa = UnidadAlternativa;
        this.UnidadAlternativaFlag = UnidadAlternativaFlag;
    }

    @Ignore
    public Producto() {
    }

}
