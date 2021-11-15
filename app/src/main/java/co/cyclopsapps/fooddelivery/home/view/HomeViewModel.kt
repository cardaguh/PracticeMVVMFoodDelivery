package co.cyclopsapps.fooddelivery.home.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Created by Carlos Daniel Agudelo on 14/11/2021.
 */
class HomeViewModel(app: Application): AndroidViewModel(app) {

    val context = app
    val itemList = ArrayList<String>()
    var plpAdapter = MutableLiveData<PlpAdapter>()

    private val _itemSelected = MutableLiveData<String>()
    val itemSelected: LiveData<String> = _itemSelected

    lateinit var observerOnCategorySeleted: Observer<String>

    init {
        for (i in 1..50) {
            itemList.add("Item $i")
        }
        initObserver()
    }

    private fun initObserver() {
        observerOnCategorySeleted = Observer { value ->
            value.let {
                _itemSelected.value = it
            }
        }
    }

    fun loadItemRecyclerView() {
        val adapter = PlpAdapter(itemList)
        plpAdapter.value = adapter
        adapter.onItemSelected.observeForever(observerOnCategorySeleted)
        adapter.notifyDataSetChanged()
    }

    fun clearSelection() {
        _itemSelected.value = null
    }
}