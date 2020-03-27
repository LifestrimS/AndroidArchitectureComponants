package com.loopwiki.androidarchitecturecomponants.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.loopwiki.androidarchitecturecomponants.database.Daos.NoteDao;
import com.loopwiki.androidarchitecturecomponants.database.models.Note;

// Room database class
@Database(entities = Note.class, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    //define static instance
    private static NoteDatabase mInstance;

    //method to get room database
    public static NoteDatabase getDatabase(Context context) {

        if (mInstance == null)
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "notes_db")
                    .build();

        return mInstance;
    }

    //method to remove instance
    public static void closeDatabase() {
        mInstance = null;
    }

    //define note dao ( data access object )
    public abstract NoteDao noteDao();


}
