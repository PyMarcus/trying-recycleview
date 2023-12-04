package br.com.ifmg.apiconsumer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.ifmg.apiconsumer.models.NameEntity
import br.com.ifmg.apiconsumer.repository.NameDAO

@Database(entities = [NameEntity::class], version = 1, exportSchema = false)
abstract class DatabaseDB() : RoomDatabase() {
    abstract fun nameDAO(): NameDAO

    companion object {
        private lateinit var INSTANCE: DatabaseDB

        fun getDatabase(context: Context): DatabaseDB {  // singleton
            if (!::INSTANCE.isInitialized) {
                synchronized(DatabaseDB::class) { // sql does not allow multithreads
                    INSTANCE = Room
                        .databaseBuilder(context, DatabaseDB::class.java, "database_db")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}