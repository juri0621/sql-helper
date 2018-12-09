package sqlhelper.impl;

import java.util.List;
import java.util.Map;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * SqlHelper에 관한 데이터처리 매퍼 클래스
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2018.12.09           최초생성
 *
 * @author MIN
 * @version 1.0
 * 
 */

@Mapper("sqlHelperMapper")
public interface SqlHelperMapper {
	
	/**
	 * 테이블 조회
	 * @param 
	 * @return 테이블 목록
	 * @exception Exception
	 */
	List<Map<String,Object>> selectSampleList(Map<String,Object> map) throws Exception;


}
