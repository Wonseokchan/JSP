package login;

public interface LogInMapper {
	MemberVO findByEmailAndPassword(LoginVO login);
}
