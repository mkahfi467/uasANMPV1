package com.example.uashealthcare.model

import androidx.room.*

@Dao
interface ArtikelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg artikel:Artikel)

    @Query("SELECT * FROM artikel")
    fun selectAllArtikel(): List<Artikel>

    @Query("SELECT * FROM artikel WHERE uuid= :id")
    fun selectArtikel(id:Int): Artikel

    @Delete
    fun deleteArtikel(artikel: Artikel)

    @Query("UPDATE artikel SET judul=:judul, isi=:isi, urlFoto=:urlFoto WHERE uuid=:id")
    fun update(judul:String, isi:String, urlFoto:String, id:Int)
}