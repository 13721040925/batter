package cn.func;

import cn.util.ClientToServer;
import cn.util.ServerToClient;

/**
 * 获取共用管理设备时间命令信息
 * 
 * @author Administrator
 *
 */
public class GetCammdTime {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServerToClient sendCommond() {
		String CID2 = "4D";
		String LENID = "000";
		String INFO = "";
		ServerToClient serverToClient = new ServerToClient();
		serverToClient.setVersion(this.version);
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
		if (LENID.equals("00E")) {
			System.out.println(">>>>>>>>>>>>>获得共用管理设备时间响应信息");
			if (panduan(RTN)) {
				String year = res.substring(13, 17);
				String month = res.substring(17, 19);
				String day = res.substring(19, 21);
				String hour = res.substring(21, 23);
				String minute = res.substring(23, 25);
				String second = res.substring(25, 27);
				String datetime = "";
				datetime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
				return datetime;
			}
		}
		System.err.println(">>>>>>>>>>>>>共用管理设备时间响应信息获取失败");
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
