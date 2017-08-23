package org.fastcode.common.serialization;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * Java原生序列化机制.
 * 与方法无关.
 * 
 * 安全.
 * 
 * </pre>
 *
 * @author F.Fang
 * @version $Id: JavaSerializableDemo.java, v 0.1 2014年10月29日 上午12:48:11 F.Fang Exp $
 */
public class ProtobuffSerialize {
 public static void main(String[] args) {
//	 Schema<Simple> schema = RuntimeSchema.getSchema(Simple.class);
	 List<Simple> list = new ArrayList<>();
	 for(int i=0;i<=100000;i++){
		 Simple simple = new Simple();
		 simple.setAge(22);
		 simple.setName("asdf"+i);
		 list.add(simple);
	 }

	 
	 long start = System.currentTimeMillis();
	 byte[] bytes = SerializationUtils.serializer(list);
	 long end = System.currentTimeMillis();
	 System.out.println("===serializer===:" + (end - start));
	 
	 start = System.currentTimeMillis();
	 List<Simple> simple2 = (List<Simple>)SerializationUtils.deserializer(bytes, List.class);
	 end = System.currentTimeMillis();
	 System.out.println("=====deserializer:" + (end - start));
	 System.out.println("==name:" + simple2.get(100000).getName());
}
}