package com.example.curriculumvitaev2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//TODO 8 "Change to a ROOMDataBase"
@Database(
    version = 1,
    entities = [ExperienceData::class],
    exportSchema = false
)

 abstract class AppDataBase  : RoomDatabase() {

    //TODO 8.1 "Add the DAO"
  abstract class AppDataBase :RoomDatabase(){
        abstract fun ExperienceDAO() : ExperienceDAO
    }
    companion object {
        @Volatile
        private var instance: AppDataBase? = null
        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    //TODO 8.2 "Build the DataBase"
                    instance= Room
                        .databaseBuilder(context,AppDataBase::class.java,"databaseLol")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }
    }
}

