package co.cyclopsapps.fooddelivery.home.view

import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.fooddelivery.databinding.ItemlistPlpProductBinding

class PlpViewHolder(binding: ItemlistPlpProductBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: ItemlistPlpProductBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(name: String) {
        binding?.name = name
        binding?.executePendingBindings()
    }
}