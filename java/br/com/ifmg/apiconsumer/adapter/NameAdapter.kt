package br.com.ifmg.apiconsumer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ifmg.apiconsumer.databinding.ActivityNameBinding
import br.com.ifmg.apiconsumer.models.NameEntity

class NameAdapter(private var names: MutableList<NameEntity>): RecyclerView.Adapter<NameAdapter.NameHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameAdapter.NameHolder {
        val binding = ActivityNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameHolder(binding)
    }

    override fun onBindViewHolder(holder: NameAdapter.NameHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount(): Int {
        return names.size
    }

    class NameHolder(private var binding: ActivityNameBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(get: NameEntity){
                   binding.n.setText(get.name)
                }
            }

}