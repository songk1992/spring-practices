package container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import container.config.soundsystem.CDPlayerConfig;
import container.config.videosystem.DVDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DVDPlayerConfig.class)
public class DVDPlayerJavaConfigTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd;
	
	
	@Autowired
	private DVDPlayer player;
	
	@Test
	// @Qualifier("dvdPlayer03") // 설정 클래스 Bean 생성 메소드 이름 : 기본 Bean ID
	@Qualifier("player04")
	public void testDVDNotNull() {
		assertNotNull(dvd);
	}
	
	@Test
	public void testDVDPlayerNotNull() {
		assertNotNull(player);
	}
	
	
	@Test
	@Qualifier("player06")
	public void testPlay() {
		player.play();
		assertEquals("playing film Marvel's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
