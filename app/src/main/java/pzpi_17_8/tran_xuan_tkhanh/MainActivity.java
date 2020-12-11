package pzpi_17_8.tran_xuan_tkhanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    LinearLayout colorPanel;
    SeekBar greenBar;
    SeekBar blueBar;
    SeekBar redBar;
    int green;
    int blue;
    int red;
    ColorViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorPanel = findViewById(R.id.colorPanel);
        greenBar = findViewById(R.id.seekBarGreen);
        blueBar = findViewById(R.id.seekBarBlue);
        redBar = findViewById(R.id.seekBarRed);
        greenBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueBar.setOnSeekBarChangeListener(seekBarChangeListener);
        redBar.setOnSeekBarChangeListener(seekBarChangeListener);

        vm = new ViewModelProvider(this).get(ColorViewModel.class);

        vm.GetBlue().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                blue = integer;
                updateColorPanel();
            }
        });

        vm.GetGreen().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                green = integer;
                updateColorPanel();
            }
        });

        vm.GetRed().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                red = integer;
                updateColorPanel();
            }
        });

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            switch (seekBar.getId()){
                case R.id.seekBarBlue:
                    vm.PostBlue(i);
                    break;
                case R.id.seekBarGreen:
                   vm.PostGreen(i);
                    break;
                case R.id.seekBarRed:
                    vm.PostRed(i);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateColorPanel(){
        colorPanel.setBackgroundColor(0xff000000 + red * 0x10000 + green * 0x100 + blue);
    }
}