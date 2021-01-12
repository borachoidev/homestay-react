package boot.tour.data;

import lombok.Data;

@Data
public class UserDto {
	private String userNum;
	private String email;
	private String name;
	private String birth;
	private String gender;
	private String photo;
	private String naverKey;
	private String kakaoKey;
	private String googleKey;
}
