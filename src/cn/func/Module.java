package cn.func;

import java.util.Scanner;

import org.junit.Test;

import cn.util.ServerToClient;

public class Module {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServerToClient sendCommond(String INFO) {
		String CID2 = "42";
		String LENID = "002";
		ServerToClient serverToClient = new ServerToClient();
		serverToClient.setVersion(this.version);
		serverToClient.setCID2(CID2);
		serverToClient.setLENID(LENID);
		serverToClient.setINFO(INFO);
		serverToClient.setCHKSUM();
		return serverToClient;
	}

	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("************��ȡģ��������������***********");
		String choose[] = { "��ȡ���е��������ݺͷŵ絹��ʱ", "��ȡ��1�����������", "��ȡ��2�����������", "��ȡ��3�����������", "��ȡ��4�����������", "��ȡ��5�����������",
				"��ȡ��6�����������" };
	}
}
