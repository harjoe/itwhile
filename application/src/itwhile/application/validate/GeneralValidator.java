package itwhile.application.validate;

import java.util.Map;

public interface GeneralValidator<T>
{
	public Map<?, ?> validate(T instance);
}
