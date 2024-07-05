package signin;

import member.MemberVO;

public interface SignInMapper {
	MemberVO findByEmail(SignInVO signin);
}
