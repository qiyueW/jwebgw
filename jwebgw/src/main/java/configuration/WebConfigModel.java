package configuration;



public class WebConfigModel extends system.web.config.temp.WebConfigModel {

    @Override
    public void config(system.web.config.temp.WebConfig config) {
        config.HM_SUFFIX = "*.jw";
    }

}