package org.oreon.core.context;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.oreon.core.CoreEngine;
import org.oreon.core.RenderEngine;
import org.oreon.core.platform.GLFWInput;
import org.oreon.core.platform.Window;
import org.oreon.core.scenegraph.Camera;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseContext {

	@Getter
	protected static Config config;
	@Getter
	protected static GLFWInput input;
	@Getter
	protected static Camera camera;
	@Getter
//	protected static Window window;
	
	// Josh
	//---//
	public static Window window;
	public static ArrayList<Window> windows;
	//---//
	
	@Getter
	protected static CoreEngine coreEngine;
	@Getter
	@Setter
	protected static RenderEngine renderEngine;
	
	public static void init() {
		
		config = new Config();
		input = new GLFWInput();
		coreEngine = new CoreEngine();
	}

}
