package com.zgy.layui.bigdataHandler;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class WordCount {
    public static void main(String[] args) throws Exception {
        //创建执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        
        //读取文件
        String inputPath = "D:\\FlinkProjects\\FlinkTutorial\\src\\main\\resources\\hello.txt";
        DataSet<String> inputDataSet = env.readTextFile(inputPath);

        //处理数据转换为（word,1)
        DataSet<Tuple2<String,Integer>> resultSet = inputDataSet.flatMap(new MyFlatMapper())
                .groupBy(0)    //按照第一个位置word分组
                .sum(1);//将第二个位置上的数据求和

        resultSet.print();


    }
    //自定义类，实现FlatMapFunction接口
    public static class MyFlatMapper implements FlatMapFunction<String, Tuple2<String,Integer>> {


        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            //按空格分词
            String[] words = value.split(" \n" +
                    "\n" +
                    "        @Override");
            //遍历所有word，包成二元组输出
            for (String word:words){
                out.collect(new Tuple2<>(word,1));
            }
        }
    }
}
