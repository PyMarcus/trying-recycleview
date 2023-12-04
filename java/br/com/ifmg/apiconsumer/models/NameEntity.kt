package br.com.ifmg.apiconsumer.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "names")
class NameEntity {
    constructor()

    constructor(name: String){
        this.name = name
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""
}