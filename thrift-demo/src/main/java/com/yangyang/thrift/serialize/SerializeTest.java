package com.yangyang.thrift.serialize;

import com.yangyang.thrift.api.Pair;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by chenshunyang on 2016/10/31.
 */
public class SerializeTest {

    private static  String datafile = "D:/1.dat";

    // *) 把对象写入文件
    public static  void writeData() throws IOException, TException {
        Pair pair = new Pair();
        String key ="key1";
        String value ="value1";
        byte[] keyBytes = key.getBytes(Charset.forName("UTF-8"));
        byte[] valueBytes = value.getBytes(Charset.forName("UTF-8"));
        System.out.println("key length"+keyBytes.length+","+Hex.encodeHexString(keyBytes));
        System.out.println("value length"+valueBytes.length+","+Hex.encodeHexString(valueBytes));
        pair.setKey("key1").setValue("value1");


        FileOutputStream fos = new FileOutputStream(new File(datafile));
        pair.write(new TBinaryProtocol(new TIOStreamTransport(fos)));//thrift的binary协议见https://github.com/apache/thrift/blob/master/doc/specs/thrift-binary-protocol.md
        fos.close();
    }

    // *) 从文件恢复对象
    public static  void readData() throws TException, IOException {
        FileInputStream fis = new FileInputStream(new File(datafile));

        Pair pair = new Pair();
        pair.read(new TBinaryProtocol(new TIOStreamTransport(fis)));

        System.out.println("key => " + pair.getKey());
        System.out.println("value => " + pair.getValue());

        fis.close();
    }

    public static void main(String[] args) throws Exception{
        writeData();
//        readData();

    }
}
