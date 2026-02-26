package com.lapoushko.database.di

import android.content.Context
import androidx.room.Room
import com.lapoushko.database.AppDatabase
import com.lapoushko.database.ConstantsDatabase
import com.lapoushko.database.dao.ProfileDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Lapoushko
 */
object DatabaseDI {
    val module = module {
        single<AppDatabase> { provideRoomDatabase(androidContext()) }
        single<ProfileDao> { provideDao(get()) }
    }
}

private fun provideRoomDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, ConstantsDatabase.TEST_TASK_DB_NAME)
        .fallbackToDestructiveMigration()
        .build()
}

private fun provideDao(database: AppDatabase): ProfileDao {
    return database.profileDao()
}