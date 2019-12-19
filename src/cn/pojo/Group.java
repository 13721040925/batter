package cn.pojo;

import java.util.Arrays;

public class Group {
	private String group_id;
	private Integer workV;// 电池组电压
	private Integer workI;// 电池组电流
	private Integer workR;// 电池组实际容量
	private Integer m;// 电池组单个个体数
	private Monomer[] monomers = new Monomer[m];// 单体电池对象
	private Integer n;// 电池组温度数
	private Integer dod;// DOD数据
	private Integer pointV;// 点电压数据
	private Integer surplusTime;// 放电剩余时长
	private Integer time;// 放电时长

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
