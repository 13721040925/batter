package cn.func;

import cn.util.ClientToServer;
import cn.util.ServerToClient;

/**
 * ��ȡ���ù����豸ʱ��������Ϣ
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
			System.out.println(">>>>>>>>>>>>>��ù��ù����豸ʱ����Ӧ��Ϣ");
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
		System.err.println(">>>>>>>>>>>>>���ù����豸ʱ����Ӧ��Ϣ��ȡʧ��");
		return null;
	}

	public boolean panduan(String RTN) {
		switch (RTN) {
		case "00": {
			System.out.println("����");
			return true;
		}
		case "01": {
			System.out.println("VER��");
			break;
		}
		case "02": {
			System.out.println("CHKSUM��");
			break;
		}
		case "03": {
			System.out.println("LCHKSUM��");
			break;
		}
		case "04": {
			System.out.println("CID2��Ч");
			break;
		}
		case "05": {
			System.out.println("�����ʽ��");
			break;
		}
		case "06": {
			System.out.println("��Ч����");
			break;
		}
		case "07": {
			System.out.println("������");
			break;
		}
		case "E1": {
			System.out.println("CID1��Ч");
			break;
		}
		case "E2": {
			System.out.println("����ִ��ʧ��");
			break;
		}
		case "E3": {
			System.out.println("�豸����");
			break;
		}
		case "E4": {
			System.out.println("��ЧȨ��");
			break;
		}
		case "E5": {
			System.out.println("�豸д����");
			break;
		}
		case "FF": {
			System.out.println("���÷�����Ӧ��");
			break;
		}
		default: {
			System.out.println("��������");
			break;
		}
		}
		return false;

	}
}
