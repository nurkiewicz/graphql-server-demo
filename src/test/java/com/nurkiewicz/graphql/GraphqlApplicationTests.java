package com.nurkiewicz.graphql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
		properties = "spring.sleuth.enabled=false"
)
public class GraphqlApplicationTests {

	@Test
	public void contextLoads() {
	}

}
