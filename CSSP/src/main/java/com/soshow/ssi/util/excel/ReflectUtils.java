package com.soshow.ssi.util.excel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.soshow.ssi.student.dto.Student;
 
/**
 * Java反射工具类
 * @author xieb
 *
 */
public class ReflectUtils {
 
    /**
     * 获取成员变量的修饰符
     * @param clazz
     * @param field
     * @return
     * @throws Exception
     */
    public static <T> int getFieldModifier(Class<T> clazz, String field) throws Exception {
        //getDeclaredFields可以获取所有修饰符的成员变量，包括private,protected等 getFields则不可以
        Field[] fields = clazz.getDeclaredFields();
 
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                return fields[i].getModifiers();
            }
        }
        throw new Exception(clazz+" has no field \"" + field + "\"");
    }
     
    /**
     * 获取成员方法的修饰符
     * @param clazz
     * @param method
     * @return
     * @throws Exception
     */
    public static <T> int getMethodModifier(Class<T> clazz, String method) throws Exception {
         
        //getDeclaredMethods可以获取所有修饰符的成员方法，包括private,protected等getMethods则不可以
        Method[] m = clazz.getDeclaredMethods();
 
        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals(m)) {
                return m[i].getModifiers();
            }
        }
        throw new Exception(clazz+" has no method \"" + m + "\"");
    }
     
    /**
     *  [对象]根据成员变量名称获取其值
     * @param clazzInstance
     * @param field
     * @return
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> Object getFieldValue(Object clazzInstance, Object field) 
    		throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field[] fields = clazzInstance.getClass().getDeclaredFields();
 
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                //对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
                fields[i].setAccessible(true);
                return fields[i].get(clazzInstance);
            }
        }
 
        return null;
    }
     
    /**
     *[类]根据成员变量名称获取其值（默认值）
     * @param clazz
     * @param field
     * @return
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> Object getFieldValue(Class<T> clazz, String field) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
 
        Field[] fields = clazz.getDeclaredFields();
 
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                //对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
                fields[i].setAccessible(true);
                return fields[i].get(clazz.newInstance());
            }
        }
 
        return null;
    }
 
    /**
     * 获取所有的成员变量
     * @param clazz
     * @return
     */
    public static <T> String[] getFields(Class<T> clazz) {
    	clazz.getSuperclass();
        Field[] fields = clazz.getDeclaredFields();
 
        String[] fieldsArray = new String[fields.length];
 
        for (int i = 0; i < fields.length; i++) {
            fieldsArray[i] = fields[i].getName();
        }
 
        return fieldsArray;
    }
    
    public static Field[] getClassFieldsAndSuperClassFields(Class<? extends Object> clazz) {
    	List<Field> fieldList = new ArrayList<Field>(); 
        for (; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            
            for (int i = 0; i < fields.length; i++) {
            	fieldList.add(fields[i]);
            }
		}
        return fieldList.toArray(new Field[fieldList.size()]);
	}
 
    /**
     * 指定类，调用指定的无参方法	--静态无参方法
     * @param clazz
     * @param method
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <T> Object invoke(Class<T> clazz, String method) 
    		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, 
    		InvocationTargetException, InstantiationException {
        Object instance = clazz.newInstance();
        Method m = clazz.getMethod(method, new Class[] {});
        return m.invoke(instance, new Object[] {});
    }
 
    /**
     * 通过对象，访问其方法	--实例无参方法
     * 
     * @param clazzInstance
     * @param method
     * @return
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <T> Object invoke(Object clazzInstance, String method) 
    		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, 
    		InvocationTargetException, InstantiationException {
        Method m = clazzInstance.getClass().getMethod(method, new Class[] {});
        return m.invoke(clazzInstance, new Object[] {});
    }
 
    /**
     * 指定类，调用指定的方法	--静态带参方法
     * 
     * @param clazz
     * @param method
     * @param paramClasses
     * @param params
     * @return Object
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static <T> Object invoke(Class<T> clazz, String method, Class<T>[] paramClasses, Object[] params) 
    		throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, 
    		IllegalArgumentException, InvocationTargetException {
        Object instance = clazz.newInstance();
        Method _m = clazz.getMethod(method, paramClasses);
        return _m.invoke(instance, params);
    }
 
    /**
     * 通过类的实例，调用指定的方法	--实例带参方法
     * 
     * @param clazzInstance
     * @param method
     * @param paramClasses
     * @param params
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static <T> Object invoke(Object clazzInstance, String method, Class<T>[] paramClasses, Object[] params) 
    		throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, 
    		IllegalArgumentException, InvocationTargetException {
        Method _m = clazzInstance.getClass().getMethod(method, paramClasses);
        return _m.invoke(clazzInstance, params);
    }
 
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
        // getFields(User.class);
        Student u = new Student();
        invoke(u, "setName", new Class[] { String.class }, new Object[] { "xx发大水法大水法x" });
        Field[] fildList =  getClassFieldsAndSuperClassFields(Student.class);
        for (Field str : fildList) {
        	 System.out.println(str.getName());
		}
       
    }
 
}