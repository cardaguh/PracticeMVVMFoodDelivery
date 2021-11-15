package co.cyclopsapps.fooddelivery.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.fooddelivery.R
import co.cyclopsapps.fooddelivery.databinding.ItemlistPlpProductBinding

class PlpAdapter(var itemsList: ArrayList<String>): RecyclerView.Adapter<PlpViewHolder>() {
    val resource = R.layout.itemlist_plp_product
    lateinit var context: Context
    var onItemSelected = MutableLiveData<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlpViewHolder {
        context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemlistPlpProductBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return PlpViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlpViewHolder, position: Int) {
        holder.setItem(itemsList[position])
        holder.itemView.setOnClickListener {
            onItemSelected.value = itemsList[position]
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

}