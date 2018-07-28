package com.example.cglotr.words.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.cglotr.words.db.entity.Word

@Dao
interface WordDao {

    @Query("DELETE from word_table")
    fun deleteAll(): Any

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    fun insert(word: Word): Any
}
