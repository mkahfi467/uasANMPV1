package com.example.uashealthcare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.uashealthcare.model.Fasilitas
import com.example.uashealthcare.model.FasilitasDao
import com.example.uashealthcare.util.buildDb
import com.example.uashealthcare.util.buildDb2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListFasilitasLayananViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    val FasilitasLayananLD = MutableLiveData<ArrayList<Fasilitas>>()
    val FasilitasLayananLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        loadingLD.value = true
        FasilitasLayananLoadErrorLD.value = false
        launch {
            val db = buildDb2(getApplication())

            FasilitasLayananLD.postValue(db.fasilitasDao().selectAllFasilitas() as ArrayList<Fasilitas>?)
        }
    }

    fun clearTask(fasilitas: Fasilitas) {
        launch {
            val db = buildDb2(getApplication())

            db.fasilitasDao().deleteFasilitas(fasilitas)
            FasilitasLayananLD.postValue(db.fasilitasDao().selectAllFasilitas() as ArrayList<Fasilitas>?)
        }
    }
}
