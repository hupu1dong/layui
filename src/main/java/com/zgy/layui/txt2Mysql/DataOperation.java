package com.zgy.layui.txt2Mysql;

import com.zgy.layui.entity.AirQuality;
import com.zgy.layui.entity.Goods;
import com.zgy.layui.entity.Kz;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/8 23:37
 */
@MapperScan("com.zgy.layui.mapper")
public class DataOperation {

    @Test
    public void test() throws Exception {
        //创建file实例
        File file = new File("D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\goods.txt");
        //提供具体的流
        FileReader fr = new FileReader(file);
        //数据的读入
        //read()：返回读入的字符，如果返回-1则到达文件末尾
        //方式一
//        int data = fr.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            data= fr.read();
//        }
        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
            data= fr.read();
        }
        fr.close();

    }

    @Test
    public void test2() throws Exception {
        //创建file实例
        File file = new File("D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\goods.txt");
//        File file = new File("D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\airpm25.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        String data;
        while ((data = br.readLine()) != null) {
            list.add(data);
            System.out.println(data);
        }
        br.close();
    }

    public List<Goods> getGoodsObject(Reader reader) throws IOException {
        //创建file实例
//        File file = new File("D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\goods.txt");
//        File file = new File("D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\airpm25.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(reader);
        ArrayList<Goods> list = new ArrayList<>();
        String data;
        while ((data = br.readLine()) != null) {
            Goods goods = new Goods();
            String[] split = data.split(",");
            goods.setId(split[0]);
            goods.setEvaluation(Integer.parseInt(split[1]));
            list.add(goods);
        }
        br.close();
        return list;
    }

    @Test
    public void testLocation() throws IOException {
        String filePath = "D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\location.txt";
        HashMap<String, String> location = getLocation(filePath);
        int i = 0;
    }
    public HashMap<String, String> getLocation(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<String, String> map = new HashMap<>();
        String data;
        while ((data = br.readLine()) != null) {
            String[] split = data.split(",");
            map.put(split[1],split[2]);
        }
        br.close();
        return map;
    }
    public List<AirQuality> getAirQualityObject(Reader reader) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(reader);
        ArrayList<AirQuality> list = new ArrayList<>();
        String data;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        while ((data = br.readLine()) != null) {
            AirQuality quality = new AirQuality();
            String[] split = data.split(",");
            quality.setDate(sdf.parse(split[0]));
            quality.setPm(Integer.parseInt(split[1]));
            quality.setCity(split[2]);
            quality.setRegion(split[3]);
            list.add(quality);
        }
        br.close();
        return list;
    }

    public List<Kz> getKZObject(Reader reader) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(reader);
        ArrayList<Kz> list = new ArrayList<>();
        String data;
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
        return list;
    }

    @Test
    public void testString2Date() throws IOException, ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String str = "20181201";
        Date date = sdf.parse(str);
        System.out.println();
    }


//    @Test
//    public void insertTest() throws IOException {
//        List<Goods> goodsObject = getGoodsObject();
//        goodsService.insert(goodsObject);
//        int i = 0;
//    }
}
