package com.prosoft.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ToDoListDB";
    private static final int DATABASE_VERSION = 1;

    // 테이블 및 열 이름 정의
    private static final String TODOLIST_TABLE = "todolist";
    private static final String USER_TABLE = "user";
    private static final String TIMETABLE_TABLE = "timetable";
    private static final String CALENDAR_TABLE = "calendar";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TASK = "task";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_TODO = "todo";
    private static final String COLUMN_USER_ID = "userId";
    private static final String COLUMN_PIN_NUM = "pinNum";

    // 테이블 생성 쿼리
    private static final String CREATE_TODOLIST_TABLE =
            "CREATE TABLE " + TODOLIST_TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TASK + " TEXT, " +
                    COLUMN_TIME + " TEXT, " +
                    COLUMN_TODO + " TEXT, " +
                    COLUMN_USER_ID + " INTEGER);";

    private static final String CREATE_USER_TABLE =
            "CREATE TABLE " + USER_TABLE + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PIN_NUM + " INTEGER, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TODO + " TEXT);";

    private static final String CREATE_TIMETABLE_TABLE =
            "CREATE TABLE " + TIMETABLE_TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_ID + " INTEGER, " +
                    COLUMN_TIME + " TEXT, " +
                    COLUMN_DATE + " TEXT);";

    private static final String CREATE_CALENDAR_TABLE =
            "CREATE TABLE " + CALENDAR_TABLE + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_DATE + " TEXT);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TODOLIST_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_TIMETABLE_TABLE);
        db.execSQL(CREATE_CALENDAR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 버전이 변경될 때 수행할 작업이 있다면 여기에 추가
    }

    // ToDo 항목 추가
    public long addTodoItem(String date, String task, String time, String todo, long userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_TASK, task);
        values.put(COLUMN_TIME, time);
        values.put(COLUMN_TODO, todo);
        values.put(COLUMN_USER_ID, userId);
        long id = db.insert(TODOLIST_TABLE, null, values);
        db.close();

        // Log 추가
        Log.d("DBHelper", "Added ToDo item with ID: " + id + ", Task: " + task + ", Time: " + time + ", Todo: " + todo);
        return id;
    }

    // 모든 ToDo 항목 조회
    public List<TodoItem> getAllTodoItems() {
        List<TodoItem> todoItemList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TODOLIST_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                // 수정된 부분: 각 열의 인덱스를 가져오기 전에 해당 열이 존재하는지 확인
                int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
                int dateColumnIndex = cursor.getColumnIndex(COLUMN_DATE);
                int taskColumnIndex = cursor.getColumnIndex(COLUMN_TASK);
                int timeColumnIndex = cursor.getColumnIndex(COLUMN_TIME);
                int todoColumnIndex = cursor.getColumnIndex(COLUMN_TODO);
                int userIdColumnIndex = cursor.getColumnIndex(COLUMN_USER_ID);

                if (idColumnIndex != -1 && dateColumnIndex != -1 &&
                        taskColumnIndex != -1 && timeColumnIndex != -1 &&
                        todoColumnIndex != -1 && userIdColumnIndex != -1) {

                    int id = cursor.getInt(idColumnIndex);
                    String date = cursor.getString(dateColumnIndex);
                    String task = cursor.getString(taskColumnIndex);
                    String time = cursor.getString(timeColumnIndex);
                    String todo = cursor.getString(todoColumnIndex);
                    long userId = cursor.getLong(userIdColumnIndex);

                    TodoItem todoItem = new TodoItem(task, time, id, date);
                    todoItem.setTodo(todo);
                    todoItem.setUserId(userId);
                    todoItemList.add(todoItem);
                } else {
                    // 열을 찾지 못한 경우에 대한 처리
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return todoItemList;
    }

    // 특정 ToDo 항목 수정
    public void updateTodoItem(long id, String newTodo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO, newTodo);
        db.update(TODOLIST_TABLE, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // 특정 ToDo 항목 삭제
    public void deleteTodoItem(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TODOLIST_TABLE, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }


}