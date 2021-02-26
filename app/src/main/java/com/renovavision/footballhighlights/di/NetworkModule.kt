package com.renovavision.footballhighlights.di

import com.renovavision.footballhighlights.BuildConfig
import com.renovavision.footballhighlights.data.HighlightsService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(OkHttpClient.Builder().build())
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(HighlightsService::class.java)
}