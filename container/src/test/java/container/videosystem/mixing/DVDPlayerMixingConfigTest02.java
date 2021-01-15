package container.videosystem.mixing;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import container.config.videosystem.DVDPlayerConfig;
import container.config.videosystem.mixing.VideoSystemConfig;
import container.videosystem.DVDPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=VideoSystemConfig.class)
public class DVDPlayerMixingConfigTest02 {

	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testPlayerNotNull() {
		assertNotNull(player);
	}
}
