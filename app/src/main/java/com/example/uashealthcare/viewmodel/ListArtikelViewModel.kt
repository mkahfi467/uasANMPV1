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

class ListArtikelViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {

    val artikelLD = MutableLiveData<List<Artikel>>()
    val artikelLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        loadingLD.value = true
        artikelLoadErrorLD.value = false
        launch {
            val db = buildDb(getApplication())

            artikelLD.postValue(db.artikelDao().selectAllArtikel())
        }
    }

    fun clearTask(artikel: Artikel) {
        launch {
            val db = buildDb(getApplication())

            db.artikelDao().deleteArtikel(artikel)
            artikelLD.postValue(db.artikelDao().selectAllArtikel())
        }
    }
}