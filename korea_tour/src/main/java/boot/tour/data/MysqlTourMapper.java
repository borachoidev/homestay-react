package boot.tour.data;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MysqlTourMapper {
	public String getMain();
}
