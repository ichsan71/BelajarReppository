package com.marqumil.belajarreppository.dicoding.newsapp.data.di

import android.content.Context
import com.marqumil.belajarreppository.dicoding.newsapp.data.NewsRepository
import com.marqumil.belajarreppository.dicoding.newsapp.data.local.room.NewsDatabase
import com.marqumil.belajarreppository.dicoding.newsapp.data.remote.retrofit.ApiConfig
import com.marqumil.belajarreppository.dicoding.newsapp.utils.AppExecutors



object Injection {

    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewsRepository.getInstance(apiService, dao, appExecutors)
    }

}