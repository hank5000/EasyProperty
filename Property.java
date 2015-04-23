import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Property {
	Class SystemProperties = null;
	Method GET = null;
	Method SET = null;

	public boolean Init()
	{
		try {
			SystemProperties = Class.forName("android.os.SystemProperties");
	        Class[] paramTypes = new Class[1];
	        paramTypes[0] = String.class;
	        // get method first
			GET = SystemProperties.getMethod("get",paramTypes);
			SET = SystemProperties.getMethod("set",new Class[] {String.class, String.class});
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if( GET == null | SET == null)
		{
			return false;
		}
		return true;
	}

	public String GetProp(String prop) 
	{
		String ret = "FAIL";
		if(GET!=null)
		{
	        try {
				ret = (String) GET.invoke(SystemProperties, prop);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return ret;
	}

	public boolean SetProp(String prop,String value) 
	{
		boolean ret = false;

		if(SET!=null)
		{
	        try {
				SET.invoke(SystemProperties, new Object[] {prop, value});
				ret = true;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
}
