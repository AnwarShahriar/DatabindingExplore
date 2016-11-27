package me.anwarshahriar.databindingexplore;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        Student aStudent = new Student("Shahriar Anwar", 28);
        binding.setAStudent(aStudent);
        binding.setHandler(new EventHandler());

        Student jamal = new Student("Jamal Ahmed", 15);

        List<Student> students = new ArrayList<>();
        students.add(jamal);

        Map<String, Integer> nameVsAge = new HashMap<>();
        nameVsAge.put(jamal.getName(), jamal.getAge());

        binding.setStudents(students);
        binding.setNameVsAge(nameVsAge);
        binding.setShowStar(false);
    }

    public class EventHandler {
        public void handleClick(String name) {
            Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
        }
    }

    public class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
