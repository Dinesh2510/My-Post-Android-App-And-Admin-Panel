package com.app.mylekh.databases.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.mylekh.models.PostData;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_recipes_favorite";
    private static final String TABLE_NAME = "tbl_recipes_favorite";
    private static final String KEY_ID = "id";
    private static final String KEY_CAT_NAME = "category_name";
    private static final String KEY_RECIPE_ID = "recipe_id";
    private static final String KEY_RECIPE_TITLE = "recipes_title";
    private static final String KEY_RECIPE_TIME = "recipe_time";
    private static final String KEY_RECIPE_IMAGE = "recipe_image";
    private static final String KEY_RECIPE_DESCRIPTION = "recipe_description";
    private static final String KEY_VIDEO_URL = "video_url";
    private static final String KEY_VIDEO_ID = "video_id";
    private static final String KEY_CONTENT_TYPE = "content_type";
    private static final String KEY_FEATURED = "featured";
    private static final String KEY_TAGS = "tags";
    private static final String KEY_TOTAL_VIEWS = "total_views";


    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_CAT_NAME + " TEXT,"
                + KEY_RECIPE_ID + " TEXT,"
                + KEY_RECIPE_TITLE + " TEXT,"
                + KEY_RECIPE_TIME + " TEXT,"
                + KEY_RECIPE_IMAGE + " TEXT,"
                + KEY_RECIPE_DESCRIPTION + " TEXT,"
                + KEY_VIDEO_URL + " TEXT,"
                + KEY_VIDEO_ID + " TEXT,"
                + KEY_CONTENT_TYPE + " TEXT,"
                + KEY_FEATURED + " TEXT,"
                + KEY_TAGS + " TEXT,"
                + KEY_TOTAL_VIEWS + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    //Adding Record in Database

    public void AddtoFavorite(PostData p) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
       /* values.put(KEY_CAT_NAME, p.getCategory_name());
        values.put(KEY_RECIPE_ID, p.getRecipe_id());
        values.put(KEY_RECIPE_TITLE, p.getRecipe_title());
        values.put(KEY_RECIPE_TIME, p.getRecipe_time());
        values.put(KEY_RECIPE_IMAGE, p.getRecipe_image());
        values.put(KEY_RECIPE_DESCRIPTION, p.getRecipe_description());
        values.put(KEY_VIDEO_URL, p.getVideo_url());
        values.put(KEY_VIDEO_ID, p.getVideo_id());
        values.put(KEY_CONTENT_TYPE, p.getContent_type());
        values.put(KEY_FEATURED, p.getFeatured());
        values.put(KEY_TAGS, p.getTags());
        values.put(KEY_TOTAL_VIEWS, p.getTotal_views());*/

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection

    }

    // Getting All Data
    public List<PostData> getAllData() {
        List<PostData> dataList = new ArrayList<PostData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PostData values = new PostData();
                /*values.setId(Integer.parseInt(cursor.getString(0)));
                values.setCategory_name(cursor.getString(1));
                values.setRecipe_id(cursor.getString(2));
                values.setRecipe_title(cursor.getString(3));
                values.setRecipe_time(cursor.getString(4));
                values.setRecipe_image(cursor.getString(5));
                values.setRecipe_description(cursor.getString(6));
                values.setVideo_url(cursor.getString(7));
                values.setVideo_id(cursor.getString(8));
                values.setContent_type(cursor.getString(9));
                values.setFeatured(cursor.getString(10));
                values.setTags(cursor.getString(11));
                values.setTotal_views(cursor.getLong(12));*/
                // Adding contact to list
                dataList.add(values);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dataList;
    }

    //getting single row
    public List<PostData> getFavRow(String id) {
        List<PostData> dataList = new ArrayList<PostData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE recipe_id=" + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PostData values = new PostData();
              /*  values.setId(Integer.parseInt(cursor.getString(0)));
                values.setCategory_name(cursor.getString(1));
                values.setRecipe_id(cursor.getString(2));
                values.setRecipe_title(cursor.getString(3));
                values.setRecipe_time(cursor.getString(4));
                values.setRecipe_image(cursor.getString(5));
                values.setRecipe_description(cursor.getString(6));
                values.setVideo_url(cursor.getString(7));
                values.setVideo_id(cursor.getString(8));
                values.setContent_type(cursor.getString(9));
                values.setFeatured(cursor.getString(10));
                values.setTags(cursor.getString(11));
                values.setTotal_views(cursor.getLong(12));*/
                // Adding contact to list
                dataList.add(values);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dataList;
    }

    //for remove favorite
    public void RemoveFav(PostData contact) {
      /*  SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_RECIPE_ID + " = ?",
                new String[]{String.valueOf(contact.getRecipe_id())});
        db.close();*/
    }

    public enum DatabaseManager {
        INSTANCE;
        private SQLiteDatabase db;
        private boolean isDbClosed = true;
        DbHandler dbHelper;

        public void init(Context context) {
            dbHelper = new DbHandler(context);
            if (isDbClosed) {
                isDbClosed = false;
                this.db = dbHelper.getWritableDatabase();
            }

        }

        public boolean isDatabaseClosed() {
            return isDbClosed;
        }

        public void closeDatabase() {
            if (!isDbClosed && db != null) {
                isDbClosed = true;
                db.close();
                dbHelper.close();
            }
        }
    }

}
