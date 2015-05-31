package TestQuestion;

import java.io.IOException;

public interface ITestException {
	// 无论加不加public abstract修饰符，编译器都会自动在前加上public abstract
	public boolean test(int arg) throws IOException;
	public boolean test(Integer arg) throws IOException;
}
