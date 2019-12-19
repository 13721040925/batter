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
		System.out.println("************获取模拟量量化后数据***********");
		String choose[] = { "获取所有电池组的数据和放电倒计时", "获取第1个电池组数据", "获取第2个电池组数据", "获取第3个电池组数据", "获取第4个电池组数据", "获取第5个电池组数据",
				"获取第6个电池组数据" };
	}
}
