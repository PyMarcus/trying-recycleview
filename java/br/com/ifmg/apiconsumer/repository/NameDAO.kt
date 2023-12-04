package br.com.ifmg.apiconsumer.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.ifmg.apiconsumer.models.NameEntity

@Dao
interface NameDAO {
    @Insert
    fun save(name: NameEntity)

    @Query("SELECT * FROM names;")
    fun getAllNames(): MutableList<NameEntity>

    @Query("DELETE FROM names;")
    fun delete()
}