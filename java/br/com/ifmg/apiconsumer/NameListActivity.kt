package br.com.ifmg.apiconsumer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ifmg.apiconsumer.adapter.NameAdapter
import br.com.ifmg.apiconsumer.controllers.NameController
import br.com.ifmg.apiconsumer.databinding.ActivityNameListBinding
import br.com.ifmg.apiconsumer.models.NameEntity

class NameListActivity : AppCompatActivity() {

    private lateinit var nameController: NameController
    private lateinit var adapter: NameAdapter
    private lateinit var binding: ActivityNameListBinding
    private var names: MutableList<NameEntity> = mutableListOf() // Initialize the list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycle.layoutManager = LinearLayoutManager(this)
        nameController = NameController(baseContext)

        adapter = NameAdapter(names)
        binding.recycle.adapter = adapter

        loadNames()
    }

    private fun loadNames() {
        names.clear()
        names.addAll(nameController.getAllNames())
        adapter.notifyDataSetChanged() // Notify the adapter of the data change
    }
}
