package com.example.cglotr.words.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull

@Entity(tableName = "word_table")
data class Word(
        @ColumnInfo(name = "word")
        @NonNull
        val word: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}
