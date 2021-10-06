package com.zgy.layui.streamHandler;

import com.zgy.layui.entity.Kz;
import com.zgy.layui.vo.KzLineVO;
import com.zgy.layui.vo.KzOneLineVO;
import com.zgy.layui.vo.KzScatterVO;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/29 17:16
 */
@Service
public class KzStreamHandler {
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

    public Map<String, Double> getSumPrice() throws IOException {
        List<Kz> kzList = getAllKZObject();
        Map<String, Double> sumPrice = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.summingDouble(Kz::getPrice)));
        return sumPrice;
    }

    public Map<String, Long> countUser() throws IOException {
        List<Kz> kzList = getAllKZObject();
        Map<String, Long> countUser = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.counting()));
        return countUser;
    }


    public KzLineVO getLineVO() throws IOException {
        List<Kz> kzList = getAllKZObject();
        List<String> monthas = new ArrayList<>();
        List<Double> consumSums = new ArrayList<>();
        List<Long> consumNums = new ArrayList<>();
        Map<String, Double> sumPrice = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.summingDouble(Kz::getPrice)));
        Map<String, Long> countUser = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.counting()));
        Object[] array = sumPrice.keySet().stream().sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            monthas.add((String) array[i]);
            consumSums.add(sumPrice.get(array[i])/10000);
            consumNums.add(countUser.get(array[i]));
        }
        KzLineVO lineVO = new KzLineVO();
        lineVO.setMonthas(monthas);
        lineVO.setConsumSums(consumSums);
        lineVO.setConsumNums(consumNums);
        return lineVO;
    }

//    @Test
    public KzScatterVO getScatterVO() throws IOException {
        List<Kz> kzList = getAllKZObject();
        List<String> userId = new ArrayList<>();
        List<Double> consumSums = new ArrayList<>();
        List<Long> consumNums = new ArrayList<>();
        Map<String, Double> sumPrice = kzList.stream().collect(Collectors.groupingBy(Kz::getUserId, Collectors.summingDouble(Kz::getPrice)));
        Map<String, Long> countUser = kzList.stream().collect(Collectors.groupingBy(Kz::getUserId, Collectors.counting()));
        Object[] array = sumPrice.keySet().stream().sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            userId.add((String) array[i]);
            consumSums.add(sumPrice.get(array[i])/10000);
            consumNums.add(countUser.get(array[i]));
        }
        KzScatterVO scatterVO = new KzScatterVO();
        scatterVO.setUserId(userId);
        scatterVO.setConsumSums(consumSums);
        scatterVO.setConsumNums(consumNums);
//        int i = 0;
        return scatterVO;
    }

//    @Test
    public Long getAllUserCount() throws IOException {
        ////395841
        List<Kz> kzList = getAllKZObject();
        //89919
        long idCount = kzList.stream().map(e -> e.getUserId()).distinct().count();
        return idCount;
    }


//    @Test
    public KzOneLineVO getOneLineVO() throws IOException {
//        KzOneLineVO
        List<Kz> kzList = getAllKZObject();
        Map<String, Double> sumPrice = kzList.stream().collect(Collectors.groupingBy(Kz::getUserId, Collectors.summingDouble(Kz::getPrice)));
        List<Long> userNums = new ArrayList<>();
        List<Double> cumPs = new ArrayList<>();
        Double allSum = sumPrice.values().stream().reduce((double) 0, Double::sum);
        List<Double> list = sumPrice.values().stream().sorted().collect(Collectors.toList());
        Double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
            userNums.add((long) i+1);
            cumPs.add(sum/allSum);
        }
        KzOneLineVO kzOneLineVO = new KzOneLineVO();
        kzOneLineVO.setUserNums(userNums);
        kzOneLineVO.setCumPs(cumPs);

//        Double cur = cumPs.get(cumPs.size() - 1);
//        int i = 0;
        return kzOneLineVO;
    }




    @Test
    public void test2() throws IOException {
        List<Kz> kzList = getAllKZObject();
        List<String> monthas = new ArrayList<>();
        List<Double> consumSums = new ArrayList<>();
        List<Long> consumNums = new ArrayList<>();
        Map<String, Double> sumPrice = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.summingDouble(Kz::getPrice)));
        Map<String, Long> countUser = kzList.stream().collect(Collectors.groupingBy(Kz::getMontha, Collectors.counting()));
        Object[] array = sumPrice.keySet().stream().sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            monthas.add((String) array[i]);
            consumSums.add(sumPrice.get(array[i]));
            consumNums.add(countUser.get(array[i]));
        }
        KzLineVO scatterVO = new KzLineVO();
        scatterVO.setMonthas(monthas);
        scatterVO.setConsumSums(consumSums);
        scatterVO.setConsumNums(consumNums);
        int i = 0;

    }
}
