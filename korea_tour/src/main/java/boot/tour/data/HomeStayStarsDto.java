package boot.tour.data;

import lombok.Data;

@Data
public class HomeStayStarsDto {
	private String StarsNum;
	private double cleanliness;
	private double communication;
	private double checkin;
	private double accuracy;
	private double location;
	private double satisfactionForPrice;
	private String answerNum;
	private String homeNum;
}
