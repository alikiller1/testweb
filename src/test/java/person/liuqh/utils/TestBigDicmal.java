package person.liuqh.utils;

import java.math.BigDecimal;

public class TestBigDicmal {
	public static void main(String[] args) {
		Double a1=1.55;
		System.out.println(new BigDecimal(a1).setScale(1, BigDecimal.ROUND_HALF_DOWN));
		System.out.println(new BigDecimal(a1).setScale(1, BigDecimal.ROUND_HALF_UP));
		
		System.out.println(new BigDecimal(a1).setScale(1, BigDecimal.ROUND_DOWN));
		System.out.println(new BigDecimal(a1).setScale(1, BigDecimal.ROUND_UP));
		double d=9999999.99;
		System.out.println(d+"");
	}
}
