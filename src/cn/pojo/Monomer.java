package cn.pojo;

public class Monomer {
	private String Monomer_id;
	private Integer mV;// �����ѹ
	private Integer nTem;// �����¶�

	public String getMonomer_id() {
		return Monomer_id;
	}

	public void setMonomer_id(String monomer_id) {
		Monomer_id = monomer_id;
	}

	public Integer getmV() {
		return mV;
	}

	public void setmV(Integer mV) {
		this.mV = mV;
	}

	public Integer getnTem() {
		return nTem;
	}

	public void setnTem(Integer nTem) {
		this.nTem = nTem;
	}

	@Override
	public String toString() {
		return "Monomer [Monomer_id=" + Monomer_id + ", mV=" + mV + ", nTem=" + nTem + "]";
	}

}
