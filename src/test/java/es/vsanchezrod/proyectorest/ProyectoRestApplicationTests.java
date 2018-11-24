package es.vsanchezrod.proyectorest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"spring.data.mongodb.uri=mongodb://localhost:27017/fitnessdb"})
public class ProyectoRestApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}
