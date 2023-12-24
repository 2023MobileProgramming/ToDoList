package com.prosoft.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String fileName;   //  fileName - 돌고 도는 선택된 날짜의 파일 이름
    CalendarView CalView;
    TextView tv_text, tv_text2, tv_text3, header_title;
    EditText dlgReset1, dlgReset2, hintPass, dlgName, contextToDoList;
    View dialogView;
    Button newWrite,delToDoList;

    // 뒤로가기
    private long backpressedTime = 0;
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backpressedTime + 2000) {
            backpressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
            finish();
        }
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("오늘, 하루");

        CalView = (CalendarView) findViewById(R.id.CalView);
        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text2 = (TextView) findViewById(R.id.tv_text2);
        tv_text3 = (TextView) findViewById(R.id.tv_text3);
        header_title = (TextView) findViewById(R.id.header_title);
        newWrite = (Button) findViewById(R.id.newWrite);
        delToDoList = (Button) findViewById(R.id.delToDoList);
        contextToDoList = (EditText) findViewById(R.id.contextToDoList);


        // 오늘 날짜를 받게해주는 Calender 친구들
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        int cDay = c.get(Calendar.DAY_OF_MONTH);

        // 첫 시작 시 오늘 날짜 일기 읽어주기
        checkedDay(cYear, cMonth, cDay);
        tv_text3.setText(cYear + "년 " + (cMonth+1) + "월 " + cDay + "일");

        //Today 버튼을 누르면 캘린더에 오늘 날짜로 표시하기
        Button btnToday = findViewById(R.id.btnToday);
        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTodayDate(view);
            }
        });

        // 할일삭제 부분 (나중에 다이얼로그로 정말로 삭제하시겠습니까? 창 출력하도록
        delToDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delDialog();
            }
        });

        // 새 할 일 작성 (할 일 추가하기)
        newWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newWrite.getText().toString().equals("읽기 & 수정")) {
                    Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                    intent.putExtra("years", tv_text.getText().toString());
                    intent.putExtra("monthdays", tv_text2.getText().toString());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                    intent.putExtra("years", tv_text.getText().toString());
                    intent.putExtra("monthdays", tv_text2.getText().toString());
                    startActivity(intent);
                }
            }
        });

        // 이름 불러오기
        try {
            FileInputStream inFs = openFileInput("name.txt");
            byte[] user = new byte[inFs.available()];
            inFs.read(user);
            String name = new String(user);
            inFs.close();
            header_title.setText(name + "'s To Do List");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 달력 클릭 시
        CalView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                tv_text.setText(year + "년");
                tv_text2.setText((month + 1) + "월 " + day + "일");
                tv_text3.setText(year + "년 " + (month+1) + "월 " + day + "일");
                fileName = Integer.toString(year) + Integer.toString(month+1) + Integer.toString(day) + ".txt";
                String str = readToDoList(fileName);
                contextToDoList.setText(str);
            }
        });

