package test;

import java.util.List;

import org.apache.tomcat.util.codec.EncoderException;

public interface ITest {
	 <T extends Nothing> T func(List<T> list) throws EncoderException;
	 
     void funcfromedy();
	 void func2();
}
