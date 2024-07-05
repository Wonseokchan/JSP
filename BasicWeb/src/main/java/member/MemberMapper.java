package member;

import java.util.List;

public interface MemberMapper {
	List<MemberVO> selectMembers();

	MemberVO selectMember(long searchId);

	int insertMember(MemberVO member);

	int updateMember(MemberVO member);

	int deleteMember(long deleteid);
}
