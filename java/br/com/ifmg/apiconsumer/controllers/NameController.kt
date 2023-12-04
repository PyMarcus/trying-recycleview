package br.com.ifmg.apiconsumer.controllers

import android.content.Context
import br.com.ifmg.apiconsumer.database.DatabaseDB
import br.com.ifmg.apiconsumer.models.NameEntity
import br.com.ifmg.apiconsumer.repository.NameDAO

class NameController(private var context: Context) {
    private lateinit var nameDAO: NameDAO

    init {
        nameDAO = DatabaseDB.getDatabase(context).nameDAO()
    }

    fun save(name: NameEntity){
        nameDAO.save(name)
    }

    fun getAllNames(): MutableList<NameEntity>{
        return nameDAO.getAllNames()
    }

    fun clearDB(){
        nameDAO.delete()
    }
}