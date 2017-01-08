package me.anwarshahriar.databindingexplore;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        Student aStudent = new Student("Md. Shahriar Anwar", 99);
        aStudent.addCourse("CS-50");
        aStudent.addCourse("CS-101");

        binding.setStudent(aStudent);
    }
}
