package com.example.uashealthcare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.uashealthcare.model.Artikel
import com.example.uashealthcare.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailArtikelViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    val artikelLD = MutableLiveData<Artikel>()

    fun addArtikel(artikel: Artikel) {
        launch {
            val db = buildDb(getApplication())

            db.artikelDao().insertAll(artikel)
        }
    }

    fun fetch(uuid:Int) {
        launch {
            val db = buildDb(getApplication())
            artikelLD.postValue(db.artikelDao().selectArtikel(uuid))
        }
    }

    fun update(judul:String, isi:String, urlFoto:String, uuid:Int) {
        launch {
            val db = buildDb(getApplication())
            db.artikelDao().update(judul, isi, urlFoto, uuid)
        }
    }

//    BATAS W9

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
}