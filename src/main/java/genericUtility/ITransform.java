package genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class ITransform implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(genericUtility.RetryImp.class);
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
	}

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
	}

	@Override
	public void transform(IListenersAnnotation annotation, Class<?> testClass) {
	}
	
}
