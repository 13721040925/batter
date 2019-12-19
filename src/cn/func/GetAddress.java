package cn.func;

import cn.util.ClientToServer;
import cn.util.ServerToClient;

public class GetAddress {
	public ServerToClient sendCommond() {
		String VER = "10";// VER����Ϊ����ֵ��������Ϊ��
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
			System.out.println(">>>>>>>>>>>>>��ȡ���ù����豸��ַ");
			if (panduan(RTN)) {
				String ADR = res.substring(3, 5);
				return ADR;
			}
		}
		System.err.println(">>>>>>>>>>>>>��ȡ���ù����豸��ַʧ��");
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
