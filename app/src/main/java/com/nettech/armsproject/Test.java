package com.nettech.armsproject;

import com.nettech.armsproject.uitls.EncodeUtils;

public class Test {
    public static void main(String[] args) {
        //System.out.print(TestUtils.sortValue(82, 73, 56, 88, 78));
        String nonceStr = EncodeUtils.makeNonceStr();
        System.out.println(nonceStr);
        String[] strings = EncodeUtils.makeSignHead(nonceStr, "http://app.qlqwgw.com/user/set");
        System.out.print(strings[0]+"\n"+strings[1]);
    }
}
