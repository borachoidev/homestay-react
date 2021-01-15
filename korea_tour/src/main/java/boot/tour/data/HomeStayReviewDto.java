package boot.tour.data;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class HomeStayReviewDto {
	private String homeReviewNum;
	private String photoname;
	private List<String> upload;
	private Timestamp writeday;
	private String reply;
	private Timestamp replyWriteday;
	private String userNum;
	private String homeNum;
}
