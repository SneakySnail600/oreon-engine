package modules.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import engine.core.Util;
import engine.geometrics.Mesh;
import engine.geometrics.Vertex;
import engine.math.Vec3f;

public class GUIObjectLoader {

	public static Mesh load(String fileName)
	{
		String[] splitArray = fileName.split("\\.");
		String ext = splitArray[splitArray.length -1];
		
		if (ext.equals("gui")){
			ArrayList<Vertex> vertices = new ArrayList<Vertex>();
			ArrayList<Integer> indices = new ArrayList<Integer>();
			
			BufferedReader meshReader = null;
		
			try
			{
				meshReader = new BufferedReader(new FileReader("./res/models/gui/" + fileName));
				String line;
				while((line = meshReader.readLine()) != null)
				{
					String[] tokens = line.split(" ");
					tokens = Util.removeEmptyStrings(tokens);
				
					if(tokens.length == 0 || tokens[0].equals("#"))
						continue;
					
					if(tokens[0].equals("v"))
					{
						vertices.add(new Vertex(new Vec3f(Float.valueOf(tokens[1]),
														  Float.valueOf(tokens[2]),
														  Float.valueOf(tokens[3]))));
					}
					else if(tokens[0].equals("f"))
					{
						indices.add(Integer.parseInt(tokens[1]) - 1);
						indices.add(Integer.parseInt(tokens[2]) - 1);
						indices.add(Integer.parseInt(tokens[3]) - 1);
					}
				}
				meshReader.close();
				
				Vertex[] vertexData = new Vertex[vertices.size()];
				vertices.toArray(vertexData);
			
				Integer[] objectArray = new Integer[indices.size()];
				indices.toArray(objectArray);
				int[] indexData = Util.toIntArray(objectArray);
			
				Mesh mesh = new Mesh(vertexData, indexData);
			
				return mesh;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		else
		{
			System.err.println("Error: wrong file format for mesh data: " + ext);
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
}
