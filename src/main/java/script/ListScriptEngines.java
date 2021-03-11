package script;

import javax.script.ScriptEngineManager;

public class ListScriptEngines {
	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();

		manager.getEngineFactories().forEach(factory -> {
			String engineName = factory.getEngineName();
			String languageName = factory.getLanguageName();
			String version = factory.getLanguageVersion();

			System.out.println("Engine name:" + engineName + " Language:" + languageName + " Version:" + version);
		});
	}
}
