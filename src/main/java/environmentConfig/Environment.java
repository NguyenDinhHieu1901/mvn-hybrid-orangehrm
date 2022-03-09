package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${env}.properties" })
public interface Environment extends Config {

	@Key("app.url")
	String getApplicationUrl();

	@Key("app.username")
	String getUserName();

	@Key("app.password")
	String getPassword();
}
