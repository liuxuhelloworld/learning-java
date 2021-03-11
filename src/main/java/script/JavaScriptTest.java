package script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptTest {
	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();

		ScriptEngine jsEngine = manager.getEngineByName("JavaScript");
		try {
			jsEngine.eval("print('Hello JavaScript in Java')");
		} catch (ScriptException e) {
			System.err.printf("JavaScript expression cannot be evaluated, {}" , e);
		}
	}
}
