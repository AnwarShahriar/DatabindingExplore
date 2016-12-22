package me.anwarshahriar.databindingexplore;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        ViewModel model = new ViewModel();
        model.setColor(Color.BLACK);
        binding.setModel(model);
    }

    public class ViewModel extends BaseObservable {
        private int color;

        public void setColor(int color) {
            this.color = color;
            notifyPropertyChanged(BR.color);
        }

        @Bindable
        public int getColor() {
            return color;
        }
    }

}
