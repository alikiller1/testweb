package per.liuqh.jedis;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7891087208801304182L;
	private String name;
	private int num;
	private BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	
}
