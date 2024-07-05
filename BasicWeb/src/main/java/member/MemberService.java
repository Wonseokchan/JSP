package member;

import java.util.List;

import config.MybatisConfig;

public class MemberService {
	private MemberMapper mapper;
	private static MemberService instance = new MemberService();

	private MemberService() {
		mapper = MybatisConfig.session.getMapper(MemberMapper.class);
	}

	public static MemberService getInstance() {
		return instance;
	}

	public List<MemberVO> selectMembers() {
		return mapper.selectMembers();
	}

	public MemberVO selectMember(long searchId) {
		return mapper.selectMember(searchId);
	}

	public int insertMember(MemberVO member) {
		return mapper.insertMember(member);
	}

	public int updateMember(MemberVO member) {
		return mapper.updateMember(member);
	}

	public int deleteMember(long deleteid) {
		return mapper.deleteMember(deleteid);
	}
}
