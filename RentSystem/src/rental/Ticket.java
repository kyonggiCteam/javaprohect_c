package rental;

import java.util.Scanner;

import mgr.Manageable;

public class Ticket implements Manageable {
	public String code;
	public String brandName;
	public int price;
	public String ticketType;
	int hour;
	int month;
	
	@Override
	public void read(Scanner scan) {
		 code = scan.next();
		 brandName = scan.next();
		 price = scan.nextInt();
		 ticketType = scan.next();
		 hour = scan.nextInt();
		 month = scan.nextInt();
	}

	@Override
	public void print() {
		if (hour == 0)
			System.out.printf("[%s] %s %d원 %s %d개월\n", code, brandName, price, ticketType, month);
		else if (month == 0)
			System.out.printf("[%s] %s %d원 %s %d시간\n", code, brandName, price, ticketType, hour);
		else
			System.out.printf("[%s] %s %d원 %s %d개월 %d시간\n", code, brandName, price, ticketType, month, hour);	
	}
	
	public String[] getTexts() {
		// ticket의 브랜드 이름으로 찾아줌
		String vehiclekind = null;
		if(brandName.contentEquals("Lime") || brandName.contentEquals("beam") || brandName.contentEquals("SWING") ||
				brandName.contentEquals("지쿠터")) { // 킥보드일 경우
			vehiclekind = "킥보드";
		} else if (brandName.contentEquals("따릉이")) { // 자전거/킥보드
			vehiclekind = "자전거/킥보드";
		} else {
			vehiclekind = "자전거";
		}
		if (hour == 0)
			return new String[] {brandName, vehiclekind, ticketType, price+"원", month+"개월", code};
		else if (month == 0)
			return new String[] {brandName, vehiclekind, ticketType, price+"원", hour+"시간", code};
		else
			return new String[] {brandName, vehiclekind, ticketType, price+"원", month+"개월 "+hour+"시간", code};
	}

	@Override
	public boolean matches(String kwd) {
		if(code.equals(kwd))
			return true;
		if(ticketType.equals(kwd))
			return true;
		return false;
	}

}