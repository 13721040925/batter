package cn.pojo;

import java.util.Arrays;

public class Group {
	private String group_id;
	private Integer workV;// ������ѹ
	private Integer workI;// ��������
	private Integer workR;// �����ʵ������
	private Integer m;// ����鵥��������
	private Monomer[] monomers = new Monomer[m];// �����ض���
	private Integer n;// ������¶���
	private Integer dod;// DOD����
	private Integer pointV;// ���ѹ����
	private Integer surplusTime;// �ŵ�ʣ��ʱ��
	private Integer time;// �ŵ�ʱ��

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public Integer getWorkV() {
		return workV;
	}

	public void setWorkV(Integer workV) {
		this.workV = workV;
	}

	public Integer getWorkI() {
		return workI;
	}

	public void setWorkI(Integer workI) {
		this.workI = workI;
	}

	public Integer getWorkR() {
		return workR;
	}

	public void setWorkR(Integer workR) {
		this.workR = workR;
	}

	public Integer getM() {
		return m;
	}

	public void setM(Integer m) {
		this.m = m;
	}

	public Monomer[] getMonomers() {
		return monomers;
	}

	public void setMonomers(Monomer[] monomers) {
		this.monomers = monomers;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Integer getDod() {
		return dod;
	}

	public void setDod(Integer dod) {
		this.dod = dod;
	}

	public Integer getPointV() {
		return pointV;
	}

	public void setPointV(Integer pointV) {
		this.pointV = pointV;
	}

	public Integer getSurplusTime() {
		return surplusTime;
	}

	public void setSurplusTime(Integer surplusTime) {
		this.surplusTime = surplusTime;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Group [group_id=" + group_id + ", workV=" + workV + ", workI=" + workI + ", workR=" + workR + ", m=" + m
				+ ", monomers=" + Arrays.toString(monomers) + ", n=" + n + ", dod=" + dod + ", pointV=" + pointV
				+ ", surplusTime=" + surplusTime + ", time=" + time + "]";
	}

}
