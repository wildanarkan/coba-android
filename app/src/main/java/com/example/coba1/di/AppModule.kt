package com.example.coba1.di

import android.content.Context
import com.example.coba1.data.AppDao
import com.example.coba1.data.AppDatabase
import com.example.coba1.view.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import javax.sql.CommonDataSource

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Provides
    fun provideDatabaseDao(db: AppDatabase) = db.dao()

    @Provides
    @Singleton
    fun userRepository(
        localDataSource: AppDao
    ) = UserRepository(localDataSource)
}
