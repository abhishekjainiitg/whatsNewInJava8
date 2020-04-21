package com.Java8;

import com.Java8.DataAndTime.MainDateAndTime;
import com.Java8.LambdaExpression.MainLambdaExpression;
import com.Java8.NewAPI.MapMergeExample;
import com.Java8.StreamCollectors.MainStreamCollectors;

public class Main {

    public static void main(String[] args) {
        MainLambdaExpression mainLambdaExpression = new MainLambdaExpression();
        mainLambdaExpression.execute();

        MainStreamCollectors mainStreamCollectors = new MainStreamCollectors();
        mainStreamCollectors.execute();

        MainDateAndTime mainDateAndTime = new MainDateAndTime();
        mainDateAndTime.execute();

        MapMergeExample mapMergeExample = new MapMergeExample();
        mapMergeExample.execute();
    }
}
