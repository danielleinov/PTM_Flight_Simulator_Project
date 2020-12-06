package interpreter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class GenericFactory<Command> {

	private interface Creator<Command>{
		public Command create();
	}

	Map<String,Creator<Command>> map;

	public GenericFactory() {
		map=new HashMap<>();
	}

	public void insertCommand(String key, Class<? extends Command> command) {
        map.put(key, () -> {
				try {
						return command.getDeclaredConstructor().newInstance();
				} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
						e.printStackTrace();
				}
			return null;
		});
	}

	public Command createCommand(String key){
		return map.containsKey(key) ? map.get(key).create() : null;
	}
}
