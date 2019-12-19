package cn.pojo;

public class Sys {
	private Integer countDown;// 放电倒计时
	private Integer totalTime;// 放电总时长
	private Integer onlionCount;// 电池组在线数量
	private String group_id1;
	private String group_id2;
	private String group_id3;
	private String group_id4;
	private String group_id5;
	private String group_id6;
	private Group group1;
	private Group group2;
	private Group group3;
	private Group group4;
	private Group group5;
	private Group group6;

	public Integer getCountDown() {
		return countDown;
	}

	public void setCountDown(Integer countDown) {
		this.countDown = countDown;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Integer getOnlionCount() {
		return onlionCount;
	}

	public void setOnlionCount(Integer onlionCount) {
		this.onlionCount = onlionCount;
	}

	public String getGroup_id1() {
		return group_id1;
	}

	public void setGroup_id1(String group_id1) {
		this.group_id1 = group_id1;
	}

	public String getGroup_id2() {
		return group_id2;
	}

	public void setGroup_id2(String group_id2) {
		this.group_id2 = group_id2;
	}

	public String getGroup_id3() {
		return group_id3;
	}

	public void setGroup_id3(String group_id3) {
		this.group_id3 = group_id3;
	}

	public String getGroup_id4() {
		return group_id4;
	}

	public void setGroup_id4(String group_id4) {
		this.group_id4 = group_id4;
	}

	public String getGroup_id5() {
		return group_id5;
	}

	public void setGroup_id5(String group_id5) {
		this.group_id5 = group_id5;
	}

	public String getGroup_id6() {
		return group_id6;
	}

	public void setGroup_id6(String group_id6) {
		this.group_id6 = group_id6;
	}

	public Group getGroup1() {
		return group1;
	}

	public void setGroup1(Group group1) {
		this.group1 = group1;
	}

	public Group getGroup2() {
		return group2;
	}

	public void setGroup2(Group group2) {
		this.group2 = group2;
	}

	public Group getGroup3() {
		return group3;
	}

	public void setGroup3(Group group3) {
		this.group3 = group3;
	}

	public Group getGroup4() {
		return group4;
	}

	public void setGroup4(Group group4) {
		this.group4 = group4;
	}

	public Group getGroup5() {
		return group5;
	}

	public void setGroup5(Group group5) {
		this.group5 = group5;
	}

	public Group getGroup6() {
		return group6;
	}

	public void setGroup6(Group group6) {
		this.group6 = group6;
	}

	@Override
	public String toString() {
		return "Sys [countDown=" + countDown + ", totalTime=" + totalTime + ", onlionCount=" + onlionCount
				+ ", group_id1=" + group_id1 + ", group_id2=" + group_id2 + ", group_id3=" + group_id3 + ", group_id4="
				+ group_id4 + ", group_id5=" + group_id5 + ", group_id6=" + group_id6 + ", group1=" + group1
				+ ", group2=" + group2 + ", group3=" + group3 + ", group4=" + group4 + ", group5=" + group5
				+ ", group6=" + group6 + "]";
	}

}
