package com.smart.place;

import com.smart.placeholder.MyDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.testng.Assert.assertNotNull;

public class PlaceHolderTest {

	@Test
	public void hold() throws Throwable {
		String resourceFile = "com/smart/placeholder/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
		DataSource ds = ctx.getBean(DataSource.class);
		Connection conn = ds.getConnection();
		assertNotNull(conn);
		System.out.println(ctx.getBean(MyDataSource.class));
	}
}