//        DBHelper dbHelper = new DBHelper(this);
//        ArrayList<String> TodoList = dbHelper.getTodolist();
//
//        todolist = findViewById(R.id.contextToDoList);
//        todolist.setText(todolist.toString());

    }

    // 할일 읽기
    String readToDoList(String fName) {
        String ToDoListStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            ToDoListStr = (new String(txt)).trim();
            if(ToDoListStr.equals("")) {
                contextToDoList.setVisibility(View.INVISIBLE);
                newWrite.setText("할 일 추가하기");
                delToDoList.setVisibility(View.INVISIBLE);
            } else {
                contextToDoList.setEnabled(false);
                contextToDoList.setVisibility(View.VISIBLE);
                newWrite.setText("읽기 & 수정");
                delToDoList.setVisibility(View.VISIBLE);
            }
        } catch (IOException e) {
            contextToDoList.setVisibility(View.INVISIBLE);
            newWrite.setText("할 일 추가하기");
            delToDoList.setVisibility(View.INVISIBLE);
            e.printStackTrace();
        }
        return ToDoListStr;
    }

    // 할 일 파일 읽기
    void checkedDay(int year, int month, int day) {
        // 받은 날짜로 날짜 보여주기
        tv_text.setText(year + "년");
        tv_text2.setText((month + 1) + "월 " + day + "일");
        fileName = Integer.toString(year) + Integer.toString(month+1) + Integer.toString(day) + ".txt";
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = readToDoList(fileName);
            if(str.equals("")) {
                contextToDoList.setVisibility(View.INVISIBLE);
                newWrite.setText("할 일 추가하기");
                delToDoList.setVisibility(View.INVISIBLE);
            } else {
                contextToDoList.setText(str);
                newWrite.setText("수정");
            }
        } catch (Exception e) { // UnsupportedEncodingException , FileNotFoundException , IOException
            contextToDoList.setText("");
            newWrite.setText("할 일 추가하기");
            e.printStackTrace();
        }
    }

    public void setTodayDate(View view) {
        Calendar c = Calendar.getInstance();
        int todayYear = c.get(Calendar.YEAR);
        int todayMonth = c.get(Calendar.MONTH);
        int todayDay = c.get(Calendar.DAY_OF_MONTH);

        // Set the CalendarView to today's date
        CalView.setDate(c.getTimeInMillis(), true, true);

        // Update TextViews accordingly
        tv_text.setText(todayYear + "년");
        tv_text2.setText((todayMonth + 1) + "월 " + todayDay + "일");
        tv_text3.setText(todayYear + "년 " + (todayMonth + 1) + "월 " + todayDay + "일");

        // Load diary for today
        checkedDay(todayYear, todayMonth, todayDay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.timetable:
                Intent intent = new Intent(this, TimetableActivity.class);
                startActivity(intent);
                return true;

            case R.id.resetPin:
                dialogView = (View) View.inflate(MainActivity.this,
                        R.layout.reset_pin_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("PIN 재설정");
                dlg.setIcon(R.drawable.resetpng);
                dlg.setView(dialogView);
                dlg.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgReset1 = (EditText) dialogView.findViewById(R.id.dlgReset1);
                        dlgReset2 = (EditText) dialogView.findViewById(R.id.dlgReset2);
                        hintPass = (EditText) dialogView.findViewById(R.id.hintPass);
                        String reset1 = dlgReset1.getText().toString();
                        String reset2 = dlgReset2.getText().toString();
                        String hintPassword = hintPass.getText().toString();
                        if (reset1.equals(reset2)) {
                            try {
                                FileOutputStream outFs = openFileOutput("password.txt", Context.MODE_PRIVATE);
                                outFs.write(reset1.getBytes());
                                outFs.close();
                                FileOutputStream outFs2 = openFileOutput("hint.txt", Context.MODE_PRIVATE);
                                outFs2.write(hintPassword.getBytes());
                                outFs2.close();
                                Toast.makeText(getApplicationContext(), "핀 번호가 " + reset1 + "으로 변경되었습니다!", Toast.LENGTH_SHORT).show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "변경할 핀 번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소했습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
                return true;

            case R.id.resetName:
                dialogView = (View) View.inflate(MainActivity.this,
                        R.layout.set_user_name, null);
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                dlg2.setTitle("사용자 이름 설정");
                dlg2.setIcon(R.drawable.resetpng);
                dlg2.setView(dialogView);
                dlg2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgName = (EditText) dialogView.findViewById(R.id.dlgName);
                        String userName = dlgName.getText().toString();
                        if (userName != null) {
                            try {
                                FileOutputStream outFs = openFileOutput("name.txt", Context.MODE_PRIVATE);
                                outFs.write(userName.getBytes());
                                outFs.close();
                                Toast.makeText(getApplicationContext(), userName + "님 반갑습니다!", Toast.LENGTH_SHORT).show();
                                header_title.setText(userName + "님의 To Do List");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg2.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소했습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg2.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void delDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("할 일 삭제").setMessage("정말로 할 일을 삭제하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteFile(fileName);
                contextToDoList.setText("");
                contextToDoList.setVisibility(View.INVISIBLE);
                delToDoList.setVisibility(View.INVISIBLE);
                newWrite.setText("할 일 추가하기");
                Toast.makeText(getApplicationContext(), "할 일을 삭제하였습니다!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"취소하셨습니다!", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}