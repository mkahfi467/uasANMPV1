package com.example.uashealthcare.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Artikel::class), version = 1)
abstract class FasilitasDatabase: RoomDatabase() {
    abstract fun fasilitasDao(): FasilitasDao

    companion object {
        @Volatile private var instance: FasilitasDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FasilitasDatabase::class.java,
                "fasilitasdb")
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
