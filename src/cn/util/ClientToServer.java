package cn.util;

public class ClientToServer {
	private String commond;
	private String arr[];

	public String getCommond() {
		return commond;
	}

	public void setCommond(String commond) {
		this.commond = commond;
		this.arr = this.commond.split(" ");
	}

	public String[] getArr() {
		return arr;
	}

	public String getVER() {
		String VER = Changedegital.hex2Str(this.arr[1]) + Changedegital.hex2Str(this.arr[2]);
		return VER;

	}

	public String getADR() {
		String ADR = Changedegital.hex2Str(this.arr[3]) + Changedegital.hex2Str(this.arr[4]);
		return ADR;

	}

	public String getCID1() {
		String CID1 = Changedegital.hex2Str(this.arr[5]) + Changedegital.hex2Str(this.arr[6]);
		return CID1;

	}

	public String getCID2() {
		String CID2 = Changedegital.hex2Str(this.arr[7]) + Changedegital.hex2Str(this.arr[8]);
		return CID2;
	}

	public String getLENGTH() {
		String LENGTH = Changedegital.hex2Str(this.arr[9]) + Changedegital.hex2Str(this.arr[10])
				+ Changedegital.hex2Str(this.arr[11]) + Changedegital.hex2Str(this.arr[12]);
		return LENGTH;

	}

	// INFO项的ASCII码字节数
	public int getLENID() {
		String LENGTH = getLENGTH();
		String str = LENGTH.substring(1, LENGTH.length());
		return Changedegital.hexStringToAlgorism(str);

	}

	public String getINFO() {
		int LENID = getLENID();
		int len = LENID / 2;
		String INFO = "";
		for (int i = 1; i <= len * 2; i++) {
			INFO += Changedegital.hex2Str(arr[12 + i]);
		}
		return INFO;

	}

	public String getCHKSUM() {
		String CHKSUM = Changedegital.hex2Str(this.arr[this.arr.length - 5])
				+ Changedegital.hex2Str(this.arr[this.arr.length - 4])
				+ Changedegital.hex2Str(this.arr[this.arr.length - 3])
				+ Changedegital.hex2Str(this.arr[this.arr.length - 2]);
		return CHKSUM;

	}

	@Override
	public String toString() {
		String result = "~" + getVER() + getADR() + getCID1() + getCID2() + getLENGTH() + getINFO() + getCHKSUM()
				+ "\\R";
		return result;
	}

}
