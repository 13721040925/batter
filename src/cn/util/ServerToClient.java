package cn.util;

import org.junit.Test;

public class ServerToClient {
	private String SOI = "7E";
	private String VER;
	private String version;
	private String ADR = "01";
	private String CID1 = "47";
	private String CID2;
	private String LENID;
	private String LENGTH;
	private String INFO;
	private String CHKSUM;

	public String getADR() {
		return ADR;
	}

	public void setADR(String aDR) {
		this.ADR = aDR;
	}

	public String getVER() {
		return VER;
	}

	public void setVER(String vER) {
		this.VER = vER;
	}

	public void setVersion(String version) {// ¸ñÊ½Îª1.0, 1.21
		this.version = version;
		String str = this.version.replace(".", ",");
		String arr1[] = str.split(",");
		this.VER = arr1[0] + Changedegital.decToHex(arr1[1]).toUpperCase();
	}

	public String getCID2() {
		return CID2;
	}

	public void setCID2(String cID2) {
		CID2 = cID2;
	}
	public void setLENID(String lENID) {
		this.LENID = lENID;
		String b = "0x0" + lENID.charAt(0);
		if (b.startsWith("0x") || b.startsWith("0X")) {
			b = b.substring(2);
		}
		int bint = Integer.valueOf(b, 16);
		String s = "0x0" + lENID.charAt(1);
		if (s.startsWith("0x") || s.startsWith("0X")) {
			s = s.substring(2);
		}
		int sint = Integer.valueOf(s, 16);
		String g = "0x0" + lENID.charAt(2);
		if (g.startsWith("0x") || g.startsWith("0X")) {
			g = g.substring(2);
		}
		int gint = Integer.valueOf(g, 16);
		int sum = bint + sint + gint;
		int mod = Math.floorMod(sum, 16);
		int then = Changedegital.fanandadd(mod);
		String q = Changedegital.intToHex(then);
		this.LENGTH = q + lENID;
	}

	public String getLENGTH() {
		return LENGTH;
	}

	public String getINFO() {
		return INFO;
	}

	public void setINFO(String iNFO) {
		this.INFO = iNFO;
	}

	public String getCHKSUM() {
		return CHKSUM;
	}

	public void setCHKSUM() {
		int sum = 0;
		String pin = this.VER + this.ADR + this.CID1 + this.CID2 + this.LENGTH + this.INFO;
		for (int i = 0; i < pin.length(); i++) {
			String s = "0x" + Changedegital.str2Hex(pin.charAt(i) + "");
			if (s.startsWith("0x") || s.startsWith("0X")) {
				s = s.substring(2);
			}
			int sint = Integer.valueOf(s, 16);
			sum += sint;
		}
		int mod = Math.floorMod(sum, 65536);
		int res = Changedegital.fanandadd1(mod);
		String q = Integer.toHexString(res).toUpperCase();
		this.CHKSUM = q;
	}

	@Override
	public String toString() {
		String pin = this.VER + this.ADR + this.CID1 + this.CID2 + this.LENGTH + this.INFO + this.CHKSUM;
		StringBuilder sb = new StringBuilder();
		sb.append("7E ");
		for (int i = 0; i < pin.length(); i++) {
			sb.append(Changedegital.str2Hex(pin.charAt(i) + "") + " ");
		}
		sb.append("0D");
		return sb.toString();
	}

	@Test
	public void test() {
		ServerToClient serverToClient = new ServerToClient();
		serverToClient.setVersion("1.0");
		serverToClient.setCID2("42");
		serverToClient.setLENID("002");
		serverToClient.setINFO("FF");
		serverToClient.setCHKSUM();
		System.out.println(serverToClient);
	}
}
