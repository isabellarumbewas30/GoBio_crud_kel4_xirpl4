/*
 * Copyright (c) 2021 Indra Azimi. All rights reserved.
 *
 * Dibuat untuk kelas Pemrograman untuk Perangkat Bergerak 2.
 * Dilarang melakukan penggandaan dan atau komersialisasi,
 * sebagian atau seluruh bagian, baik cetak maupun elektronik
 * terhadap project ini tanpa izin pemilik hak cipta.
 */

package com.kel4xirpl4gobio.mahasiswaid.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class MahasiswaDb : RoomDatabase()  {

    abstract val dao : MahasiswaDao

    companion object {
        @Volatile
        private var INSTANCE: MahasiswaDb? = null

        fun getInstance(context: Context): MahasiswaDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MahasiswaDb::class.java,
                        "mahasiswa.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}