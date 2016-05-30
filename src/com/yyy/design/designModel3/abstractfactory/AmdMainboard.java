package com.yyy.design.designModel3.abstractfactory;

public class AmdMainboard implements Mainboard{
	/**
	 * CPU插槽的孔数
	 */
	private int cpuHoles = 0;

	/**
	 * 构造方法，传入CPU插槽的孔数
	 * 
	 * @param cpuHoles
	 */
	public AmdMainboard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	public void installCPU() {
		// TODO Auto-generated method stub
		System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
	}
}
