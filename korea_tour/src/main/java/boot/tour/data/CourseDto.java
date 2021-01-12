package boot.tour.data;

import lombok.Data;

@Data
public class CourseDto {
	private String courseNum;
	private String name;
	private String customTag;
	private String selectTag;
	private String content;
	private int viewOrNot;
	private String contentIds;
	private int timesOfShare;
	private String userNum;
}
