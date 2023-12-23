//package com.prosoft.todolist;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Locale;
//
//public class TimetableActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timetable);
//
//        ArrayList<TodoItem> todayTasks = loadTodayTasks(); // 오늘의 할 일 데이터 로드
//        if (todayTasks != null) {
//            displayTasksOnTimetable(todayTasks); // 할 일을 타임테이블에 표시
//        }
//    }
//
//
//    private ArrayList<TodoItem> loadTodayTasks() {
//        String todayDate = getTodayDate();
//        String fileName = todayDate + ".txt"; // 'yyyy-MM-dd.txt' 형식
//        // TODO: 오늘 날짜(todayDate)에 해당하는 할 일 데이터 로드
//        // TODO: 로드된 데이터를 화면에 표시
//        return null;
//    }
//
//    private String getTodayDate() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//        return dateFormat.format(new Date());
//    }
//
//    private void displayTasksOnTimetable(ArrayList<TodoItem> tasks) {
//        for (TodoItem task : tasks) {
//            String time = roundToNearestHalfHour(task.getTime()); // 반올림 또는 절사
//            TextView timeSlot = findTimeSlotView(time);
//            if (timeSlot != null) {
//                String existingText = timeSlot.getText().toString();
//                timeSlot.setText(existingText + "\n" + task.getTask());
//            }
//        }
//    }
//    private String roundToNearestHalfHour(String time) {
//        String[] parts = time.split(":");
//        int hour = Integer.parseInt(parts[0]);
//        int minutes = Integer.parseInt(parts[1]);
//
//        if (minutes < 15) {
//            minutes = 0;
//        } else if (minutes < 45) {
//            minutes = 30;
//        } else {
//            minutes = 0;
//            hour++; // 다음 시간으로 넘어감
//        }
//
//        // 24시간 형식 유지
//        if (hour == 24) hour = 0;
//
//        return String.format(Locale.getDefault(), "%02d:%02d", hour, minutes);
//    }
//
//    private TextView findTimeSlotView(String time) {
//        int hour = Integer.parseInt(time.split(":")[0]);
//        int minutes = Integer.parseInt(time.split(":")[1]);
//
//        String viewId = "time_" + (hour < 10 ? "0" + hour : hour) + (minutes == 0 ? "00" : "30");
//        int resId = getResources().getIdentifier(viewId, "id", getPackageName());
//        return findViewById(resId);
//    }
//
//}



