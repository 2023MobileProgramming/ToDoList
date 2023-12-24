package com.prosoft.todolist;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class WriteActivity extends AppCompatActivity {

    LinearLayout checkListLayout;
    String fileName;
    EditText feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_write);
        checkListLayout = findViewById(R.id.checkListLayout);


        // Initialize with current date
        TextView writeDay = findViewById(R.id.writeDay);
        Intent intent = getIntent();
        String year = intent.getStringExtra("years");
        String monthday = intent.getStringExtra("monthdays");
        fileName = year + " " + monthday + ".txt";

        // 현재 날짜를 TextView에 설정
        writeDay.setText(year + monthday);

        String str = readToDoList(fileName);
        // Use str to set up your view

        // Add new task
        Button btnAddTodo = findViewById(R.id.btnAddTodo);
        btnAddTodo.setOnClickListener(v -> addTodo());
    }

    private void addTodo() {
        LinearLayout taskLayout = new LinearLayout(this);
        taskLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        taskLayout.setOrientation(LinearLayout.HORIZONTAL);

        CheckBox checkBox = new CheckBox(this);
        taskLayout.addView(checkBox);

        EditText todoEditText = new EditText(this);
        todoEditText.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));
        todoEditText.setHint("할 일을 입력하세요.");
        taskLayout.addView(todoEditText);

        EditText timeEditText = new EditText(this);
        timeEditText.setFocusable(false); // To open TimePickerDialog
        timeEditText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        timeEditText.setOnClickListener(v -> pickTime(timeEditText));
        timeEditText.setHint("시간 선택");
        taskLayout.addView(timeEditText);

        checkListLayout.addView(taskLayout);
    }

    private void pickTime(EditText timeEditText) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minuteOfHour) ->
                        timeEditText.setText(String.format("%02d:%02d", hourOfDay, minuteOfHour)),
                hour,
                minute,
                true
        );
        timePickerDialog.show();
    }

    private String readToDoList(String fName) {
        String ToDoListStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[inFs.available()];
            inFs.read(txt);

            ToDoListStr = new String(txt).trim();
            inFs.close();

            // 파일에서 읽은 내용을 기반으로 체크박스 상태, 작업 텍스트, 시간을 설정
            String[] lines = ToDoListStr.split("\n");
            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String isChecked = parts[0];
                    String task = parts[1];
                    String time = parts[2];

                    LinearLayout taskLayout = new LinearLayout(this);
                    taskLayout.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    taskLayout.setOrientation(LinearLayout.HORIZONTAL);

                    CheckBox checkBox = new CheckBox(this);
                    checkBox.setChecked("1".equals(isChecked));
                    taskLayout.addView(checkBox);

                    EditText todoEditText = new EditText(this);
                    todoEditText.setLayoutParams(new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    ));
                    todoEditText.setText(task);
                    taskLayout.addView(todoEditText);

                    EditText timeEditText = new EditText(this);
                    timeEditText.setFocusable(false); // To open TimePickerDialog
                    timeEditText.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    timeEditText.setOnClickListener(v -> pickTime(timeEditText));
                    timeEditText.setText(time);
                    taskLayout.addView(timeEditText);

                    checkListLayout.addView(taskLayout);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ToDoListStr;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveMenu:
                saveTodo(fileName);
                return true;
        }
        return false;
    }

    private void saveTodo(String fileName) {
        boolean isTimeMissing = false;

        try {
            FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
            StringBuilder content = new StringBuilder();

            for (int i = 0; i < checkListLayout.getChildCount(); i++) {
                LinearLayout taskLayout = (LinearLayout) checkListLayout.getChildAt(i);
                CheckBox checkBox = (CheckBox) taskLayout.getChildAt(0);
                EditText taskEditText = (EditText) taskLayout.getChildAt(1);
                EditText timeEditText = (EditText) taskLayout.getChildAt(2);

                String task = taskEditText.getText().toString();
                String time = timeEditText.getText().toString(); // 시간 문자열 추출

                // 시간이 입력되지 않은 경우
                if (time.isEmpty()) {
                    isTimeMissing = true;
                    break;
                }

                // 체크박스 상태와 내용이 있을 때만 저장
                if (!task.isEmpty()) {
                    String isChecked = checkBox.isChecked() ? "1" : "0";
                    content.append(isChecked).append("|").append(task).append("|").append(time).append("\n");
                } else {
                    checkListLayout.removeView(taskLayout);
                    i--;
                }
            }

            if (!isTimeMissing) {
                fos.write(content.toString().getBytes());
                fos.close();

                Toast.makeText(getApplicationContext(), "할 일을 저장했습니다.", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "시간을 입력하세요", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "오류가 발생했습니다: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}