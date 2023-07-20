package com.example.uashealthcare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Artikel(
    @ColumnInfo(name="judul")
    var judul:String,
    @ColumnInfo(name="isi")
    var isi:String,
    @ColumnInfo(name="urlFoto")
    var urlFoto:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}