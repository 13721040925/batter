package cn.func;

import java.util.Date;

import cn.util.ClientToServer;
import cn.util.DateUtil;
import cn.util.ServerToClient;

public class SetCammdTime {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServerToClient sendCommond() {
		StringBuilder COMMAND_TIME = new StringBuilder();
		String systime = DateUtil.convertUtilDateToString(new Date());
		for (int i = 0; i < systime.length(); i++) {
			if (systime.charAt(i) == '-' || systime.charAt(i) == ' ' || systime.charAt(i) == ':') {
				continue;
			}
			COMMAND_TIME.append(systime.charAt(i));
		}
		String CID2 = "4E";
		String LENID = "00E";
		String INFO = COMMAND_TIME.toString();
		ServerToClient serverToClient = new ServerToClient();
		serverToClient.setVersion(this.version);
		serverToClient.setCID2(CID2);
		serverToClient.setLENID(LENID);
		serverToClient.setINFO(INFO);
		serverToClient.setCHKSUM();
		return serverToClient;
	}

	public boolean acceptCommond(String commond) {
		ClientToServer clientToServer = new ClientToServer();
		clientToServer.setCommond(commond);
		String res = clientToServer.toString();
		String RTN = res.substring(7, 9);
		String LENID = res.substring(10, 13);
		if (LENID.equals("000")) {
			System.out.println(">>>>>>>>>>>>>�趨���ù����豸ʱ��");
			if (panduan(RTN)) {
				return true;
			}
		}
		System.err.println(">>>>>>>>>>>>>�趨���ù����豸ʱ��ʧ��");
		return false;
	}

	public boolean panduan(String RTN) {
		switch (RTN) {
		case "00": {
			System.out.println("���ù����豸ʱ���趨�ɹ���");
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
