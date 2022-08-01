package com.jiangzh.course.dubbodemo;

public class SerializeDemo {

    // 序列化一个int
    /*
        int -> 0x11 0x22 0x33 0x44
     */
    public static byte[] int2Bytes(int n){
        byte[] bytes = new byte[4];
        for(int i=0; i < bytes.length; i++){
            // 从后向前进行转换
            bytes[i] = (byte) (n >> (8*i));
        }
        return bytes;
    }

    // 反序列化
    /*
          0x44 0x33 0x22 0x11
     */
    public static int bytes2Int(byte[] bytes){
        int offset = 0;
        int result = bytes[offset] & 0xff
                | (bytes[offset + 1] << 8) & 0xff00
                | (bytes[offset + 2] << 8) & 0xff0000
                |(bytes[offset + 3] << 8) & 0xff000000;

        return result;
//        // 0x44 0xff -> 0x44
//        bytes[offset] & 0xff
//        // 0x33..  0xff00 -> 0x3300
//        (bytes[offset + 1] << 8) & 0xff00;
//        // 0x22....  0xff0000 -> 0x220000
//        (bytes[offset + 2] << 8) & 0xff0000;
//        // 0x11....  0xff000000 -> 0x11000000
//        (bytes[offset + 3] << 8) & 0xff000000;
        /*
                          0x44 |
                      0x3300 |
                  0x220000 |
              0x11000000
              0x11223344
         */
    }

}
