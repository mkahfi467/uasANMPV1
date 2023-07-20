package com.example.uashealthcare.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Artikel::class), version = 1)
abstract class ArtikelDatabase:RoomDatabase() {
    abstract fun artikelDao(): ArtikelDao

    companion object {
        @Volatile private var instance: ArtikelDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArtikelDatabase::class.java,
                "artikeldb")
                .build()

        operator fun invoke(context: Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}