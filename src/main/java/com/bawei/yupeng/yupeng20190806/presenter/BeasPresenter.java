package com.bawei.yupeng.yupeng20190806.presenter;

public class BeasPresenter<V> {
    private V mainview;
    private void adattch(V mainActivity){
        mainview =  mainActivity;
    }
    private void datach(){
        mainview = null;
    }
    public  BeasPresenter getbeaspres(){
        return (BeasPresenter) mainview;
    }
}
