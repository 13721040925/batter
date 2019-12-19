package cn.func;

import cn.util.ClientToServer;
import cn.util.ServerToClient;

public class GetAddress {
	public ServerToClient sendCommond() {
		String VER = "10";// VER可以为任意值，但不能为空
		String CID2 = "50";
		String LENID = "000";
		String INFO = "";
		ServerToClient serverToClient = new ServerToClient();
		serverToClient.setVER(VER);
		serverToClient.setCID2(CID2);
		serverToClient.setLENID(LENID);
		serverToClient.setINFO(INFO);
		serverToClient.setCHKSUM();
		return serverToClient;
	}

	public String acceptCommond(String commond) {
		ClientToServer clientToServer = new ClientToServer();
		clientToServer.setCommond(commond);
		String res = clientToServer.toString();
		String RTN = res.substring(7, 9);
		String LENID = res.substring(10, 13);
		if (LENID.equals("000")) {
			System.out.println(">>>>>>>>>>>>>获取共用管理设备地址");
			if (panduan(RTN)) {
				String ADR = res.substring(3, 5);
				return ADR;
			}
		}
		System.err.println(">>>>>>>>>>>>>获取共用管理设备地址失败");
		return null;
	}

	public boolean panduan(String RTN) {
		switch (RTN) {
		case "00": {
			System.out.println("正常");
			return true;
		}
		case "01": {
			System.out.println("VER错");
			break;
		}
		case "02": {
			System.out.println("CHKSUM错");
			break;
		}
		case "03": {
			System.out.println("LCHKSUM错");
			break;
		}
		case "04": {
			System.out.println("CID2无效");
			break;
		}
		case "05": {
			System.out.println("命令格式错");
			break;
		}
		case "06": {
			System.out.println("无效数据");
			break;
		}
		case "07": {
			System.out.println("无数据");
			break;
		}
		case "E1": {
			System.out.println("CID1无效");
			break;
		}
		case "E2": {
			System.out.println("命令执行失败");
			break;
		}
		case "E3": {
			System.out.println("设备故障");
			break;
		}
		case "E4": {
			System.out.println("无效权限");
			break;
		}
		case "E5": {
			System.out.println("设备写保护");
			break;
		}
		case "FF": {
			System.out.println("不用返回响应包");
			break;
		}
		default: {
			System.out.println("其他错误");
			break;
		}
		}
		return false;

	}
}
