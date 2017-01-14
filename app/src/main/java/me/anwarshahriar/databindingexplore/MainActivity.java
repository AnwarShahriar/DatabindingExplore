package me.anwarshahriar.databindingexplore;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        Student student = new Student("Md. Shahriar Anwar", 100);
        student.addCourse("CS-50");
        student.addCourse("CS-101");

        isDay = true;

        binding.setStudent(student);
        binding.setIsDay(isDay);
    }

    public void toggleTheme(View view) {
        isDay = !isDay;
        binding.setIsDay(isDay);
    }
}
