package com.example.cglotr.words.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.cglotr.words.WordRepository
import com.example.cglotr.words.db.entity.Word

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val mAllWords: LiveData<List<Word>>
    private val mRepository: WordRepository = WordRepository(application)

    init {
        mAllWords = mRepository.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return mAllWords
    }

    fun insert(word: Word) {
        mRepository.insert(word)
    }
}
