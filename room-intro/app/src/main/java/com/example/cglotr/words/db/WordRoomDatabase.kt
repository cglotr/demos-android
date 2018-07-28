package com.example.cglotr.words.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.cglotr.words.db.dao.WordDao
import com.example.cglotr.words.db.entity.Word

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {
        private var sInstance: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            if (sInstance == null) {
                synchronized(WordRoomDatabase::class) {
                    if (sInstance == null) {
                        sInstance = Room.databaseBuilder(
                                context.applicationContext,
                                WordRoomDatabase::class.java,
                                "word_database"
                        ).build()
                    }
                }
            }

            return sInstance!!
        }
    }
}
