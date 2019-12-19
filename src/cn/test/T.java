package cn.test;

import java.math.BigDecimal;

public class T {

	// public static void main(String[] args) {
	//// int n = (byte) 0x30;
	//// char c = (char) n;
	//// System.out.println(n);
	//// System.out.println(c);
	//// char ch = (char) (byte) 0x30;
	//// System.out.println(ch);
	//
	// byte[] bt = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte)
	// 0x31, (byte) 0x34, (byte) 0x37,
	// (byte) 0x38, (byte) 0x34, (byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32,
	// (byte) 0x30,
	// (byte) 0x30 };
	// StringBuffer sb = new StringBuffer();
	// sb.append("~");
	// int sum = 0;
	// for (int i = 1; i < bt.length - 1; i++) {
	// char c = (char) bt[i];
	// sb.append(c);
	// sum = sum + bt[i];
	// System.out.println(bt[i]);
	// }
	// sb.append("\\R");
	// String res = sb.toString();
	// System.out.println(res);
	// System.out.println(sum);
	// System.out.println(Math.floorMod(sum, 65536));// 0000 0010 1010 0001
	//
	//// System.out.println(Math.floorMod((byte) 0x10, 16));
	////
	//// int iValue = Integer.parseInt("0FC", 16);// 无符号整型
	//// System.out.println(iValue);
	////
	//// System.out.println(Double.parseDouble(hexToNumber("8001",
	//// 1.0).toString()));
	////
	//// String s =
	////
	//// "~2001470050FC000C4E48B4A39E0C4E48B4A39E0C4E48B4A39E0C4E48B4A39E0C4E48B4A39E0C4E48B4A39E5F5394E6060194E60194E60194E60194E60194E60194E601A6B001A6B001A6B001A6B001A6B001A6B07D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D14C601";
	//// int sum = 0;
	//// for (int i = 1; i < s.length() - 4; i++) {
	//// sum += s.charAt(i);
	//// }
	//// System.out.println(sum);
	//// int module = Math.floorMod(sum, 65536);
	//// int fan = Changedegital.fanandadd1(module);
	//// System.out.println(fan);
	//// System.out.println(Changedegital.decToHex("" +
	//// fan).toUpperCase().equals(s.substring(s.length() - 4)));
	// }
	public static void main(String[] args) {
		System.out.println(Integer.parseInt("35", 16));// 0000 0011 0011 1111
	 }


	public static String toBinaryString(Integer number) {
		StringBuilder sb = new StringBuilder();
		for (int n = number; n > 0; n /= 2) {
			sb.append(n % 2);
		}
		return sb.toString();
	}
	/**
	 * 十六进制的字符串转换为byte数组
	 **/
	public static byte[] conver16HexToByte(String hex16Str) {
		char[] c = hex16Str.toCharArray();
		byte[] b = new byte[c.length / 2];
		for (int i = 0; i < b.length; i++) {
			int pos = i * 2;
			b[i] = (byte) ("0123456789ABCDEF".indexOf(c[pos]) << 4 | "0123456789ABCDEF".indexOf(c[pos + 1]));
		}
		return b;
	}

	/**
	 * byte数组转换为二进制字符串,每个字节以","隔开
	 **/
	public static String conver2HexStr(byte[] b) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			result.append(Long.toString(b[i] & 0xff, 2) + ",");
		}
		return result.toString().substring(0, result.length() - 1);
	}
	public static String toBinary(String str) {
		// 把字符串转成字符数组
		char[] strChar = str.toCharArray();
		String result = "";
		for (int i = 0; i < strChar.length; i++) {
			// toBinaryString(int i)返回变量的二进制表示的字符串
			// toHexString(int i) 八进制
			// toOctalString(int i) 十六进制
			result += Integer.toBinaryString(strChar[i]) + " ";
		}
		return result;
	}
	/**
	 * 16进制字符串转10进制数字（支持范围【0000~ffff】->【-32768~32767】）.<br>
	 * 例:hex=FF3D,precise=0.1返回为-19.5
	 * 
	 * @param hex
	 *            16进制字符串(长度4位)
	 * @param precise
	 *            数字精度
	 * @return 10进制数字
	 */
	public static Number hexToNumber(String hex, Double precise) {
		Integer ii = hexToInt(hex);
		if (precise.equals(1.0d)) {
			return ii;
		}
		return BigDecimal.valueOf(ii).multiply(BigDecimal.valueOf(precise)).doubleValue();
	}

	/**
	 * 16进制字符串转10进制整数.<br>
	 * 例:hex=0064->100、ff9b->65435、ff9c->-100、ffff->-1；
	 * 
	 * @param hex
	 *            16进制字符串(长度4位)
	 * @return 10进制整数
	 */
	public static Integer hexToInt(String hex) {
		String binaryString = "";
		String bs1 = appendZeroFirst(Integer.toBinaryString(Integer.valueOf(hex.substring(0, 2), 16)));
		String bs2 = appendZeroFirst(Integer.toBinaryString(Integer.valueOf(hex.substring(2, 4), 16)));
		binaryString = bs1 + bs2;
		if (binaryString.startsWith("1")) { // 二进制第一位为1，所以是负数
			// 1, 将第一位替换为0
			StringBuilder newBinaryString = new StringBuilder("0");
			// 2, 后15位取反得
			for (int i = 1; i < binaryString.length(); i++) {
				newBinaryString.append(binaryString.charAt(i) == '0' ? "1" : "0");
			}
			return (Integer.valueOf(newBinaryString.toString(), 2) + 1) * -1;
		} else {
			return Integer.valueOf(hex, 16) & 0xffff;
		}
	}

	private static String appendZeroFirst(String bs) {
		int bslen = bs.length();
		for (int i = 0; i < 8 - bslen; i++) {
			bs = "0" + bs;
		}
		return bs;
	}
}
