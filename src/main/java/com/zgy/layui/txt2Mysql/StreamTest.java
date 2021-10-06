package com.zgy.layui.txt2Mysql;

import com.zgy.layui.entity.Kz;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/28 16:53
 */
public class StreamTest {

    public List<Kz> getAllKZObject() throws IOException {
        //创建file实例
        File file = new File("D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\temp\\kz.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Kz> list = new ArrayList<>();
        String data;
//        br.readLine(); // 跳过文件第一行
        while ((data = br.readLine()) != null) {
            Kz kz = new Kz();
            String[] split = data.split("@@");
            kz.setMontha(split[0]);
            kz.setUserId(split[1]);
            kz.setEventType(split[2]);
            kz.setProductId(split[3]);
            kz.setCategoryId(split[4]);
            kz.setCategoryCode(split[5]);
            kz.setBrandName(split[6]);
            kz.setPrice(Double.parseDouble(split[7]));
            list.add(kz);
        }
        br.close();

//        int i = 0;
        return list;
    }
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        for (String s : filtered) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() throws IOException {
        List<Kz> kzList = getAllKZObject();
        Map<String, Double> sumPrice = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.summingDouble(Kz::getPrice)));
        Map<String, Long> countUser = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.counting()));
        int i = 0;

    }
}
