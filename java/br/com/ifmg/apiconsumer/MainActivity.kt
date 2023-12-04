package br.com.ifmg.apiconsumer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import br.com.ifmg.apiconsumer.controllers.NameController
import br.com.ifmg.apiconsumer.databinding.ActivityMainBinding
import br.com.ifmg.apiconsumer.models.NameEntity

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var nameController: NameController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameController = NameController(baseContext)
        handleEvents()
        nameController.clearDB()
    }

    private fun handleEvents(){
        binding.b.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            binding.b.id -> register()
            binding.b2.id -> list()
        }
    }

    private fun register(){
        val name: NameEntity = NameEntity(binding.t.text.toString())
        nameController.save(name)
    }

    private fun list(){
        val lister = Intent(baseContext, NameListActivity::class.java)
        startActivity(lister)
    }
}