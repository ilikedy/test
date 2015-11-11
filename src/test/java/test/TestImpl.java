package test;

import java.util.List;

import org.apache.tomcat.util.codec.EncoderException;

public abstract class TestImpl implements ITest {

	public <T extends Nothing> T func(List<T> list) throws EncoderException   {
		if(list == null){
			throw new EncoderException();
		}
		return null;
	}

	@Override
	public void func2() {
		// TODO Auto-generated method stub
		
	}

}
