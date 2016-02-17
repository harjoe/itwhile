package itwhile.application.login;

import java.util.Map;
import itwhile.application.validate.GeneralValidator;

public interface LoginValidator extends GeneralValidator<LoginForm>
{

	public Map<?, ?> validate(LoginForm form);

}
