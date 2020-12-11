package pzpi_17_8.tran_xuan_tkhanh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColorViewModel extends ViewModel {

    MutableLiveData<Integer> greenColor;
    MutableLiveData<Integer> blueColor;
    MutableLiveData<Integer> redColor;

    public LiveData<Integer> GetGreen(){
        if(greenColor == null){
            greenColor = new MutableLiveData<>();
            greenColor.postValue(0);
        }
        return greenColor;
    }

    public LiveData<Integer> GetBlue(){
        if(blueColor == null){
            blueColor = new MutableLiveData<>();
            blueColor.postValue(0);
        }
        return blueColor;
    }

    public LiveData<Integer> GetRed(){
        if(redColor == null){
            redColor = new MutableLiveData<>();
            redColor.postValue(0);
        }
        return redColor;
    }

    public void PostGreen(int num){
        int valueToPost = num;
        if(num < 0) valueToPost = 0;
        if(num > 255) valueToPost = 0;
        greenColor.postValue(valueToPost);
    }

    public void PostBlue(int num){
        int valueToPost = num;
        if(num < 0) valueToPost = 0;
        if(num > 255) valueToPost = 0;
        blueColor.postValue(valueToPost);
    }

    public void PostRed(int num){
        int valueToPost = num;
        if(num < 0) valueToPost = 0;
        if(num > 255) valueToPost = 0;
        redColor.postValue(valueToPost);
    }
}
