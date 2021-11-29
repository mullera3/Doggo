package com.example.project1android2

import android.app.Application
import com.example.project1android2.database.AppDatabase

class DogApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}