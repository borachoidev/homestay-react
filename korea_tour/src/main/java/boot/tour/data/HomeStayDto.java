package boot.tour.data;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class HomeStayDto {
	private String homeNum;
	private String name;
	private String photoname;
	private List<String> upload;
	private String addr1;
	private String addr2;
	private String content;
	private int approveByAdmin;
	private String checkIn1;
	private String checkIn2;
	private String checkOut1;
	private String checkOut2;
	private Timestamp writeday;
	private int dogOk;
	private int smokingOk;
	private int price;
	private String maxPeople;
	private String email;
	private String hp;
	private String userNum;
	private String xpos;
	private String ypos;
	private double totalStarsGrade;
	private int wifi;
	private int towel;
	private int breakfast;
	private int aircon;
	private int elec_product;
	private int kitchen;
	private int bathroom;
	private int parking;
	
}
