package com.example.basicdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ProductRoomDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
    private static ProductRoomDatabase INSTANCE;

    static ProductRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (ProductRoomDatabase.class) {
                if (INSTANCE == null) {
                    try {
                        INSTANCE =
                                Room.databaseBuilder(context.getApplicationContext(),
                                        ProductRoomDatabase.class,
                                        "product_database").build();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                }
            }
        }
        return INSTANCE;
    }

    /*private static final String DB_NAME = "productDatabase.db";
    private static volatile ProductRoomDatabase instance;
    //public abstract ProductDao productDao();

    static synchronized ProductRoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private ProductRoomDatabase() {};

    private static ProductRoomDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                ProductRoomDatabase.class,
                DB_NAME).build();
    }
*/
    //public abstract ProductDao getRepoDao();

    /*public abstract ProductDao WordDAO();

    private static volatile ProductRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static  final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ProductRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (ProductRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ProductRoomDatabase.class,"product_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }*/
}