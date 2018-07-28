package com.example.cglotr.words

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.cglotr.words.db.WordRoomDatabase
import com.example.cglotr.words.db.dao.WordDao
import com.example.cglotr.words.db.entity.Word

class WordRepository(application: Application) {

    private val mAllWords: LiveData<List<Word>>
    private val mWordDao: WordDao

    init {
        val db: WordRoomDatabase = WordRoomDatabase.getDatabase(application)
        mWordDao = db.getWordDao()
        mAllWords = mWordDao.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return mAllWords
    }

    fun insert(word: Word) {
        InsertAsyncTask(mWordDao).execute(word)
    }

    private class InsertAsyncTask(dao: WordDao) : AsyncTask<Word, Any, Any>() {

        private val mAsyncTaskDao: WordDao = dao

        override fun doInBackground(vararg params: Word?): Any? {
            mAsyncTaskDao.insert(params[0]!!)
            return null
        }
    }
}
