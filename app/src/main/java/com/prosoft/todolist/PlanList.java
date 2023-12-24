package com.prosoft.todolist;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PlanList extends AppCompatActivity {
    ListView listView;
    ListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("할 일 목록");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MODE_PRIVATE);

        adapter = new ListItemAdapter();
        listView = findViewById(R.id.planList);

        // Read and display the file list
        displayFileList();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                ListItem selectedItem = (ListItem) adapter.getItem(position);
                if (selectedItem != null) {
                    String datas = selectedItem.getName();
                    Toast.makeText(getApplicationContext(), datas, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                    intent.putExtra("years", datas.substring(0, 5));
                    intent.putExtra("monthdays", datas.substring(6));
                    startActivity(intent);
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
                @SuppressWarnings("unchecked")
                ListItem selectedItem = (ListItem) adapter.getItem(position);
                if (selectedItem != null) {
                    String datas = selectedItem.getName();
                    String datasName = datas.substring(0, 4) + datas.substring(6, 8) + datas.substring(10) + ".txt";
                    showDeleteConfirmationDialog(datasName, position);
                    return true;
                }
                return false;
            }
        });
    }

    private void displayFileList() {
        File fp = getFilesDir();
        if (fp.exists()) {
            File[] files = fp.listFiles();
            String fileName, extName;
            for (File file : files) {
                if (!file.isHidden() && file.isFile()) {
                    fileName = file.getName();
                    extName = fileName;
                    fileName = fileName.replaceAll(".txt", "");
                    String fYear, fMonth, fDay;

                    if (fileName.length() == 8) {
                        fYear = fileName.substring(0, 4);
                        fMonth = fileName.substring(4, 6);
                        fDay = fileName.substring(6, 8);
                    } else if (fileName.length() == 6) {
                        fYear = fileName.substring(0, 2);
                        fMonth = fileName.substring(2, 4);
                        fDay = fileName.substring(4, 6);
                    } else {
                        // 예외 처리 또는 기본 값 설정
                        continue; // 파일명이 기대하는 형식이 아니면 건너뛰기
                    }

                    try {
                        FileInputStream inFs = openFileInput(extName);
                        byte[] txt = new byte[60];
                        inFs.read(txt);
                        String str = new String(txt).trim(); // trim 추가

                        if (str.isEmpty()) {
                            // 메모가 없는 경우 아이템을 추가하지 않고 다음 파일로 진행
                            continue;
                        }

                        inFs.close(); // Close the FileInputStream
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void showDeleteConfirmationDialog(final String fileName, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("할 일 삭제").setMessage("정말로 할 일을 삭제하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "할 일을 삭제하였습니다!", Toast.LENGTH_SHORT).show();
                deleteFile(fileName);
                adapter.removeItem(position);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소하셨습니다!", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