package com.prosoft.todolist;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimetableActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView six1,six2,six3,six4,six5,six6;
        TextView seven1,seven2,seven3,seven4,seven5,seven6;
        TextView eight1,eight2,eight3,eight4,eight5,eight6;
        TextView nine1,nine2,nine3,nine4,nine5,nine6;
        TextView ten1,ten2,ten3,ten4,ten5,ten6;
        TextView eleven1,eleven2,eleven3,eleven4,eleven5,eleven6;
        TextView twelve1,twelve2,twelve3,twelve4,twelve5,twelve6;
        TextView thirteen1,thirteen2,thirteen3,thirteen4,thirteen5,thirteen6;
        TextView fourteen1,fourteen2,fourteen3,fourteen4,fourteen5,fourteen6;
        TextView fifteen1,fifteen2,fifteen3,fifteen4,fifteen5,fifteen6;
        TextView sixteen1,sixteen2,sixteen3,sixteen4,sixteen5,sixteen6;
        TextView seventeen1,seventeen2,seventeen3,seventeen4,seventeen5,seventeen6;
        TextView eighteen1,eighteen2,eighteen3,eighteen4,eighteen5,eighteen6;
        TextView nineteen1,nineteen2,nineteen3,nineteen4,nineteen5,nineteen6;
        TextView twenty1,twenty2,twenty3,twenty4,twenty5,twenty6;
        TextView twentyone1,twentyone2,twentyone3,twentyone4,twentyone5,twentyone6;
        TextView twentytwo1,twentytwo2,twentytwo3,twentytwo4,twentytwo5,twentytwo6;
        TextView twentythree1,twentythree2,twentythree3,twentythree4,twentythree5,twentythree6;
        TextView zero1,zero2,zero3,zero4,zero5,zero6;
        TextView one1,one2,one3,one4,one5,one6;
        TextView two1,two2,two3,two4,two5,two6;
        TextView three1,three2,three3,three4,three5,three6;
        TextView four1,four2,four3,four4,four5,four6;
        TextView five1,five2,five3,five4,five5,five6;

        Button reset;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        six1 = (TextView)findViewById(R.id.six1);
        six2 = (TextView)findViewById(R.id.six2);
        six3 = (TextView)findViewById(R.id.six3);
        six4 = (TextView)findViewById(R.id.six4);
        six5 = (TextView)findViewById(R.id.six5);
        six6 = (TextView)findViewById(R.id.six6);

        six1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                six1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        six2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                six2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        six3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                six3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        six4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                six4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        six5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                six5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        six6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                six6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        seven1 = (TextView)findViewById(R.id.seven1);
        seven2 = (TextView)findViewById(R.id.seven2);
        seven3 = (TextView)findViewById(R.id.seven3);
        seven4 = (TextView)findViewById(R.id.seven4);
        seven5 = (TextView)findViewById(R.id.seven5);
        seven6 = (TextView)findViewById(R.id.seven6);

        seven1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seven1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seven2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seven2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seven3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seven3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seven4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seven4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seven5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seven5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seven6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seven6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });


        eight1 = (TextView)findViewById(R.id.eight1);
        eight2 = (TextView)findViewById(R.id.eight2);
        eight3 = (TextView)findViewById(R.id.eight3);
        eight4 = (TextView)findViewById(R.id.eight4);
        eight5 = (TextView)findViewById(R.id.eight5);
        eight6 = (TextView)findViewById(R.id.eight6);

        eight1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eight1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eight2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eight2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eight3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eight3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eight4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eight4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eight5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eight5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eight6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eight6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        nine1 = (TextView)findViewById(R.id.nine1);
        nine2 = (TextView)findViewById(R.id.nine2);
        nine3 = (TextView)findViewById(R.id.nine3);
        nine4 = (TextView)findViewById(R.id.nine4);
        nine5 = (TextView)findViewById(R.id.nine5);
        nine6 = (TextView)findViewById(R.id.nine6);

        nine1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nine1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nine2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nine2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nine3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nine3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nine4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nine4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nine5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nine5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nine6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nine6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        ten1 = (TextView)findViewById(R.id.ten1);
        ten2 = (TextView)findViewById(R.id.ten2);
        ten3 = (TextView)findViewById(R.id.ten3);
        ten4 = (TextView)findViewById(R.id.ten4);
        ten5 = (TextView)findViewById(R.id.ten5);
        ten6 = (TextView)findViewById(R.id.ten6);

        ten1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ten1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        ten2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ten2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        ten3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ten3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        ten4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ten4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        ten5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ten5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        ten6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ten6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        eleven1 = (TextView)findViewById(R.id.eleven1);
        eleven2 = (TextView)findViewById(R.id.eleven2);
        eleven3 = (TextView)findViewById(R.id.eleven3);
        eleven4 = (TextView)findViewById(R.id.eleven4);
        eleven5 = (TextView)findViewById(R.id.eleven5);
        eleven6 = (TextView)findViewById(R.id.eleven6);

        eleven1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eleven1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eleven2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eleven2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eleven3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eleven3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eleven4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eleven4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eleven5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eleven5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eleven6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eleven6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        twelve1 = (TextView)findViewById(R.id.twelve1);
        twelve2 = (TextView)findViewById(R.id.twelve2);
        twelve3 = (TextView)findViewById(R.id.twelve3);
        twelve4 = (TextView)findViewById(R.id.twelve4);
        twelve5 = (TextView)findViewById(R.id.twelve5);
        twelve6 = (TextView)findViewById(R.id.twelve6);

        twelve1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twelve1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twelve2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twelve2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twelve3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twelve3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twelve4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twelve4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twelve5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twelve5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twelve6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twelve6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        thirteen1 = (TextView)findViewById(R.id.thirteen1);
        thirteen2 = (TextView)findViewById(R.id.thirteen2);
        thirteen3 = (TextView)findViewById(R.id.thirteen3);
        thirteen4 = (TextView)findViewById(R.id.thirteen4);
        thirteen5 = (TextView)findViewById(R.id.thirteen5);
        thirteen6 = (TextView)findViewById(R.id.thirteen6);

        thirteen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thirteen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        thirteen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thirteen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        thirteen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thirteen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        thirteen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thirteen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        thirteen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thirteen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        thirteen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thirteen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        fourteen1 = (TextView)findViewById(R.id.fourteen1);
        fourteen2 = (TextView)findViewById(R.id.fourteen2);
        fourteen3 = (TextView)findViewById(R.id.fourteen3);
        fourteen4 = (TextView)findViewById(R.id.fourteen4);
        fourteen5 = (TextView)findViewById(R.id.fourteen5);
        fourteen6 = (TextView)findViewById(R.id.fourteen6);

        fourteen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fourteen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fourteen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fourteen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fourteen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fourteen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fourteen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fourteen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fourteen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fourteen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fourteen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fourteen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        fifteen1 = (TextView)findViewById(R.id.fifteen1);
        fifteen2 = (TextView)findViewById(R.id.fifteen2);
        fifteen3 = (TextView)findViewById(R.id.fifteen3);
        fifteen4 = (TextView)findViewById(R.id.fifteen4);
        fifteen5 = (TextView)findViewById(R.id.fifteen5);
        fifteen6 = (TextView)findViewById(R.id.fifteen6);

        fifteen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fifteen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fifteen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fifteen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fifteen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fifteen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fifteen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fifteen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fifteen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fifteen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        fifteen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fifteen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        sixteen1 = (TextView)findViewById(R.id.sixteen1);
        sixteen2 = (TextView)findViewById(R.id.sixteen2);
        sixteen3 = (TextView)findViewById(R.id.sixteen3);
        sixteen4 = (TextView)findViewById(R.id.sixteen4);
        sixteen5 = (TextView)findViewById(R.id.sixteen5);
        sixteen6 = (TextView)findViewById(R.id.sixteen6);

        sixteen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sixteen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        sixteen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sixteen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        sixteen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sixteen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        sixteen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sixteen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        sixteen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sixteen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        sixteen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sixteen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        seventeen1 = (TextView)findViewById(R.id.seventeen1);
        seventeen2 = (TextView)findViewById(R.id.seventeen2);
        seventeen3 = (TextView)findViewById(R.id.seventeen3);
        seventeen4 = (TextView)findViewById(R.id.seventeen4);
        seventeen5 = (TextView)findViewById(R.id.seventeen5);
        seventeen6 = (TextView)findViewById(R.id.seventeen6);

        seventeen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seventeen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seventeen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seventeen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seventeen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seventeen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seventeen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seventeen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seventeen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seventeen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        seventeen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                seventeen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eighteen1 = (TextView)findViewById(R.id.eighteen1);
        eighteen2 = (TextView)findViewById(R.id.eighteen2);
        eighteen3 = (TextView)findViewById(R.id.eighteen3);
        eighteen4 = (TextView)findViewById(R.id.eighteen4);
        eighteen5 = (TextView)findViewById(R.id.eighteen5);
        eighteen6 = (TextView)findViewById(R.id.eighteen6);

        eighteen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eighteen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eighteen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eighteen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eighteen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eighteen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eighteen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eighteen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eighteen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eighteen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        eighteen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eighteen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nineteen1 = (TextView)findViewById(R.id.nineteen1);
        nineteen2 = (TextView)findViewById(R.id.nineteen2);
        nineteen3 = (TextView)findViewById(R.id.nineteen3);
        nineteen4 = (TextView)findViewById(R.id.nineteen4);
        nineteen5 = (TextView)findViewById(R.id.nineteen5);
        nineteen6 = (TextView)findViewById(R.id.nineteen6);

        nineteen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nineteen1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nineteen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nineteen2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nineteen3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nineteen3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nineteen4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nineteen4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nineteen5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nineteen5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        nineteen6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nineteen6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        twenty1 = (TextView)findViewById(R.id.twenty1);
        twenty2 = (TextView)findViewById(R.id.twenty2);
        twenty3 = (TextView)findViewById(R.id.twenty3);
        twenty4 = (TextView)findViewById(R.id.twenty4);
        twenty5 = (TextView)findViewById(R.id.twenty5);
        twenty6 = (TextView)findViewById(R.id.twenty6);

        twenty1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twenty1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twenty2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twenty2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twenty3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twenty3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twenty4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twenty4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twenty5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twenty5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twenty6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twenty6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        twentyone1 = (TextView)findViewById(R.id.twentyone1);
        twentyone2 = (TextView)findViewById(R.id.twentyone2);
        twentyone3 = (TextView)findViewById(R.id.twentyone3);
        twentyone4 = (TextView)findViewById(R.id.twentyone4);
        twentyone5 = (TextView)findViewById(R.id.twentyone5);
        twentyone6 = (TextView)findViewById(R.id.twentyone6);

        twentyone1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentyone1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentyone2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentyone2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentyone3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentyone3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentyone4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentyone4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentyone5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentyone5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentyone6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentyone6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        twentytwo1 = (TextView)findViewById(R.id.twentytwo1);
        twentytwo2 = (TextView)findViewById(R.id.twentytwo2);
        twentytwo3 = (TextView)findViewById(R.id.twentytwo3);
        twentytwo4 = (TextView)findViewById(R.id.twentytwo4);
        twentytwo5 = (TextView)findViewById(R.id.twentytwo5);
        twentytwo6 = (TextView)findViewById(R.id.twentytwo6);

        twentytwo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentytwo1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentytwo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentytwo2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentytwo3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentytwo3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentytwo4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentytwo4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentytwo5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentytwo5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentytwo6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentytwo6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        twentythree1 = (TextView)findViewById(R.id.twentythree1);
        twentythree2 = (TextView)findViewById(R.id.twentythree2);
        twentythree3 = (TextView)findViewById(R.id.twentythree3);
        twentythree4 = (TextView)findViewById(R.id.twentythree4);
        twentythree5 = (TextView)findViewById(R.id.twentythree5);
        twentythree6 = (TextView)findViewById(R.id.twentythree6);

        twentythree1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentythree1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentythree2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentythree2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentythree3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentythree3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentythree4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentythree4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentythree5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentythree5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        twentythree6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                twentythree6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        zero1 = (TextView)findViewById(R.id.zero1);
        zero2 = (TextView)findViewById(R.id.zero2);
        zero3 = (TextView)findViewById(R.id.zero3);
        zero4 = (TextView)findViewById(R.id.zero4);
        zero5 = (TextView)findViewById(R.id.zero5);
        zero6 = (TextView)findViewById(R.id.zero6);

        zero1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                zero1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        zero2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                zero2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        zero3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                zero3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        zero4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                zero4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        zero5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                zero5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        zero6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                zero6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        one1 = (TextView)findViewById(R.id.one1);
        one2 = (TextView)findViewById(R.id.one2);
        one3 = (TextView)findViewById(R.id.one3);
        one4 = (TextView)findViewById(R.id.one4);
        one5 = (TextView)findViewById(R.id.one5);
        one6 = (TextView)findViewById(R.id.one6);

        one1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                one1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        one2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                one2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        one3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                one3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        one4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                one4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        one5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                one5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        one6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                one6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        two1 = (TextView)findViewById(R.id.two1);
        two2 = (TextView)findViewById(R.id.two2);
        two3 = (TextView)findViewById(R.id.two3);
        two4 = (TextView)findViewById(R.id.two4);
        two5 = (TextView)findViewById(R.id.two5);
        two6 = (TextView)findViewById(R.id.two6);

        two1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                two1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        two2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                two2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        two3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                two3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        two4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                two4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        two5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                two5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        two6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                two6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        three1 = (TextView)findViewById(R.id.three1);
        three2 = (TextView)findViewById(R.id.three2);
        three3 = (TextView)findViewById(R.id.three3);
        three4 = (TextView)findViewById(R.id.three4);
        three5 = (TextView)findViewById(R.id.three5);
        three6 = (TextView)findViewById(R.id.three6);

        three1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                three1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        three2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                three2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        three3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                three3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        three4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                three4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        three5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                three5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        three6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                three6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        four1 = (TextView)findViewById(R.id.four1);
        four2 = (TextView)findViewById(R.id.four2);
        four3 = (TextView)findViewById(R.id.four3);
        four4 = (TextView)findViewById(R.id.four4);
        four5 = (TextView)findViewById(R.id.four5);
        four6 = (TextView)findViewById(R.id.four6);

        four1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                four1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        four2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                four2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        four3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                four3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        four4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                four4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        four5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                four5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        four6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                four6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });

        five1 = (TextView)findViewById(R.id.five1);
        five2 = (TextView)findViewById(R.id.five2);
        five3 = (TextView)findViewById(R.id.five3);
        five4 = (TextView)findViewById(R.id.five4);
        five5 = (TextView)findViewById(R.id.five5);
        five6 = (TextView)findViewById(R.id.five6);

        five1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                five1.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        five2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                five2.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        five3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                five3.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        five4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                five4.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        five5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                five5.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });
        five6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                five6.setBackgroundColor(Color.parseColor("#AED6F1"));
            }
        });


        reset = (Button)findViewById(R.id.initialization);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                six1.setBackgroundColor(Color.WHITE);
                six2.setBackgroundColor(Color.WHITE);
                six3.setBackgroundColor(Color.WHITE);
                six4.setBackgroundColor(Color.WHITE);
                six5.setBackgroundColor(Color.WHITE);
                six6.setBackgroundColor(Color.WHITE);

                seven1.setBackgroundColor(Color.WHITE);
                seven2.setBackgroundColor(Color.WHITE);
                seven3.setBackgroundColor(Color.WHITE);
                seven4.setBackgroundColor(Color.WHITE);
                seven5.setBackgroundColor(Color.WHITE);
                seven6.setBackgroundColor(Color.WHITE);

                eight1.setBackgroundColor(Color.WHITE);
                eight2.setBackgroundColor(Color.WHITE);
                eight3.setBackgroundColor(Color.WHITE);
                eight4.setBackgroundColor(Color.WHITE);
                eight5.setBackgroundColor(Color.WHITE);
                eight6.setBackgroundColor(Color.WHITE);

                nine1.setBackgroundColor(Color.WHITE);
                nine2.setBackgroundColor(Color.WHITE);
                nine3.setBackgroundColor(Color.WHITE);
                nine4.setBackgroundColor(Color.WHITE);
                nine5.setBackgroundColor(Color.WHITE);
                nine6.setBackgroundColor(Color.WHITE);

                ten1.setBackgroundColor(Color.WHITE);
                ten2.setBackgroundColor(Color.WHITE);
                ten3.setBackgroundColor(Color.WHITE);
                ten4.setBackgroundColor(Color.WHITE);
                ten5.setBackgroundColor(Color.WHITE);
                ten6.setBackgroundColor(Color.WHITE);

                eleven1.setBackgroundColor(Color.WHITE);
                eleven2.setBackgroundColor(Color.WHITE);
                eleven3.setBackgroundColor(Color.WHITE);
                eleven4.setBackgroundColor(Color.WHITE);
                eleven5.setBackgroundColor(Color.WHITE);
                eleven6.setBackgroundColor(Color.WHITE);

                twelve1.setBackgroundColor(Color.WHITE);
                twelve2.setBackgroundColor(Color.WHITE);
                twelve3.setBackgroundColor(Color.WHITE);
                twelve4.setBackgroundColor(Color.WHITE);
                twelve5.setBackgroundColor(Color.WHITE);
                twelve6.setBackgroundColor(Color.WHITE);

                thirteen1.setBackgroundColor(Color.WHITE);
                thirteen2.setBackgroundColor(Color.WHITE);
                thirteen3.setBackgroundColor(Color.WHITE);
                thirteen4.setBackgroundColor(Color.WHITE);
                thirteen5.setBackgroundColor(Color.WHITE);
                thirteen6.setBackgroundColor(Color.WHITE);

                fourteen1.setBackgroundColor(Color.WHITE);
                fourteen2.setBackgroundColor(Color.WHITE);
                fourteen3.setBackgroundColor(Color.WHITE);
                fourteen4.setBackgroundColor(Color.WHITE);
                fourteen5.setBackgroundColor(Color.WHITE);
                fourteen6.setBackgroundColor(Color.WHITE);

                fifteen1.setBackgroundColor(Color.WHITE);
                fifteen2.setBackgroundColor(Color.WHITE);
                fifteen3.setBackgroundColor(Color.WHITE);
                fifteen4.setBackgroundColor(Color.WHITE);
                fifteen5.setBackgroundColor(Color.WHITE);
                fifteen6.setBackgroundColor(Color.WHITE);

                sixteen1.setBackgroundColor(Color.WHITE);
                sixteen2.setBackgroundColor(Color.WHITE);
                sixteen3.setBackgroundColor(Color.WHITE);
                sixteen4.setBackgroundColor(Color.WHITE);
                sixteen5.setBackgroundColor(Color.WHITE);
                sixteen6.setBackgroundColor(Color.WHITE);

                seventeen1.setBackgroundColor(Color.WHITE);
                seventeen2.setBackgroundColor(Color.WHITE);
                seventeen3.setBackgroundColor(Color.WHITE);
                seventeen4.setBackgroundColor(Color.WHITE);
                seventeen5.setBackgroundColor(Color.WHITE);
                seventeen6.setBackgroundColor(Color.WHITE);

                eighteen1.setBackgroundColor(Color.WHITE);
                eighteen2.setBackgroundColor(Color.WHITE);
                eighteen3.setBackgroundColor(Color.WHITE);
                eighteen4.setBackgroundColor(Color.WHITE);
                eighteen5.setBackgroundColor(Color.WHITE);
                eighteen6.setBackgroundColor(Color.WHITE);

                nineteen1.setBackgroundColor(Color.WHITE);
                nineteen2.setBackgroundColor(Color.WHITE);
                nineteen3.setBackgroundColor(Color.WHITE);
                nineteen4.setBackgroundColor(Color.WHITE);
                nineteen5.setBackgroundColor(Color.WHITE);
                nineteen6.setBackgroundColor(Color.WHITE);

                twenty1.setBackgroundColor(Color.WHITE);
                twenty2.setBackgroundColor(Color.WHITE);
                twenty3.setBackgroundColor(Color.WHITE);
                twenty4.setBackgroundColor(Color.WHITE);
                twenty5.setBackgroundColor(Color.WHITE);
                twenty6.setBackgroundColor(Color.WHITE);

                twentyone1.setBackgroundColor(Color.WHITE);
                twentyone2.setBackgroundColor(Color.WHITE);
                twentyone3.setBackgroundColor(Color.WHITE);
                twentyone4.setBackgroundColor(Color.WHITE);
                twentyone5.setBackgroundColor(Color.WHITE);
                twentyone6.setBackgroundColor(Color.WHITE);

                twentytwo1.setBackgroundColor(Color.WHITE);
                twentytwo2.setBackgroundColor(Color.WHITE);
                twentytwo3.setBackgroundColor(Color.WHITE);
                twentytwo4.setBackgroundColor(Color.WHITE);
                twentytwo5.setBackgroundColor(Color.WHITE);
                twentytwo6.setBackgroundColor(Color.WHITE);

                twentythree1.setBackgroundColor(Color.WHITE);
                twentythree2.setBackgroundColor(Color.WHITE);
                twentythree3.setBackgroundColor(Color.WHITE);
                twentythree4.setBackgroundColor(Color.WHITE);
                twentythree5.setBackgroundColor(Color.WHITE);
                twentythree6.setBackgroundColor(Color.WHITE);

                zero1.setBackgroundColor(Color.WHITE);
                zero2.setBackgroundColor(Color.WHITE);
                zero3.setBackgroundColor(Color.WHITE);
                zero4.setBackgroundColor(Color.WHITE);
                zero5.setBackgroundColor(Color.WHITE);
                zero6.setBackgroundColor(Color.WHITE);

                one1.setBackgroundColor(Color.WHITE);
                one2.setBackgroundColor(Color.WHITE);
                one3.setBackgroundColor(Color.WHITE);
                one4.setBackgroundColor(Color.WHITE);
                one5.setBackgroundColor(Color.WHITE);
                one6.setBackgroundColor(Color.WHITE);

                two1.setBackgroundColor(Color.WHITE);
                two2.setBackgroundColor(Color.WHITE);
                two3.setBackgroundColor(Color.WHITE);
                two4.setBackgroundColor(Color.WHITE);
                two5.setBackgroundColor(Color.WHITE);
                two6.setBackgroundColor(Color.WHITE);

                three1.setBackgroundColor(Color.WHITE);
                three2.setBackgroundColor(Color.WHITE);
                three3.setBackgroundColor(Color.WHITE);
                three4.setBackgroundColor(Color.WHITE);
                three5.setBackgroundColor(Color.WHITE);
                three6.setBackgroundColor(Color.WHITE);

                four1.setBackgroundColor(Color.WHITE);
                four2.setBackgroundColor(Color.WHITE);
                four3.setBackgroundColor(Color.WHITE);
                four4.setBackgroundColor(Color.WHITE);
                four5.setBackgroundColor(Color.WHITE);
                four6.setBackgroundColor(Color.WHITE);

                five1.setBackgroundColor(Color.WHITE);
                five2.setBackgroundColor(Color.WHITE);
                five3.setBackgroundColor(Color.WHITE);
                five4.setBackgroundColor(Color.WHITE);
                five5.setBackgroundColor(Color.WHITE);
                five6.setBackgroundColor(Color.WHITE);

            }
        });
    }




}
